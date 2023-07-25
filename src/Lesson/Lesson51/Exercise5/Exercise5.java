package Lesson.Lesson51.Exercise5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.out;

public class Exercise5 {
    public static void main(String[] args) throws ParseException {
        var input = new Scanner(System.in);
        String empFileName = "EMP.DAT";
        ArrayList<Employee> employees = new ArrayList<>(readEmpFromFile(empFileName));
        updateEmployeeId(employees);
        var choice = 0;
        do {
            out.println("=========================MENU=========================");
            out.println("= 1. Thêm mới nhân viên hoặc giám đốc vào danh sách  =");
            out.println("= 2. Hiển thị danh sách nhân viên                    =");
            out.println("= 3. Tìm nhân viên theo tên                          =");
            out.println("= 4. Tìm nhân viên có mức lương >= X                 =");
            out.println("= 5. Tìm giám đốc theo nhiệm kì                      =");
            out.println("= 6. Xóa nhân viên theo mã cho trước                 =");
            out.println("= 7. Tính lương cho nhân viên                        =");
            out.println("= 8. Tính thưởng cho nhân viên                       =");
            out.println("= 9. Hiển thị mức lương và cách nhận thưởng của NV   =");
            out.println("= 10.Hiển thị bảng lương                             =");
            out.println("= 11.Ghi danh sách nhân viên vào file                =");
            out.println("= 0 .Kết thúc chương trình                           =");
            out.println("======================================================");
            out.println("==============> Xin mời lựa chọn <====================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    out.println("===> Chương trình kết thúc !Hẹn gặp lại <===");
                    break;
                case 1:
                    out.println("Nhập 1 . Thêm mới nhân viên ");
                    out.println("Nhập 2 . Thêm mới giám đốc ");
                    var slot = input.nextInt();
                    if (slot == 1) {
                        var emp = createNewEmployee(input);
                        employees.add(emp);
                        out.println("====> Thêm mới nhân viên thành công <===");
                    } else if (slot == 2) {
                        var man = createNewManager(input);
                        employees.add(man);
                    } else {
                        out.println("===> Sai lựa chọn ! Vui lòng chọn lại <===");
                    }
                    // updateEmpId(employees);
                    break;
                case 2:
                    showEmployees(employees);
                    break;
                case 3:
                    if (employees.size() > 0) {
                        out.println("Nhập tên cần tìm kiếm : ");
                        input.nextLine();
                        var name = input.nextLine();
                        var result = findEmpById(employees, name);
                        showResult(result);
                    } else {
                        out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
                    }
                    break;
                case 4:
                    if (employees.size() > 0) {
                        out.println("Nhập mức lương cần tìm kiếm : ");
                        input.nextLine();
                        var salary = Float.parseFloat(input.nextLine());
                        var result = findEmpBySalary(employees, salary);
                        showResult(result);
                    } else {
                        out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
                    }
                    break;
                case 5:
                    if (employees.size() > 0) {
                        out.println("Nhập năm bắt đầu nhiệm kì : ");
                        input.nextLine();
                        var startYear = input.nextInt();
                        out.println("Nhập năm kết thúc nhiệm kì : ");
                        var endYear = input.nextInt();
                        var result = findManagerByTerm(employees, startYear, endYear);
                        showResult(result);
                    } else {
                        out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
                    }
                    break;
                case 6:
                    if (employees.size() > 0) {
                        out.println("Nhập mã nhân viên cần xóa : ");
                        input.nextLine();
                        var empId = input.nextLine();
                        var isSuccess = removeEmpById(employees, empId);
                        if (isSuccess) {
                            out.println("====> Xóa ID : " + empId + " thành công <====");
                        } else {
                            out.println("====> Xóa ID : " + empId + " thất bại <====");
                        }
                    } else {
                        out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
                    }
                    break;
                case 7:
                    var isSuccess = calculSalary(employees);
                    if (isSuccess) {
                        out.println("====> Tính lương cho nhân viên thành công <====");
                    } else {
                        out.println("====> Tính lương cho nhân viên thất bại <====");
                    }
                    break;
                case 8:
                    var isValid = calculBonus(employees);
                    if (isValid) {
                        out.println("====> Tính lương cho nhân viên thành công <====");
                    } else {
                        out.println("====> Tính lương cho nhân viên thất bại <====");
                    }
                    break;
                case 9:
                    if (employees.size() > 0) {
                        showBonus(employees);
                    } else {
                        out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
                    }
                    break;
                case 10:
                    if (employees.size() > 0) {
                        showSalary(employees);
                    } else {
                        out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
                    }
                    break;
                case 11:
                    if (employees.size() > 0) {
                        var isWriteSuccess = writeEmpToFile(employees, empFileName);
                        if (isWriteSuccess) {
                            out.println("=====> Ghi file thành công <=====");
                        } else {
                            out.println("=====> Ghi file thất bại <=====");
                        }
                    } else {
                        out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
                    }
                    break;
                default:
                    out.println("===> Sai chức năng ! Vui lòng chọn lại <===");
            }
        } while (choice != 0);
    }

    private static void updateEmployeeId(ArrayList<Employee> employees) {
        int maxId = 1000; // giả định rằng ban đầu chưa có nhân viên nào
        // duyệt danh sách nhân viên
        for (var emp : employees) {
            // tách và chuyển phần số trong mã nhân viên ra thành giá trị int
            var curId = Integer.parseInt(emp.getEmpId().substring(3));
            if (curId > maxId) { // nếu mã này lớn hơn mã nhân viên maxId
                maxId = curId; // cập nhật mã maxId
            }
        }
        // thiết lập mã cho nhân viên kế tiếp
        Employee.setNextId(maxId + 1);
    }

    /**
     * phương thức này dùng để ghi thông tin của danh sách nhân viên
     * vào file. Chỉ ghi thông tin các nhân viên chưa xuất hiện trong file
     * không bảo toàn dữ liệu trong file để update file.
     *
     * @param employees   danh sách nhân viên cần ghi
     * @param empFileName tên file cần ghi
     * @return true nếu ghi file thành công và false nếu ngược lại
     */
    private static boolean writeEmpToFile(ArrayList<Employee> employees, String empFileName) {
        try {
            PrintWriter printWriter = new PrintWriter(empFileName);
            var format = "dd/MM/yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            for (var emp : employees) {
                if (emp instanceof Manager) {
                    printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%f-%f-%f-%f-%f-%s-%s\n",
                            emp.getId(), emp.getFullName(),
                            emp.getAddress(), dateFormat.format(emp.getBitrhDay()),
                            emp.getEmail(), emp.getNumber(), emp.getEmpId(),
                            emp.getDuty(), emp.getSalary(), emp.getExperience(),
                            emp.getWorkingDay(), emp.getTotalSalary(), emp.getBonus(),
                            dateFormat.format(((Manager) emp).getStart()),
                            dateFormat.format(((Manager) emp).getEnd()));
                } else {
                    printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%f-%f-%f-%f-%f\n",
                            emp.getId(), emp.getFullName(),
                            emp.getAddress(), dateFormat.format(emp.getBitrhDay()),
                            emp.getEmail(), emp.getNumber(), emp.getEmpId(),
                            emp.getDuty(), emp.getSalary(), emp.getExperience(),
                            emp.getWorkingDay(), emp.getTotalSalary(), emp.getBonus());
                }
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * phương thức hiển thị
     * bảng lương của từng nhân viên
     *
     * @param employees danh sách nhân viên  gốc
     */
    private static void showSalary(ArrayList<Employee> employees) {
        out.printf("%-15s%-25s%-15s%-15s%-15s%-20s\n", "Mã NV", "Tên NV",
                "Mức lương", "Số ngày làm", "Thưởng", "Tổng lương");
        for (var emp : employees) {
            out.printf("%-15s%-25s%-15.2f%-15.2f%-15.2f%-20.2f\n", emp.getEmpId(),
                    emp.getFullName(), emp.getSalary(),
                    emp.getWorkingDay(), emp.getBonus(), emp.getTotalSalary());
        }
    }

    /**
     * phương thức hiển thị
     * mức thưởng và cách nhận thưởng cho từng nhân viên
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void showBonus(ArrayList<Employee> employees) {
        out.printf("%-15s%-25s%-15s%-25s\n", "Mã NV",
                "Tên NV", "Bonus", "Hình thức nhận");
        for (var emp : employees) {
            out.printf("%-15s%-25s%-15.2f%-25s\n", emp.getEmpId(),
                    emp.getFullName(), emp.getBonus(), emp.receiBonus());
        }
    }

    /**
     * phương thức tính thưởng cho nhân viên
     *
     * @param employees danh sách nhân viên gốc
     * @return true nếu tính thành công ,false nếu thất bại
     */
    private static boolean calculBonus(ArrayList<Employee> employees) {
        if (employees.size() > 0) {
            for (var item : employees) {
                item.calculBounsEmp();
            }
            return true;
        } else {
            out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
            return false;
        }
    }

    /**
     * phương thức tính lương cho nhân viên
     *
     * @param employees danh sách nhân viên gốc
     * @return true nếu tính thành công,false nếu thất bại
     */
    private static boolean calculSalary(ArrayList<Employee> employees) {
        if (employees.size() > 0) {
            for (var item : employees) {
                item.calculSalary();
            }
            return true;
        } else {
            out.println("====> Danh sách nhân viên và giám đốc rỗng <====");
            return false;
        }
    }

    /**
     * phương thức xóa nhân viên
     * theo mã cho trước
     *
     * @param employees danh sách nhân viên gốc
     * @param empId     mã nhân  viên cần xóa
     * @return true nếu xóa thành công ,false nếu xóa thất bại
     */
    private static boolean removeEmpById(ArrayList<Employee> employees, String empId) {
        for (var item : employees) {
            if (item.getEmpId().compareToIgnoreCase(empId) == 0) {
                employees.remove(item);
                return true;
            }
        }
        out.println("====> Mã ID : " + empId + " không tồn tại <====");
        return false;
    }

    /**
     * phương thức tìm kiếm  giám đốc
     * theo nhiệm kì
     *
     * @param employees danh sách nhân viên gốc
     * @param startYear năm bắt đầu nhiệm kì
     * @param endYear   năm kết thúc nhiệm kì
     * @return ArrayList chứa kết quả
     */
    private static ArrayList<Employee> findManagerByTerm(ArrayList<Employee> employees, int startYear, int endYear) {
        ArrayList<Employee> managers = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (var item : employees) {
            var manager = (Manager) item;
            calendar.setTime(manager.getStart());
            var start = calendar.get(Calendar.YEAR);
            calendar.setTime(manager.getEnd());
            var end = calendar.get(Calendar.YEAR);
            // nếu nhiệm kì cần tìm nằm trong giai đoạn
            // nhiệm kì của manager hiện tại, add vào danh sách kết quả
            if (start <= startYear && end >= endYear) {
                managers.add(manager);
            }
        }
        return managers;
    }

    /**
     * phương thức tìm kiếm nhân viên
     * có mức lương >X
     *
     * @param employees danh sách nhân viên gốc
     * @param salary    mức lương cần tìm kiếm
     * @return ArrayList chứa kết quả
     */
    private static ArrayList<Employee> findEmpBySalary(ArrayList<Employee> employees, float salary) {
        ArrayList<Employee> emp = new ArrayList<>();
        for (var item : employees) {
            if (item.getSalary() >= salary) {
                emp.add(item);
            }
        }
        return emp;
    }

    /**
     * phương thức hiển thị  kết quả tìm kiếm
     *
     * @param result kết quả cần hiển thị
     */
    private static void showResult(ArrayList<Employee> result) {
        ArrayList<Employee> emp = new ArrayList<>();
        ArrayList<Manager> man = new ArrayList<>();
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        for (var item : result) {
            if (item instanceof Manager) {
                var s = (Manager) item;
                man.add(s);
            } else {
                emp.add(item);
            }
        }
        out.println("===> Kết quả tìm kiếm : " + emp.size() + " nhân viên và " + man.size() + " giám đốc <===");
        if (emp.size() > 0) {
            out.println("========> Thông tin " + emp.size() + " nhân viên <=====");
            out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s\n",
                    "Số CMT", "Tên NV", "Địa chỉ", "Ngày sinh", "Email",
                    "Số ĐT", "Mã NV", "Chức vụ", "Lương", "Kinh nghiệm");
            for (var item : emp) {
                showEmp(item, dateFormat);
            }
        }
        if (man.size() > 0) {
            out.println("=======> Thông tin " + man.size() + " giám đốc <=======");
            showManagers(man, dateFormat);
        }
    }


    /**
     * phương thức tìm kiếm nhân viên theo tên
     *
     * @param employees danh sách nhân viên gốc
     * @param name      tên cần tìm
     * @return mảng chứa kết quả
     */
    private static ArrayList<Employee> findEmpById(ArrayList<Employee> employees, String name) {
        ArrayList<Employee> emp = new ArrayList<>();
        for (var item : employees) {
            if (item.getAFullName().getFirst().compareToIgnoreCase(name) == 0) {
                emp.add(item);
            }
        }
        return emp;
    }

    /**
     * phương thức hiển thị danh sách nhân viên ,gồm giám đốc
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void showEmployees(ArrayList<Employee> employees) {
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Employee> employees1 = new ArrayList<>();
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        for (var emp : employees) {
            if (emp instanceof Manager) {
                var man = (Manager) emp;
                managers.add(man);
            } else {
                employees1.add(emp);
            }
        }
        if (employees1.size() > 0) {
            out.println("========> Danh sách nhân viên <=====");
            out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s\n",
                    "Số CMT", "Tên NV", "Địa chỉ", "Ngày sinh", "Email",
                    "Số ĐT", "Mã NV", "Chức vụ", "Lương", "Kinh nghiệm");
            for (var emp : employees1) {
                showEmp(emp, dateFormat);
            }
        } else {
            out.println("=====> Danh sách nhân viên rỗng <=====");
        }
        if (managers.size() > 0) {
            out.println("=======> Danh sách giám đốc <=======");
            showManagers(managers, dateFormat);
        } else {
            out.println("=====> Danh sách giám đốc rỗng <======");
        }
    }

    /**
     * phương thức hiển thị danh sách giám đốc
     *
     * @param managers   danh sách giám đốc gốc
     * @param dateFormat định dạng ngày
     */
    private static void showManagers(ArrayList<Manager> managers, SimpleDateFormat dateFormat) {
        out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "Số CMT", "Tên NV", "Địa chỉ", "Ngày sinh", "Email",
                "Số ĐT", "Mã NV", "Chức vụ", "Lương", "Kinh nghiệm", "Bắt đầu ", "Kết thúc");
        for (var man : managers) {
            showMan(man, dateFormat);
        }
    }

    /**
     * phương thức hiển thị từng giám đốc
     *
     * @param man        giám đốc cần hiển thị
     * @param dateFormat định dạng ngày
     */
    private static void showMan(Manager man, SimpleDateFormat dateFormat) {
        out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s%-15.2f%-15.2f%-15s%-15s\n", man.getId(), man.getFullName(),
                man.getAddress(), dateFormat.format(man.getBitrhDay()), man.getEmail(), man.getNumber(), man.getEmpId(),
                man.getDuty(), man.getSalary(), man.getExperience(), man.getWorkingDay(), man.getBonus(), man.getTotalSalary()
                , man.getStart(), man.getEnd());
    }

    /**
     * phương thức hiển thị từng nhân viên
     * không phải giám đốc
     *
     * @param emp        nhân viên hiển thị
     * @param dateFormat định dạng ngày
     */
    private static void showEmp(Employee emp, SimpleDateFormat dateFormat) {
        out.printf("%-12s%-25s%-15s%-15s%-20s%-15s%-15s%-15s%-15.2f%-15.2f\n", emp.getId(), emp.getFullName(),
                emp.getAddress(), dateFormat.format(emp.getBitrhDay()), emp.getEmail(), emp.getNumber(), emp.getEmpId(),
                emp.getDuty(), emp.getSalary(), emp.getExperience(), emp.getWorkingDay(), emp.getBonus(), emp.getTotalSalary());
    }


    private static Manager createNewManager(Scanner input) {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        var emp = createNewEmployee(input);
        Date start = null;
        Date end = null;
        try {
            out.println("Nhập ngày bắt đầu nhiệm kì : ");
            start = dateFormat.parse(input.nextLine());
            out.println("Nhập ngày kết thúc nhiệm kì : ");
            end = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            start = new Date();
            end = new Date();
            e.printStackTrace();
        }
        return new Manager(emp, start, end);
    }

    /**
     * phương thức dùng để đọc dữ liệu nhân viên từ file
     *
     * @param empFileName là tên file cần đọc
     * @return danh sách sinh viên đọc được hoặc rỗng nếu file rỗng
     */
    private static ArrayList<Employee> readEmpFromFile(String empFileName) {
        ArrayList<Employee> employees = new ArrayList<>();
        var file = new File(empFileName);
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            file.createNewFile();
            var input = new Scanner(file);
            while (input.hasNextLine()) {
                var line = input.nextLine();
                var data = line.split("-");
                Employee employee = createEmpFromData(data, dateFormat);
                if (employee != null) {
                    employees.add(employee);
                }
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    /**
     * phương thức tách và tạo thông tin đối tượng nhân viên hoặc
     * giám đốc
     *
     * @param data       dữ liệu đã tách
     * @param dateFormat định dạng thời gian
     * @return đối tượng được tham chiếu đến bởi kiểu Employee
     */
    private static Employee createEmpFromData(String[] data, SimpleDateFormat dateFormat) {
        var id = data[0];
        var fullName = data[1];
        var address = data[2];
        Date dob = null;
        try {
            dob = dateFormat.parse(data[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var email = data[4];
        var phoneNum = data[5];
        var empId = data[6];
        var duty = data[7];
        var salary = Float.parseFloat(data[8]);
        var exp = Float.parseFloat(data[9]);
        var workingDay = Float.parseFloat(data[10]);
        var totalSalary = Float.parseFloat(data[11]);
        var bonus = Float.parseFloat(data[12]);
        Date start = null;
        Date end = null;
        if (data.length > 13) {
            try {
                start = dateFormat.parse(data[13]);
                end = dateFormat.parse(data[14]);
                return new Manager(id, fullName, address, dob,
                        email, phoneNum, empId, duty,
                        salary, exp, workingDay, totalSalary, bonus, start, end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            return new Employee(id, fullName, address, dob,
                    email, phoneNum, empId, duty,
                    salary, exp, workingDay, totalSalary, bonus);
        }
        return null;
    }

    /**
     * phương  thức thêm mới 1 nhân viên
     *
     * @param input đối tượng lớp Scanner
     * @return đối tượng vừa tạo
     */
    private static Employee createNewEmployee(Scanner input) {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        out.println("Nhập số CCCD /CMND : ");
        input.nextLine();
        var id = input.nextLine();
        out.println("Nhập họ tên : ");
        var name = input.nextLine();
        out.println("Nhập địa chỉ : ");
        var address = input.nextLine();
        out.println("Nhập ngày sinh : ");
        Date dob = null;
        try {
            dob = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
            dob = new Date();//nhập,mặc định ngày sinh là hiện tại
        }
        out.println("Nhập email : ");
        var email = input.nextLine();
        out.println("Nhập số điện thoại : ");
        var number = input.nextLine();
        out.println("Nhập chức vụ : ");
        var duty = input.nextLine();
        out.println("Nhập mức lương : ");
        var salary = Float.parseFloat(input.nextLine());
        out.println("Nhập kinh nghiệm : ");
        var exp = Float.parseFloat(input.nextLine());
        out.println("Nhập ngày công : ");
        var workingDay = Float.parseFloat(input.nextLine());
        return new Employee(id, name, address, dob, email, number, null, duty, salary, exp, workingDay, 0, 0);
    }
}
