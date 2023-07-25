package Lesson.Lesson55.Exercise5;


import Lesson.Lesson55.Exercise5.Sort.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

public class Exercise5 {
    public static void main(String[] args) throws IOException, ParseException {
        var input = new Scanner(System.in);
        var fileName = "EMP.DAT";
        var format = "dd/MM/yyyy";
        var choice = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        ArrayList<Employee> employees = new ArrayList<>(readFromEmpFile(fileName, dateFormat));
        createNewEmployees(employees, dateFormat);
        updateEmpId(employees); //cập nhật id cho nhân viên
        do {
            System.out.println("===================== MENU =====================");
            System.out.println("= 1. Thêm mới 1 nhân viên                      =");
            System.out.println("= 2. Hiển thị thông tin các nhân viên          =");
            System.out.println("= 3. Tìm nhân viên theo tên                    =");
            System.out.println("= 4. Tìm nhân viên có mức lương >= x           =");
            System.out.println("= 5. Tìm giám đốc theo nhiệm kì                =");
            System.out.println("= 6. Xóa nhân viên theo mã cho trước           =");
            System.out.println("= 7. Tính lương nhân viên                      =");
            System.out.println("= 8. Tính thưởng nhân viên                     =");
            System.out.println("= 9. Sắp xếp danh sách nhân viên               =");
            System.out.println("= 10. Hiển thị mức thưởng và cách nhận thưởng  =");
            System.out.println("= 11. Hiển thị bảng lương                      =");
            System.out.println("= 12. Lưu danh sách nhân viên, giám đốc        =");
            System.out.println("= 0. Thoát chương trình                        =");
            System.out.println("================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("=======> Chương trình đã kết thúc <======");
                    break;
                case 1:
                    System.out.println("Chọn 1 : Thêm mới nhân viên ");
                    System.out.println("Chọn 2 : Thêm mới giám đốc ");
                    var selection = input.nextInt();
                    if (selection == 1) {
                        var emp = createNewEmployee(input, dateFormat);
                        employees.add(emp);
                        System.out.println("======> Thêm mới nhân viên thành công <=======");
                    } else if (selection == 2) {
                        var man = createNewManager(input, dateFormat);
                        employees.add(man);
                        System.out.println("==> Thêm mới giám đốc thành công <====");
                    }
                    break;
                case 2:
                    if (employees.size() > 0) {
                        showEmployees(employees, dateFormat);
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 3:
                    if (employees.size() > 0) {
                        System.out.println("Nhập tên cần tìm : ");
                        input.nextLine();
                        var name = input.nextLine();
                        findEmpByName(employees, name, dateFormat);
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 4:
                    if (employees.size() > 0) {
                        System.out.println("Nhập mức lương cần tìm : ");
                        var salary = input.nextFloat();
                        findEmpBySalary(employees, salary, dateFormat);
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 5:
                    if (employees.size() > 0) {
                        System.out.println("Nhập năm bắt đầu cần tìm kiếm");
                        var startYear = input.nextInt();
                        System.out.println("Nhập năm kết thúc cần tìm kiếm : ");
                        var endYear = input.nextInt();
                        findManagerByTerm(employees, startYear, endYear, dateFormat);
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 6:
                    if (employees.size() > 0) {
                        System.out.println("Nhập mã nhân viên cần xóa : ");
                        input.nextLine();
                        var id = input.nextLine();
                        var isSuccess = removeEmpById(employees, id);
                        if (isSuccess) {
                            System.out.println("====> Đã xóa ID : " + " thành công <====");
                        } else {
                            System.out.println("====> Đã xóa ID : " + " thất bại <====");
                        }
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 7:
                    if (employees.size() > 0) {
                        calculSalary(employees);
                        System.out.println("====> Tính lương cho nhân viên thành công <====");
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 8:
                    if (employees.size() > 0) {
                        calculBonus(employees);
                        System.out.println("====> Tính thưởng cho nhân viên thành công <====");
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 9:
                    if (employees.size() > 0) {
                        System.out.println("Chọn tiêu chí sắp xếp: ");
                        System.out.println("1. Tên tăng dần a-z");
                        System.out.println("2. Tên giảm dần z-a");
                        System.out.println("3. Mức lương tăng dần");
                        System.out.println("4. Mức lương giảm dần");
                        System.out.println("5. Số năm kinh nghiệm tăng dần");
                        System.out.println("6. Số năm kinh nghiệm giảm dần");
                        System.out.println("7. Từ trẻ đến già");
                        System.out.println("8. Từ già đến trẻ");
                        System.out.println("9. Tổng lương thực lĩnh giảm dần");
                        var option = input.nextInt();
                        sortEmployees(employees, option, dateFormat);

                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 10:
                    if (employees.size() > 0) {
                        showBonus(employees);
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 11:
                    if (employees.size() > 0) {
                        showPayroll(employees);
                    } else {
                        System.out.println("=====> Danh sách nhân viên và giám đốc rỗng <==");
                    }
                    break;
                case 12:
                    if (employees.size() > 0) {
                        var isSuccess = witeEmpToFile(employees, fileName, dateFormat);
                        if (isSuccess) {
                            System.out.println("=====> Ghi file thành công <====");
                        } else {
                            System.out.println("=====> Ghi file thất bại <====");
                        }
                    } else {
                        System.out.println("====> Danh sách nhân viên và giám đốc rỗng ! Ghi file thất bại <==");
                    }
                    break;
                default:
                    System.out.println("======> Sai chức năng ! Vui lòng chọn lại <========");
            }
            System.out.println("Xin mời bạn chọn: ");
        } while (choice != 0);

    }

    /**
     * phương thức sắp xếp
     * danh sách nhân viên
     *
     * @param employees  danh sách nhân viên gốc
     * @param option     lựa chọn sắp xếp
     * @param dateFormat định dạng ngày
     */
    private static void sortEmployees(ArrayList<Employee> employees, int option, SimpleDateFormat dateFormat) {
        if (option == 1) {
            Collections.sort(employees, new SortEmpByNameAsc());
            System.out.println("====> Danh sách nhân viên theo tên tăng dần A - Z <===");
            showEmps(employees, dateFormat);
        } else if (option == 2) {
            Collections.sort(employees, new SortEmpByNameDec());
            System.out.println("====> Danh sách nhân viên theo tên giảm dần Z - A <===");
            showEmps(employees, dateFormat);
        } else if (option == 3) {
            Collections.sort(employees, new SortEmpBySalaryAsc());
            System.out.println("====> Danh sách nhân viên theo mức lương tăng dần <===");
            showEmps(employees, dateFormat);
        } else if (option == 4) {
            Collections.sort(employees, new SortEmpBySalaryDec());
            System.out.println("====> Danh sách nhân viên theo mức lương giảm dần <===");
            showEmps(employees, dateFormat);
        } else if (option == 5) {
            Collections.sort(employees, new SortEmpByExpAsc());
            System.out.println("====> Danh sách nhân viên theo kinh nghiệm tăng dần <===");
            showEmps(employees, dateFormat);
        } else if (option == 6) {
            Collections.sort(employees, new SortEmpByExpDec());
            System.out.println("====> Danh sách nhân viên theo kinh nghiệm giảm dần <===");
            showEmps(employees, dateFormat);
        } else if (option == 7) {
            Collections.sort(employees, new SortEmpByAgeDec());
            System.out.println("====> Danh sách nhân viên theo tuổi tăng dần <===");
            showEmps(employees, dateFormat);
        } else if (option == 8) {
            Collections.sort(employees, new SortEmpByAgeAsc());
            System.out.println("====> Danh sách nhân viên theo tuổi giảm dần <===");
            showEmps(employees, dateFormat);
        } else if (option == 9) {
            Collections.sort(employees, new SortByEmpTotalSalary());
            System.out.println("===> Danh sách nhân viên theo tổng lương tăng dần <===");
            showEmps(employees, dateFormat);
        } else {
            System.out.println("=======> Sai chức năng ! Vui lòng chọn lại <=========");
        }
    }

    /**
     * phương thức hiển thị
     * sau khi sắp xếp
     *
     * @param employees  danh sách nhân viên gốc
     * @param dateFormat định dạng ngày
     */
    private static void showEmps(ArrayList<Employee> employees, SimpleDateFormat dateFormat) {
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-15s%-20s\n", "Mã NV", "Họ Tên", "Ngày sinh",
                "Chức vụ", "Mức lương", "Kinh nghiệm", "Tổng lương");
        for (var item : employees) {
            System.out.printf("%-15s%-20s%-20s%-20s%-20.2f%-15.2f%-20.2f\n", item.getEmpId(),
                    item.getFullNameString(), dateFormat.format(item.getBirthDay()), item.getPesition(),
                    item.getSalary(), item.getExperciene(), item.getTotalSalary());
        }
    }

    /**
     * phương thức ghi danh sách nhân viên
     * vào file
     *
     * @param employees  danh sách nhân viên gốc
     * @param fileName   tên file
     * @param dateFormat định dạng ngày
     * @return true nếu ghi thành công ,false ngược lại
     * @throws IOException xử lý ngoại lệ
     */
    private static boolean witeEmpToFile(ArrayList<Employee> employees, String fileName,
                                         SimpleDateFormat dateFormat) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(fileName);
        for (var emp : employees) {
            if (emp instanceof Manager) {
                var man = (Manager) emp;
                printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%.2f-%.2f-%.2f-%.2f-%.2f-%s-%s\n",
                        man.getId(), man.getFullNameString(),
                        man.getAddress(), dateFormat.format(man.getBirthDay()),
                        man.getEmail(), man.getNumber(), man.getEmpId(),
                        man.getPesition(), man.getSalary(), man.getExperciene(),
                        man.getWorkingDay(), man.getTotalSalary(), man.getBonus(),
                        dateFormat.format(man.getStartDate()),
                        dateFormat.format(man.getEndDate()));
            } else {
                printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%.2f-%.2f-%.2f-%.2f-%.2f\n",
                        emp.getId(), emp.getFullNameString(),
                        emp.getAddress(), dateFormat.format(emp.getBirthDay()),
                        emp.getEmail(), emp.getNumber(), emp.getEmpId(),
                        emp.getPesition(), emp.getSalary(), emp.getExperciene(),
                        emp.getWorkingDay(), emp.getTotalSalary(), emp.getBonus());
            }
        }
        printWriter.close();
        return true;
    }

    /**
     * phương thức hiển thị bảng lương
     * của từng nhân viên
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void showPayroll(ArrayList<Employee> employees) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Mã NV", "Họ Tên",
                "Mức Lương", "Ngày công", "Thưởng", "Tổng lương");
        for (var item : employees) {
            System.out.printf("%-20s%-20s%-20.2f%-20.2f%-20.2f%-20.2f\n", item.getEmpId(),
                    item.getFullNameString(), item.getSalary(), item.getWorkingDay(),
                    item.getBonus(), item.calculTotalSalary());
        }
    }

    /**
     * phương thức hiển thị mức thưởng
     * và cách nhận của nhân viên
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void showBonus(ArrayList<Employee> employees) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "Mã NV", "Họ Tên", "Mức Thưởng", "Hình thức nhận");
        for (var item : employees) {
            if (item instanceof Manager) {
                var man = (Manager) item;
                System.out.printf("%-20s%-20s%-20.2f%-20s\n", man.getEmpId(), man.getFullNameString(),
                        man.getBonus(), man.receiBonus());
            } else {
                System.out.printf("%-20s%-20s%-20.2f%-20s\n", item.getEmpId(), item.getFullNameString(),
                        item.getBonus(), item.receiBonus());
            }
        }
    }

    /**
     * phương thức tình thưởng cho nhân viên
     *
     * @param employees danh sách nhân  viên gốc
     */
    private static void calculBonus(ArrayList<Employee> employees) {
        for (var item : employees) {
            if (item instanceof Manager) {
                var man = (Manager) item;
                man.calculBonus();
            } else {
                item.calculBonus();
            }
        }
    }

    /**
     * phương thức tính lương
     * cho nhân viên
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void calculSalary(ArrayList<Employee> employees) {
        for (var item : employees) {
            if (item instanceof Manager) {
                var man = (Manager) item;
                man.calculSalary();
            } else {
                item.calculSalary();
            }
        }
    }

    /**
     * phương thức xóa nhân viên
     * theo mã co trước
     *
     * @param employees danh sách nhân viên gốc
     * @param id        mã nhân viên cần xóa
     * @return true nếu xoa thành công ,false ngược lại
     */
    private static boolean removeEmpById(ArrayList<Employee> employees, String id) {
        for (var item : employees) {
            if (item.getEmpId().compareToIgnoreCase(id) == 0) {
                employees.remove(item);
                return true;
            }
        }
        return false;
    }

    /**
     * phương thức tìm kiếm giám đốc
     * theo nhiệm kì
     *
     * @param employees  danh sách nhân viên gốc
     * @param startYear  năm bắt đầu nhiệm kì
     * @param endYear    năm kết thúc nhiệm kì
     * @param dateFormat định dạng ngày
     */
    private static void findManagerByTerm(ArrayList<Employee> employees, int startYear, int endYear,
                                          SimpleDateFormat dateFormat) {
        ArrayList<Manager> managers = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (var item : employees) {
            if (item instanceof Manager) {
                var man = (Manager) item;
                calendar.setTime(man.getStartDate());
                var start = calendar.get(Calendar.YEAR);
                calendar.setTime(man.getEndDate());
                var end = calendar.get(Calendar.YEAR);
                if (start <= startYear && end >= endYear) {
                    managers.add(man);
                }
            }
        }
        System.out.println("==> Đã tìm thấy kết quả gồm : " + managers.size() + " giám đốc <===");
        if (managers.size() > 0) {
            showManager(managers, dateFormat);
        }
    }

    /**
     * phương thức tìm kiếm nhân viên
     * có số dư > X
     * hiển thị nhân viên và giám đốc thỏa mãn
     *
     * @param employees  danh sách nhân viên gốc
     * @param salary     mức lương cần tìm
     * @param dateFormat định dạng ngày
     */
    private static void findEmpBySalary(ArrayList<Employee> employees, float salary,
                                        SimpleDateFormat dateFormat) {
        ArrayList<Employee> emp = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        for (var item : employees) {
            if (item instanceof Manager) {
                var man = (Manager) item;
                if (man.getSalary() >= salary) {
                    managers.add(man);
                }
            } else {
                if (item.getSalary() >= salary) {
                    emp.add(item);
                }
            }
        }
        System.out.println("==> Đã tìm thấy kết quả gồm : " + emp.size() + " nhân viên và " +
                managers.size() + " giám đốc <===");
        if (emp.size() > 0) {
            showEmployee(emp, dateFormat);
        }
        if (managers.size() > 0) {
            showManager(managers, dateFormat);
        }
    }

    /**
     * phương thức tìm nhân viên
     * theo tên
     * hiển thị tên  ai là giám đốc
     * ai là nhân viên
     *
     * @param employees  danh sách nhân viên gốc
     * @param name       tên cần tìm
     * @param dateFormat định dạng ngày
     */
    private static void findEmpByName(ArrayList<Employee> employees, String name,
                                      SimpleDateFormat dateFormat) {
        ArrayList<Employee> emp = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        for (var item : employees) {
            if (item instanceof Manager) {
                var man = (Manager) item;
                if (man.getFullName().getFirst().compareToIgnoreCase(name) == 0) {
                    managers.add(man);
                }
            } else {
                if (item.getFullName().getFirst().compareToIgnoreCase(name) == 0) {
                    emp.add(item);
                }
            }
        }
        System.out.println("==> Đã tìm thấy kết quả gồm : " + emp.size() + " nhân viên và " +
                managers.size() + " giám đốc <===");
        if (emp.size() > 0) {
            showEmployee(emp, dateFormat);
        }
        if (managers.size() > 0) {
            showManager(managers, dateFormat);
        }

    }

    /**
     * phương thức hiển thị danh sách
     * nhân viên theo dạng cột
     *
     * @param employees  danh sách nhân viên gốc
     * @param dateFormat định dạng ngày
     */
    private static void showEmployees(ArrayList<Employee> employees, SimpleDateFormat dateFormat) {
        ArrayList<Employee> emp = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        for (var item : employees) {
            if (item instanceof Manager) {
                var man = (Manager) item;
                managers.add(man);
            } else {
                emp.add(item);
            }
        }
        System.out.println("===> Danh sách gồm : " + emp.size() + " nhân viên và "
                + managers.size() + " giám đốc <===");
        if (emp.size() > 0) {
            showEmployee(emp, dateFormat);
        }
        if (managers.size() > 0) {
            showManager(managers, dateFormat);
        }
    }

    /**
     * phương thức hiển thị từng giám đốc
     *
     * @param managers   giám đốc
     * @param dateFormat định dạng ngày
     */
    private static void showManager(ArrayList<Manager> managers, SimpleDateFormat dateFormat) {
        System.out.println("Danh sách gồm " + managers.size() + " giám đốc : ");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15s%-15s%-15s%-20s%-20s\n",
                "Số CCCD", "Họ Tên", "Địa chỉ", "Ngày sinh", "Email", "Số ĐT", "Mã NV", "Chức vụ",
                "Mức lương", "Kinh nghiệm", "Ngày làm", "Ngày BĐ", "Ngày KT");
        for (var s : managers) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15.2f%-15.2f%-15.2f%-20s%-20s\n",
                    s.getId(), s.getFullNameString(), s.getAddress(), dateFormat.format(s.getBirthDay()),
                    s.getEmail(), s.getNumber(), s.getEmpId(), s.getPesition(), s.getSalary(), s.getExperciene(),
                    s.getWorkingDay(), dateFormat.format(s.getStartDate()), dateFormat.format(s.getEndDate()));
        }
    }

    /**
     * phương thức hiển thị từng nhân viên
     *
     * @param emp        nhân viên
     * @param dateFormat định dạng ngày
     */
    private static void showEmployee(ArrayList<Employee> emp, SimpleDateFormat dateFormat) {
        System.out.println("Danh sách gồm " + emp.size() + " nhân viên : ");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15s%-15s%-15s\n",
                "Số CCCD", "Họ Tên", "Địa chỉ", "Ngày sinh", "Email", "Số ĐT", "Mã NV", "Chức vụ",
                "Mức lương", "Kinh nghiệm", "Ngày làm");
        for (var s : emp) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15.2f%-15.2f%-15.2f\n",
                    s.getId(), s.getFullNameString(), s.getAddress(), dateFormat.format(s.getBirthDay()),
                    s.getEmail(), s.getNumber(), s.getEmpId(), s.getPesition(), s.getSalary(), s.getExperciene(),
                    s.getWorkingDay());
        }
    }

    /**
     * phương thức thêm mới giám đốc
     *
     * @param input      đối tượng lớp Scanner
     * @param dateFormat định dạng ngày
     * @return đối tượng vừa tạo
     */
    private static Employee createNewManager(Scanner input, SimpleDateFormat dateFormat) {
        Employee employee = createNewEmployee(input, dateFormat);
        Date start = null;
        Date end = null;
        try {
            System.out.println("Nhập ngày bắt đầu nhiệm kì : ");
            start = dateFormat.parse(input.nextLine());
            System.out.println("Nhập ngày kết thúc nhiệm kì : ");
            end = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            start = new Date();
            end = new Date();
            e.printStackTrace();
        }
        return new Manager(employee, start, end);
    }


    /**
     * phương thức thêm mới
     * một nhân viên
     *
     * @param input      đối tượng lớp Scanner
     * @param dateFormat định dạng ngày
     * @return đối tượng vừa tạo
     */
    private static Employee createNewEmployee(Scanner input, SimpleDateFormat dateFormat) {
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
        return new Employee(id, name, address, dob, email, number, null,
                duty, salary, exp, workingDay, 0, 0);
    }

    /**
     * phương thức cật nhật mã nhân viên
     * tăng tự đông
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void updateEmpId(ArrayList<Employee> employees) {
        var maxId = 1000;
        for (var item : employees) {
            var curId = Integer.parseInt(item.getEmpId().substring(3));
            if (curId > maxId) {
                maxId = curId;
            }
        }
        Employee.setNextId(maxId + 1);

    }


    /**
     * phương thức đọc nhân viên
     * từ file
     *
     * @param fileName   tên file
     * @param dateFormat định dạng ngày
     * @return null nếu file rỗng và ngược lại
     * @throws IOException    xử lý ngoại lệ
     * @throws ParseException xử lý ngoại lệ
     */
    private static ArrayList<Employee> readFromEmpFile(String fileName, SimpleDateFormat dateFormat)
            throws IOException, ParseException {
        ArrayList<Employee> employees = new ArrayList<>();
        File file = new File(fileName);
        file.createNewFile();
        var input = new Scanner(file);
        while (input.hasNextLine()) {
            var data = input.nextLine().split("-");
            var emp = createEmpFromData(data, dateFormat);
            if (emp != null) {
                employees.add(emp);
            }
        }
        input.close();
        return employees;
    }

    /**
     * phương thức tạo mới nhân viên
     * từ dữ liệu file
     *
     * @param data       dữ liệu
     * @param dateFormat định dạng ngày
     * @return đối tượng vừa tạo
     * @throws ParseException xử lý ngoại lệ
     */
    private static Employee createEmpFromData(String[] data, SimpleDateFormat dateFormat) throws ParseException {
        var id = data[0];
        var name = data[1];
        var address = data[2];
        var dob = dateFormat.parse(data[3]);
        var email = data[4];
        var number = data[5];
        var empId = data[6];
        var pesition = data[7];
        var salary = Float.parseFloat(data[8]);
        var exp = Float.parseFloat(data[9]);
        var workingDay = Float.parseFloat(data[10]);
        var totalSalary = Float.parseFloat(data[11]);
        var bonus = Float.parseFloat(data[12]);
        if (data.length > 13) {
            var start = dateFormat.parse(data[13]);
            var end = dateFormat.parse(data[14]);
            return new Manager(id, name, address, dob, email, number, empId,
                    pesition, salary, exp, workingDay, totalSalary, bonus, start, end);
        } else {
            return new Employee(id, name, address, dob, email, number, empId,
                    pesition, salary, exp, workingDay, totalSalary, bonus);
        }
    }

    /**
     * phương thức thêm mới
     * hàng loat nhân viên
     * nhằm tiết kiệm thời gian chạy chương trình
     *
     * @param employees  danh sách nhân viên gốc
     * @param dateFormat định dạng ngày
     * @throws ParseException xử lý ngoại lệ
     */
    private static void createNewEmployees(ArrayList<Employee> employees, SimpleDateFormat dateFormat) throws ParseException {
        employees.add(new Employee("098267", "Nguyễn Văn An", "Hà Nội"
                , dateFormat.parse("2/10/1999"), "an@xmail.com", "0937828292",
                null, "Nhân viên", 8000f, 2f, 28f, 0, 0));
        employees.add(new Employee("091782", "Nguyễn Văn Hùng", "Hà Giang"
                , dateFormat.parse("10/10/1992"), "hung@xmail.com", "0923889229",
                null, "Nhân viên", 9000f, 3.5f, 29f, 0, 0));
        employees.add(new Employee("091729", "Nguyễn Văn Hưng", "Hà Nội"
                , dateFormat.parse("5/6/2000"), "hung@xmail.com", "0986789231",
                null, "Nhân viên", 9500f, 2f, 22f, 0, 0));
        employees.add(new Manager("091729", "Nguyễn Quang Khoa", "Hà Nội"
                , dateFormat.parse("8/12/1987"), "khoa@xmail.com", "0987124532",
                null, "Giám đốc", 15000f, 10f, 30f, 0, 0,
                dateFormat.parse("1/1/2020"), dateFormat.parse("1/1/2025")));
        employees.add(new Manager("009126", "Bùi Việt Anh", "Hà Nội"
                , dateFormat.parse("10/10/1988"), "anh@xmail.com", "0967892356",
                null, "Giám đốc", 15500f, 12f, 28.5f, 0, 0,
                dateFormat.parse("1/1/2015"), dateFormat.parse("1/1/2025")));
        employees.add(new Manager("091289", "Dương Văn Khoa", "Thanh Hóa"
                , dateFormat.parse("2/10/1990"), "an@xmail.com", "0923782998",
                null, "Nhân viên", 13000f, 9.5f, 28f, 0, 0,
                dateFormat.parse("1/1/2020"), dateFormat.parse("1/1/2025")));
    }
}

