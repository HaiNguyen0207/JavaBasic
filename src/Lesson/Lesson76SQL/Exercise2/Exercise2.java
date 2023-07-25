package Lesson.Lesson76SQL.Exercise2;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Exercise2 {
    private static String USER = "hainguyen";
    private static String PASSWORD = "0207";
    private static String SEVER_NAME = "DESKTOP-CPFJBV6\\SQLEXPRESS";
    private static String DB_NAME = "Lesson78SQL";
    private static int PORT_NUMBER = 1433;

    public static void main(String[] args) {
        SQLServerDataSource dataSource = dataSource();
        var input = new Scanner(System.in);
        List<BankAccount> bankAccounts = new LinkedList<>();
        var dataSQL = readDataFromSQL(dataSource);
        var choice = 0;
        if (dataSQL != null) {
            bankAccounts.addAll(dataSQL);
            System.out.println("===> Load toàn bộ dữ liệu trong SQL hoàn tất ! <===");
        } else {
            System.out.println("==> Dữ liệu trong SQL không hợp lệ ! Không thể cập nhật <===");
        }
        updateId(bankAccounts); //cập nhật mã tài khoản tự động tăng
        do {
            System.out.println("============================> MENU <============================");
            System.out.println("= 1. Thêm mới 1 tài khoản .Cập nhật vào CSDL                   =");
            System.out.println("= 2. Sửa số dư tài khoản theo STK .Cập nhật vào CSDL           =");
            System.out.println("= 3. Xóa tài khoản theo số thể .Cập nhật vào CSDL              =");
            System.out.println("= 4. Nạp tiền vào tài khoản theo STK. Cập nhật vào CSDL        =");
            System.out.println("= 5. Rút tiền vào tài khoản theo STK. Cập nhật vào CSDL        =");
            System.out.println("= 6. Chuyển tiền theo STK.Cập nhật vào CSDL                    =");
            System.out.println("= 7. Thực hiện TT hóa đơn theo số thẻ. Cập nhật vào CSDL       =");
            System.out.println("= 8. Sắp xếp tài khoản theo chủ TK từ A-Z                      =");
            System.out.println("= 9. Sắp xếp tài khoản theo số dư giảm dần                     =");
            System.out.println("= 10.Hiển thị danh sách hiện có theo dạng cột                  =");
            System.out.println("= 0. Kết thúc chương trình                                     =");
            System.out.println("================================================================");
            System.out.println("===================> Mời bạn bạn chức năng <====================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("=======> Chương trình kết thúc ! Hẹn gặp lại <========");
                    break;
                case 1:
                    var acc = createNewBankAccount(input);
                    bankAccounts.add(acc);
                    System.out.println("==> Thêm tài khoản vào danh sách thành công <===");
                    System.out.println("==> Bạn muốn thêm tài khoản vào CSDL không ?");
                    System.out.println("==> 1. Có ");
                    System.out.println("==> 2. Không");
                    var slot = Integer.parseInt(input.nextLine());
                    if (slot == 1) {
                        var isSuccess = addAccountToSQL(dataSource, acc);
                        if (isSuccess == 1) {
                            System.out.println("==> Đã thêm tài khoản vào SQL thành công <===");
                        } else {
                            System.out.println("===> Có ngoại lệ xảy ra ! Thêm tài khoản vào SQL thất bại <===");
                        }
                    } else if (slot == 2) {
                        System.out.println("====> Đã hủy thêm tài khoản vào SQL <====");
                    } else {
                        System.out.println("=====> Sai chức năng ! Vui lòng xem lại <===");
                    }
                    break;
                case 2:
                    if (bankAccounts.size() > 0) {
                        System.out.println("Nhập số tài khoản cần sửa  : ");
                        input.nextLine();
                        var account = input.nextLine();
                        System.out.println("Nhập số dư cần sửa : ");
                        var amount = Double.parseDouble(input.nextLine());
                        var isSuccess = changsSurplusInSQL(dataSource, account, amount);
                        if (isSuccess == 1) {
                            System.out.println("====> Thay dổi số dư trong bảng SQL thành công <=====");
                        } else {
                            System.out.println("====> Thay dổi số dư trong bảng SQL thất bại  <=====");
                        }
                    } else {
                        System.out.println("======> Danh sách tài khoản rỗng <====");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    if (bankAccounts.size() > 0) {
                        showBankAccounts(bankAccounts);
                    } else {
                        System.out.println("============> Danh sách tài khoản rỗng <=========");
                    }
                    break;
                default:
                    System.out.println("======> Chức năng không hợp lệ ! Vui lòng chọn lại  <==========");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * phương thức thay đổi số dư trong bảng CSDL
     *
     * @param dataSource kết nối SQL
     * @param account    số tài khoản cần thay đổi số dư
     * @param amount     số dư thay đổi
     * @return 1 nếu thay đổi thành công , -1 nếu thất bại
     */
    private static int changsSurplusInSQL(SQLServerDataSource dataSource,
                                          String account, double amount) {

        try (var connect = dataSource.getConnection()) {
            //tìm xem stk có xuất hiện trong SQL không ?
            var accSQL = findAccountInSQL(dataSource, account);
            if (accSQL) {
                var sql = " UPDATE [dbo.Exercise2] SET (SURPLUS = ? )" +
                        " WHERE NUMBER_ACCOUNT = ?";
                var prepareStatement = connect.prepareStatement(sql);
                prepareStatement.setDouble(1, amount);
                prepareStatement.setString(2, account);
                return prepareStatement.executeUpdate();
            } else {
                System.out.println("====> Số tài khoản không tồn tại trong CSDL <====");
                return -1;
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    /**
     * phương thức kiểm tra xem stk có trong bảng CSDL không ?
     *
     * @param dataSource kết nối SQL
     * @param account    stk cẩn tìm
     * @return null nếu không xuất hiện !
     */
    private static boolean findAccountInSQL(SQLServerDataSource dataSource, String account) {
        var sql = "SELECT * FROM dbo.Exercise2";
        try (var connect = dataSource.getConnection()) {
            var prepareStatement = connect.prepareStatement(sql);
            var resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                var numberAcc = resultSet.getString(3);
            }
            return false;
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    /**
     * phương thức thêm tài khoản
     * vào SQL
     *
     * @param dataSource SQL
     * @param acc        tài khoản thêm
     */
    private static int addAccountToSQL(SQLServerDataSource dataSource,
                                       BankAccount acc) {
        var sql = "INSERT INTO dbo.Exercise2(ID,NUMBER_CARD," +
                "NUMBER_ACCOUNT,FULLNAME,SURPLUS) VALUES(?,?,?,?,?)";
        try (var connect = dataSource.getConnection()) {
            var prepareStatement = connect.prepareStatement(sql);
            prepareStatement.setInt(1, acc.getId());
            prepareStatement.setString(2, acc.getNumberCard());
            prepareStatement.setString(3, acc.getNumberAcc());
            prepareStatement.setString(4, acc.getName());
            prepareStatement.setDouble(5, acc.getSurplus());
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
     * phương thức thêm mới 1 tài khoản
     *
     * @param input đối tượng lớp Scanner
     * @return đối tượng vừa tạo
     */
    private static BankAccount createNewBankAccount(Scanner input) {
        System.out.println("Nhập số thẻ : ");
        input.nextLine();
        var numberCard = input.nextLine();
        System.out.println("Nhập số tài khoản : ");
        var numberAcc = input.nextLine();
        System.out.println("Nhập chủ tài khoản ");
        var fullName = input.nextLine();
        System.out.println("Nhập số dư : ");
        var surplus = Float.parseFloat(input.nextLine());
        return new BankAccount(0, numberCard, numberAcc, fullName, surplus);
    }

    /**
     * phương thức hiển thị danh sách tài khoản
     * theo dạng cột
     *
     * @param bankAccounts danh sách tài khoản cần hiển thị
     */
    private static void showBankAccounts(List<BankAccount> bankAccounts) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Mã ID", "Số Thẻ",
                "Số TK", "Họ Tên", "Số Dư");
        for (var e : bankAccounts) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20.2f\n", e.getId(),
                    e.getNumberCard(), e.getNumberAcc(), e.getName(), e.getSurplus());
        }
    }

    /**
     * phương thức cập nhật mã tài khoản tự động tăng
     * mỗi tài khoản chỉ có 1 mã
     *
     * @param bankAccounts danh sách tài khoản gốc
     */
    private static void updateId(List<BankAccount> bankAccounts) {
        var maxId = 1;
        for (var e : bankAccounts) {
            var curId = e.getId();
            if (curId > maxId) {
                maxId = curId;
            }
        }
        BankAccount.setNextId(maxId + 1);
    }

    /**
     * phương thức load toàn bộ dữ liệu từ bảng trong csdl
     * trước khi chạy chương trình
     *
     * @param dataSource công SQL
     * @return dữ liệu ,null nếu xảy ra ngoại lệ
     */
    private static List<BankAccount> readDataFromSQL(SQLServerDataSource dataSource) {
        List<BankAccount> bankAccounts = new LinkedList<>();
        var sql = "SELECT * FROM dbo.Exercise2";
        try (var connect = dataSource.getConnection()) {
            var prepareStatement = connect.prepareStatement(sql);
            var resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                var id = resultSet.getInt(1);
                var numberCard = resultSet.getString(2);
                var numberAccount = resultSet.getString(3);
                var fullName = resultSet.getString(4);
                var surplus = resultSet.getFloat(5);
                bankAccounts.add(new BankAccount(id, numberCard, numberAccount, fullName, surplus));
            }
            return bankAccounts;
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    /**
     * phương thức kết nối với cống SQL
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
