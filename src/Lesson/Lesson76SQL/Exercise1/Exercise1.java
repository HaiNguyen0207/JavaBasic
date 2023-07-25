package Lesson.Lesson76SQL.Exercise1;

import Lesson.Lesson76SQL.Exercise1.Sort.SortCatByAgeAsc;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise1 {
    private static String USER = "hainguyen";
    private static String PASSWORD = "0207";
    private static String SEVER_NAME = "DESKTOP-CPFJBV6\\SQLEXPRESS";
    private static String DB_NAME = "Lesson78SQL";
    private static int PORT_NUMBER = 1433;

    public static void main(String[] args) throws InValidAgeException {
        var input = new Scanner(System.in);
        SQLServerDataSource dataSource = dataSource();
        Cat cat = new Cat();
        List<Cat> cats = new LinkedList<>();
        var dataSQL = readDataFromSQL(dataSource, cat);
        if (dataSQL != null) {
            cats.addAll(dataSQL);
            System.out.println("==> Load toàn bộ dữ liệu từ SQL hoàn tất <===");
        } else {
            System.out.println("==> Dữ liệu trong bảng SQL không hợp lệ ! Load thất bại <==");
        }
        updateCatId(cats);
        var choice = 0;
        do {
            System.out.println("==========================MENU==========================");
            System.out.println("= 1. Thêm mới một con mèo vào danh sách                =");
            System.out.println("= 2. Sắp xếp mèo tuổi tăng dần                         =");
            System.out.println("= 3. Sắp xếp mèo tuổi giảm dần                         =");
            System.out.println("= 4. Sắp xếp mèo theo tên A-Z                          =");
            System.out.println("= 5. Tìm kiếm mèo theo tên gần đúng                    =");
            System.out.println("= 6. Hiển thị danh sách mèo ra màn hình                =");
            System.out.println("= 7. Ghi các con mèo chưa xuất hiện vào bảng CSDL      =");
            System.out.println("= 8. Ghi danh sách con mèo vào file                    =");
            System.out.println("= 0. Kết thúc chương trình                             =");
            System.out.println("========================================================");
            System.out.println("===============> Nhập lựa chọn của bạn <================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("=======> Chương trình đã kết thúc <=========");
                    break;
                case 1:
                    var newCat = createNewCat(input, cat);
                    if (newCat != null) {
                        cats.add(newCat);
                        System.out.println("==> Thêm mới con mèo thành công <===");
                    } else {
                        System.out.println("==> Thêm mới con mèo thất bại  <===");
                    }
                    break;
                case 2:
                    if (cats.size() > 0) {
                        System.out.println("===> Danh sách sắp xếp theo tuổi tăng dần <=====");
                        var catCoy = copyListCat(cats);
                        Collections.sort(catCoy, new SortCatByAgeAsc());
                        showCats(catCoy);
                    } else {
                        System.out.println("=====> Danh sách con mèo rỗng <=====");
                    }
                    break;
                case 3:
                    if (cats.size() > 0) {
                        System.out.println("===> Danh sách sắp xếp theo tuổi giảm dần <=====");
                        var catCoy = copyListCat(cats);
                        Collections.sort(catCoy, new SortCatByAgeAsc());
                        showCats(catCoy);
                    } else {
                        System.out.println("=====> Danh sách con mèo rỗng <=====");
                    }
                    break;
                case 4:
                    if (cats.size() > 0) {
                        System.out.println("Nhập tên cần tìm kiếm : ");
                        input.nextLine();
                        var name = input.nextLine();
                        var result = findCatByName(cats, name);
                        if (result.size() > 0) {
                            System.out.println("===> Đã tìm thấy " + result.size() + " kết quả <===");
                            showCats(result);
                        } else {
                            System.out.println("====> Kết quả tìm kiếm không có tên : " + name + " <====");
                        }
                    } else {
                        System.out.println("===> Danh sách con mèo rỗng <====");
                    }
                    break;
                case 5:
                    break;
                case 6:
                    if (cats.size() > 0) {
                        System.out.println("======> Danh sách con mèo <=======");
                        showCats(cats);
                    } else {
                        System.out.println("=====> Danh sách con mèo rỗng <=====");
                    }
                    break;
                case 7:
                    if (cats.size() > 0) {
                        var isSuccess = writeListCatToSQL(cats, dataSource);
                        if (isSuccess > 0) {
                            System.out.println("===> Ghi dữ liệu vào SQL hoàn tất <====");
                        } else {
                            System.out.println("====> Ghi dữ liệu vào SQL thất bại <====");
                        }
                    } else {
                        System.out.println("===> Danh sách con mèo rỗng <====");
                    }
                    break;
                case 8:
                    if (cats.size() > 0) {
                        var isSuccess = writeListCatToFile(cats);
                        if (isSuccess) {
                            System.out.println("===> Ghi dữ liệu vào SQL hoàn tất <====");
                        } else {
                            System.out.println("====> Ghi dữ liệu vào SQL thất bại <====");
                        }
                    } else {
                        System.out.println("===> Danh sách con mèo rỗng <====");
                    }
                    break;
                default:
                    System.out.println("===> Sai chức năng ! Vui lòng chọn lại <====");
                    break;

            }
        } while (choice != 0);
    }

    /**
     * phương thức ghi danh sách con mèo vào file
     * thao tác bằng file nhị phân
     *
     * @param cats danh sách gốc
     * @return true nếu ghi thành công ,false nếu thất bại
     */
    private static boolean writeListCatToFile(List<Cat> cats) {
        var fileName = "CAT.DAT";
        File file = new File(fileName);
        try (FileOutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            file.createNewFile();
            objectOutputStream.writeObject(cats);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * phương thức ghi danh sách
     * vào bảng dữ liệu csdl
     *
     * @param cats       danh sách con mèo
     * @param dataSource kết nối vs SQL
     * @return
     */
    private static int writeListCatToSQL(List<Cat> cats, SQLServerDataSource dataSource) {
        try (var connect = dataSource.getConnection()) {
            var sql = "INSERT INTO dbo.exercise1(ID,Color,Age,Food, " +
                    "EyeColor ,PetName) VALUES (?,?,?,?,?,?)";
            var prepareStatement = connect.prepareStatement(sql);
            for (var e : cats) {
                prepareStatement.setString(1, e.getId());
                prepareStatement.setString(2, e.getColor());
                prepareStatement.setInt(3, e.getAge());
                prepareStatement.setString(4, e.getFood());
                prepareStatement.setString(5, e.getEyeColor());
                prepareStatement.setString(6, e.getPetName());
            }
            return prepareStatement.executeUpdate();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    /**
     * phương thức tìm kiếm theo tên gần đúng
     *
     * @param cats danh sách con mèo
     * @param name tên cần tìm
     * @return List chứa kết quả
     */
    private static List<Cat> findCatByName(List<Cat> cats, String name) {
        List<Cat> result = new LinkedList<>();
        Pattern pattern = Pattern.compile(".*" + name + ".*",
                Pattern.CASE_INSENSITIVE);
        for (var e : cats) {
            Matcher matcher = pattern.matcher(e.getPetName());
            if (matcher.matches()) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * phương thức copy danh sách con mèo để sắp xếp
     * không làm ảnh hưởng đến danh sách ban đầu
     *
     * @param cats danh sách gốc
     * @return
     */
    private static List<Cat> copyListCat(List<Cat> cats) {
        ArrayList<Cat> catCopy = new ArrayList<>();
        for (var e : cats) {
            catCopy.add(e);
        }
        return catCopy;
    }

    /**
     * phương thức hiển thị danh sách con mèo
     * theo dạng cột
     *
     * @param cats danh sách con mèo
     */
    private static void showCats(List<Cat> cats) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Mã ID",
                "Màu lông", "Tuổi", "Thức Ăn", "Màu Mắt", "Tên gọi");
        for (var e : cats) {
            System.out.printf("%-20s%-20s%-20d%-20s%-20s%-20s\n", e.getId(),
                    e.getColor(), e.getAge(), e.getFood(), e.getEyeColor(), e.getPetName());
        }
    }

    /**
     * phương thức tạo mã mới cho con mèo
     * mặc định mã con mèo đầu là 1001
     * các con sau tăng theo thứ tự tăng dần
     *
     * @param cats danh sách  con mèo
     */
    private static void updateCatId(List<Cat> cats) {
        int maxId = 1000;
        for (var e : cats) {
            var strId = e.getId().substring(3, 7);
            var curId = Integer.parseInt(strId);
            if (curId > maxId) {
                maxId = curId;
            }
        }
        Cat.setNextId(maxId + 1);
    }

    /**
     * phương thức thêm mới con mèo
     *
     * @param input đối tượng lớp Scanner
     * @param cat   đối tượng cat
     * @return đội tượng vừa tạo
     * @throws InValidAgeException xử lý ngoại lệ
     */
    private static Cat createNewCat(Scanner input, Cat cat)
            throws InValidAgeException {
        System.out.println("Nhập màu lông : ");
        input.nextLine();
        var color = input.nextLine();
        System.out.println("Nhập tuổi : ");
        var age = Integer.parseInt(input.nextLine());
        try {
            cat.setAge(age);
        } catch (InValidAgeException e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.println("Nhập thức ăn : ");
        var food = input.nextLine();
        System.out.println("Nhập màu mắt : ");
        var eyeColor = input.nextLine();
        System.out.println("Nhập tên gọi : ");
        var name = input.nextLine();
        return new Cat(null, color, age, food, eyeColor, name);
    }

    /**
     * phương thức đọc dữ liệu từ bảng csdl
     * chuyển thành trường dữ liệu của Cat
     *
     * @param dataSource kết nối SQL
     * @param cat        đối tượng Cat
     * @return
     */
    private static List<Cat> readDataFromSQL(SQLServerDataSource dataSource, Cat cat) {
        List<Cat> cats = new LinkedList<>();
        try (var connect = dataSource.getConnection();) {
            var sql = "SELECT * FROM dbo.exercise1";   //câu lệnh truy vấn sql
            var prepareStatement = connect.prepareStatement(sql);
            var resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                var id = resultSet.getString(1);
                var color = resultSet.getString(2);
                var age = resultSet.getInt(3);
                try {
                    cat.setAge(age);
                } catch (InValidAgeException e) {
                    return null;
                }
                var food = resultSet.getString(4);
                var eyeColor = resultSet.getString(5);
                var petName = resultSet.getString(6);
                cats.add(new Cat(id, color, age, food, eyeColor, petName));
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } catch (InValidAgeException e) {
            e.printStackTrace();
            return null;
        }
        return cats;
    }

    /**
     * phương thức kết nối với cổng SQL
     *
     * @return
     */
    private static SQLServerDataSource dataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setServerName(SEVER_NAME);
        dataSource.setDatabaseName(DB_NAME);
        dataSource.setPortNumber(PORT_NUMBER);
        return dataSource;
    }
}
