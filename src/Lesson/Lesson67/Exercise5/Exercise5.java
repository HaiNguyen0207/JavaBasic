package Lesson.Lesson67.Exercise5;


import Lesson.Lesson67.Exercise5.Sort.SortEmpByAgeAsc;
import Lesson.Lesson67.Exercise5.Sort.SortEmpByAgeDec;
import Lesson.Lesson67.Exercise5.Sort.SortEmpByExpAsc;
import Lesson.Lesson67.Exercise5.Sort.SortEmpByExpDec;
import Lesson.Lesson67.Exercise5.Sort.SortEmpByNameAsc;
import Lesson.Lesson67.Exercise5.Sort.SortEmpByNameDec;
import Lesson.Lesson67.Exercise5.Sort.SortEmpBySalaryAsc;
import Lesson.Lesson67.Exercise5.Sort.SortEmpBySalaryDec;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

public class Exercise5 {
    public static void main(String[] args) throws IOException, InValidFullNameException,
            InValidEmailException, InValidNumberPhoneException, ParseException {
        var input = new Scanner(System.in);
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        var fileName = "EMP.DAT";
        var choice = 0;
        ArrayList<Employee> employees = new ArrayList<>(readEmpFromFile(fileName, dateFormat));
        updateEmpId(employees);
        do {
            out.println("===================== MENU =====================");
            out.println("= 1. Thêm mới 1 nhân viên                      =");
            out.println("= 2. Hiển thị thông tin các nhân viên          =");
            out.println("= 3. Tìm nhân viên theo tên                    =");
            out.println("= 4. Tìm nhân viên có mức lương >= x           =");
            out.println("= 5. Tìm giám đốc theo nhiệm kì                =");
            out.println("= 6. Xóa nhân viên theo mã cho trước           =");
            out.println("= 7. Tính lương nhân viên                      =");
            out.println("= 8. Tính thưởng nhân viên                     =");
            out.println("= 9. Sắp xếp danh sách nhân viên               =");
            out.println("= 10. Hiển thị mức thưởng và cách nhận thưởng  =");
            out.println("= 11. Hiển thị bảng lương                      =");
            out.println("= 12. Lưu danh sách nhân viên, giám đốc        =");
            out.println("= 0. Thoát chương trình                        =");
            out.println("================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("====> Chương trình kết thúc <====");
                    break;
                case 1:
                    System.out.println("1 : Thêm mới nhân viên ");
                    System.out.println("2 : Thêm mới giám đốc ");
                    var option = input.nextInt();
                    if (option == 1) {
                        var emp = createNewEmployee(input, dateFormat);
                        if (emp != null) {
                            employees.add(emp);
                            out.println("===> Thêm mới nhân viên thành công <====");
                        } else {
                            out.println("===> Thêm mới nhân viên thất bại <====");
                        }
                    } else if (option == 2) {
                        var man = createNewManager(input, dateFormat);
                        if (man != null) {
                            employees.add(man);
                            out.println("===> Thêm mới giám đốc thành công <===");
                        } else {
                            out.println("===> Thêm mới giám đốc thất bại  <===");
                        }
                    } else {
                        out.println("===> Sai chức năng ! Vui lòng nhập lại <===");
                    }
                    break;
                case 2:
                    if (employees.size() > 0) {
                        showEmployees(employees, dateFormat);
                    } else {
                        out.println("====");
                    }
                    break;
                case 3:
                    if (employees.size() > 0) {
                        out.println("Nhập tên cần tìm  cần : ");
                        input.nextLine();
                        var name = input.nextLine();
                        findEmpByName(employees, dateFormat, name);
                    } else {
                        out.println("=====> Danh sách nhân viên rỗng<====");
                    }
                    break;
                case 4:
                    if (employees.size() > 0) {
                        out.println("Nhập mức lương cần tìm  cần : ");
                        input.nextLine();
                        var salary = input.nextFloat();
                        findEmpBySalary(employees, dateFormat, salary);
                    } else {
                        out.println("=====> Danh sách nhân viên rỗng<====");
                    }
                    break;
                case 5:
                    if (employees.size() > 0) {
                        out.println("Nhập năm bắt đầu nhiệm kì : ");
                        input.nextLine();
                        var start = input.nextInt();
                        out.println("Nhập năm kết thúc nhiệm kì : ");
                        var end = input.nextInt();
                        findManagerByTerm(employees, dateFormat, start, end);
                    } else {
                        out.println("====> Danh sách nhân viên rỗng <====");
                    }
                    break;
                case 6:
                    if (employees.size() > 0) {
                        out.println("Nhập mã nhân viên cần xóa : ");
                        input.nextLine();
                        var id = input.nextLine();
                        var isSuccess = removeEmpById(employees, id);
                        if (isSuccess) {
                            out.println("=====> Xóa ID : " + id + " thành công <====");
                        } else {
                            out.println("=====> Xóa ID : " + id + " thất bại  <====");
                        }
                    } else {
                        out.println("====> Danh sách nhân viên rỗng <===");
                    }
                    break;
                case 7:
                    if (employees.size() > 0) {
                        calculSalary(employees);
                    } else {
                        out.println("=====> Danh sách nhân viên rỗng <=====");
                    }
                    break;
                case 8:
                    if (employees.size() > 0) {
                        calculBonus(employees);
                    } else {
                        out.println("=====> Danh sách nhân viên rỗng <=====");
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
                        var slot = input.nextInt();
                        sortEmployees(employees, slot, dateFormat);
                    } else {
                        out.println("=====> Danh sách nhân viên rỗng <=====");
                    }
                    break;
                case 10:
                    if (employees.size() > 0) {
                        showBonus(employees);
                    } else {
                        out.println("=====> Danh sách nhân viên rỗng <=====");
                    }
                    break;
                case 11:
                    if (employees.size() > 0) {
                        showSalary(employees);
                    } else {
                        out.println("=====> Danh sách nhân viên rỗng <=====");
                    }
                    break;
                case 12:
                    if (employees.size() > 0) {
                        var isSuccess = writerEmpToFile(employees, fileName, dateFormat);
                        if (isSuccess) {
                            out.println("====> Ghi file thành công <===");
                        } else {
                            out.println("====> Ghi file thất bại <===");
                        }
                    } else {
                        out.println("=====> Danh sách nhân viên rỗng <=====");
                    }
                    break;
                default:
                    System.out.println("===> Sai chức năng ! Vui lòng nhập lại <===");
            }
        } while (choice != 0);
    }

    /**
     * phương thức ghi danh sách nhân viên vô file
     *
     * @param employees  danh sách nhân viên
     * @param fileName   tên file
     * @param dateFormat định dạng ngày
     * @return true -ghi thành công
     * @throws IOException xử lý ngoại lệ
     */
    private static boolean writerEmpToFile(ArrayList<Employee> employees, String fileName,
                                           SimpleDateFormat dateFormat) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(file);
        for (var emp : employees) {
            if (emp instanceof Manager) {
                var man = (Manager) emp;
                printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%.2f-%.2f-%.2f-%.2f-%.2f-%s-%s\n",
                        man.getNumberId(), man.getFullNameString(),
                        man.getAddress(), dateFormat.format(man.getBirthDay()),
                        man.getEmail(), man.getNumberPhone(), man.getEmpId(),
                        man.getPosition(), man.getSalary(), man.getExperience(),
                        man.getWorkingDay(), man.getToltalSalary(), man.getBonus(),
                        dateFormat.format(man.getStart()),
                        dateFormat.format(man.getEnd()));
            } else {
                printWriter.printf("%s-%s-%s-%s-%s-%s-%s-%s-%.2f-%.2f-%.2f-%.2f-%.2f\n",
                        emp.getNumberId(), emp.getFullNameString(),
                        emp.getAddress(), dateFormat.format(emp.getBirthDay()),
                        emp.getEmail(), emp.getNumberPhone(), emp.getEmpId(),
                        emp.getPosition(), emp.getSalary(), emp.getExperience(),
                        emp.getWorkingDay(), emp.getToltalSalary(), emp.getBonus());
            }
        }
        printWriter.close();
        return true;
    }

    private static void sortEmployees(ArrayList<Employee> employees, int slot,
                                      SimpleDateFormat dateFormat) {
        if (slot == 1) {
            Collections.sort(employees, new SortEmpByNameAsc());
            System.out.println("====> Danh sách nhân viên theo tên tăng dần A - Z <===");
            showEmpSort(employees, dateFormat);
        } else if (slot == 2) {
            Collections.sort(employees, new SortEmpByNameDec());
            System.out.println("====> Danh sách nhân viên theo tên giảm dần Z - A <===");
            showEmpSort(employees, dateFormat);
        } else if (slot == 3) {
            Collections.sort(employees, new SortEmpBySalaryAsc());
            System.out.println("====> Danh sách nhân viên theo mức lương tăng dần <===");
            showEmpSort(employees, dateFormat);
        } else if (slot == 4) {
            Collections.sort(employees, new SortEmpBySalaryDec());
            System.out.println("====> Danh sách nhân viên theo mức lương giảm dần <===");
            showEmpSort(employees, dateFormat);
        } else if (slot == 5) {
            Collections.sort(employees, new SortEmpByExpAsc());
            System.out.println("====> Danh sách nhân viên theo kinh nghiệm tăng dần <===");
            showEmpSort(employees, dateFormat);
        } else if (slot == 6) {
            Collections.sort(employees, new SortEmpByExpDec());
            System.out.println("====> Danh sách nhân viên theo kinh nghiệm giảm dần <===");
            showEmpSort(employees, dateFormat);
        } else if (slot == 7) {
            Collections.sort(employees, new SortEmpByAgeAsc());
            System.out.println("====> Danh sách nhân viên theo tuổi tăng dần <===");
            showEmpSort(employees, dateFormat);
        } else if (slot == 8) {
            Collections.sort(employees, new SortEmpByAgeDec());
            System.out.println("====> Danh sách nhân viên theo tuổi giảm dần <===");
            showEmpSort(employees, dateFormat);
        } else if (slot == 9) {
            Collections.sort(employees, new SortEmpBySalaryDec());
            System.out.println("===> Danh sách nhân viên theo tổng lương giảm dần <===");
            showEmpSort(employees, dateFormat);
        } else {
            System.out.println("=======> Sai chức năng ! Vui lòng chọn lại <=========");
        }
    }

    /**
     * phương thức hiển thị danh sách nhân viên
     * sau sắp xếp
     *
     * @param employees  danh sách nhân viên gốc
     * @param dateFormat dịnh dạng ngày
     */
    public static void showEmpSort(ArrayList<Employee> employees, SimpleDateFormat dateFormat) {
        out.printf("%-20s%-20s%-20s%-20s%-15s%-15s%-20s%-20s\n", "Mã NV", "Họ Tên",
                "Ngày Sinh", "Chức Vụ", "Kinh Nghiệm", "Mức Lương", "Thưởng", "Tổng lương");
        for (var e : employees) {
            out.printf("%-20s%-20s%-20s%-20s%-15s%-15.2f%-20.2f%-20.2f\n",
                    e.getEmpId(), e.getFullNameString(), dateFormat.format(e.getBirthDay()),
                    e.getPosition(), e.getExperience(), e.getSalary(), e.getBonus(),
                    e.calculToTalSalary());
        }
    }


    /**
     * phương thức hiển thị bảng lương
     *
     * @param employees danh sách nhân  viên gốc
     */
    private static void showSalary(ArrayList<Employee> employees) {
        out.println("===> Danh sách bảng lương của nhân viên <===");
        out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Mã NV", "Họ Tên",
                "Chức Vụ", "Mức Lương", "Ngày Công", "Tiền thưởng", "Tổng lương");
        for (var e : employees) {
            out.printf("%-20s%-20s%-20s%-20.2f%-20.2f%-20.2f%-20.2f\n", e.getEmpId(),
                    e.getFullNameString(), e.getPosition(), e.getSalary(), e.getWorkingDay(),
                    e.getBonus(), e.calculToTalSalary());
        }
    }

    /**
     * phương thức hiển thị mức thưởng và cách nhận
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void showBonus(ArrayList<Employee> employees) {
        out.println("====> Danh sách nhận thưởng của nhân viên <===");
        out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Mã NV", "Họ Tên", "Chức Vụ", "Tiền Thưởng", "Cách Nhận");
        for (var e : employees) {
            if (e instanceof Manager) {
                var item = (Manager) e;
                out.printf("%-20s%-20s%-20s%-20.2f%-20s\n", item.getEmpId(),
                        item.getFullNameString(), item.getPosition(), item.getBonus(),
                        item.receiveBonus());
            } else {
                out.printf("%-20s%-20s%-20s%-20.2f%-20s\n", e.getEmpId(),
                        e.getFullNameString(), e.getPosition(), e.getBonus(),
                        e.receiveBonus());
            }
        }
    }

    /**
     * phương thức tính thưởng cho nhân viên
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void calculBonus(ArrayList<Employee> employees) {
        for (var e : employees) {
            if (e instanceof Manager) {
                var item = (Manager) e;
                item.calculBonusManager();
            } else {
                e.calculBonus();
            }
        }
        out.println("====> Tính thưởng cho nhân viên hoàn tất <====");
    }

    /**
     * phương thức tính lương nhân viên
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void calculSalary(ArrayList<Employee> employees) {
        for (var e : employees) {
            e.calculSalary();
        }
        out.println("====> Tính lương cho nhân  viên hoàn tất <====");
    }

    /**
     * phương thức xóa nhân viên theo mã cho trước
     *
     * @param employees danh sách nhân viên gốc
     * @param id        mã nv cần xóa
     * @return true nếu xóa thành công ,false nếu xóa thất bại
     */
    private static boolean removeEmpById(ArrayList<Employee> employees, String id) {
        for (var e : employees) {
            if (e.getEmpId().compareToIgnoreCase(id) == 0) {
                employees.remove(e);
                return true;
            }
        }
        return false;
    }

    /**
     * phương thức tìm kiếm giám đốc theo nhiệm kì
     *
     * @param employees  dánh sách sinh viên gốc
     * @param dateFormat định dạng ngày
     * @param start      năm bắt đầu nhiệm kì
     * @param end        năm kết thúc nhiệm kì
     */
    private static void findManagerByTerm(ArrayList<Employee> employees,
                                          SimpleDateFormat dateFormat,
                                          int start, int end) {

        ArrayList<Manager> managers = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (var e : employees) {
            if (e instanceof Manager) {
                var item = (Manager) e;
                calendar.setTime(item.getStart());
                var startYear = calendar.get(Calendar.YEAR);
                calendar.setTime(item.getEnd());
                var endYear = calendar.get(Calendar.YEAR);
                if (startYear <= start && endYear >= end) {
                    managers.add(item);
                }
            }
        }
        out.println("===> Danh sách tìm kiếm thấy : " + managers.size() + " giám đốc");
        showManager(managers, dateFormat);
    }

    /**
     * phương thức tìm kiểm nhân viên có mức lương >x
     *
     * @param employees  danh sách nhân viên gốc
     * @param dateFormat định dạng ngày
     * @param salary     mức lương cần tìm kiếm
     */
    private static void findEmpBySalary(ArrayList<Employee> employees,
                                        SimpleDateFormat dateFormat, float salary) {
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Employee> emp = new ArrayList<>();
        for (var e : employees) {
            if (e.getSalary() >= salary) {
                if (e instanceof Manager) {
                    var item = (Manager) e;
                    managers.add(item);
                } else {
                    emp.add(e);
                }
            }
        }
        out.println("Kết quả tìm kiếm gồm : " + emp.size() + " nhân viên và "
                + managers.size() + " giám đốc ");
        if (emp.size() > 0) {
            out.println("===> Danh sách tìm kiếm " + emp.size() + " nhân viên ");
            showEmp(emp, dateFormat);
        }
        if (managers.size() > 0) {
            out.println("===> Danh sách tìm kiếm " + managers.size() + " giám đốc ");
            showManager(managers, dateFormat);
        }
    }

    /**
     * phương thức tìm kiếm nhân viên theo tên
     *
     * @param employees  danh sách nhân viên gốc
     * @param dateFormat định dạng ngày
     * @param name       tên cần tìm
     */
    private static void findEmpByName(ArrayList<Employee> employees,
                                      SimpleDateFormat dateFormat, String name) {
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Employee> emp = new ArrayList<>();
        for (var e : employees) {
            if (e.getFullName().getFirst().compareToIgnoreCase(name) == 0) {
                if (e instanceof Manager) {
                    var item = (Manager) e;
                    managers.add(item);
                } else {
                    emp.add(e);
                }
            }
        }
        out.println("Kết quả tìm kiếm gồm : " + emp.size() + " nhân viên và "
                + managers.size() + " giám đốc ");
        if (emp.size() > 0) {
            out.println("===> Danh sách tìm kiếm " + emp.size() + " nhân viên ");
            showEmp(emp, dateFormat);
        }
        if (managers.size() > 0) {
            out.println("===> Danh sách tìm kiếm " + managers.size() + " giám đốc ");
            showManager(managers, dateFormat);
        }
    }

    /**
     * phương thức hiển thị danh sách nhân viên
     * theo dạng cột
     *
     * @param employees  danh sách nhân  viên cần hiển thị
     * @param dateFormat định dạng ngày
     */
    private static void showEmployees(ArrayList<Employee> employees, SimpleDateFormat dateFormat) {
        ArrayList<Manager> managers = new ArrayList<>();
        ArrayList<Employee> emp = new ArrayList<>();
        for (var e : employees) {
            if (e instanceof Manager) {
                var item = (Manager) e;
                managers.add(item);
            } else {
                emp.add(e);
            }
        }
        out.println("==> Danh sách gồm " + emp.size() + " nhân viên và " + managers.size()
                + " giám đốc ");
        if (emp.size() > 0) {
            out.println("===> Danh sách " + emp.size() + " nhân viên : ");
            showEmp(emp, dateFormat);
        }
        if (managers.size() > 0) {
            out.println("===> Danh sách " + managers.size() + " giám đốc : ");
            showManager(managers, dateFormat);
        }
    }

    /**
     * phương thức hiển thị từng giám đốc
     *
     * @param managers   giám  đốc cần được hiển thị
     * @param dateFormat định dạng ngày
     */
    private static void showManager(ArrayList<Manager> managers, SimpleDateFormat dateFormat) {
        out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15s%-20s%-20s\n",
                "Số CCD", "Họ Tên", "Địa Chỉ", "Ngày Sinh", "Email", "Số DT", "Mã NV",
                "Chức Vụ", "Mức Lương", "Kinh Nghiệm", "Ngày Công", "Ngày BĐ", "Ngày KT");
        for (var e : managers) {
            out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20.2f%-15.2f%-15.2f%-20s%-20s\n",
                    e.getNumberId(), e.getFullNameString(), e.getAddress(),
                    dateFormat.format(e.getBirthDay()), e.getEmail(), e.getNumberPhone(),
                    e.getEmpId(), e.getPosition(), e.getSalary(), e.getExperience(),
                    e.getWorkingDay(), dateFormat.format(e.getStart()),
                    dateFormat.format(e.getEnd()));
        }
    }

    /**
     * phương thức hiển thị từng nhân viên
     *
     * @param emp        nhân viên cần hiển thị
     * @param dateFormat định dạng ngày
     */
    private static void showEmp(ArrayList<Employee> emp, SimpleDateFormat dateFormat) {
        out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-15s%-15s\n",
                "Số CCD", "Họ Tên", "Địa Chỉ", "Ngày Sinh", "Email", "Số DT", "Mã NV",
                "Chức Vụ", "Mức Lương", "Kinh Nghiệm", "Ngày Công");
        for (var e : emp) {
            out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20.2f%-15.2f%-15.2f\n",
                    e.getNumberId(), e.getFullNameString(), e.getAddress(),
                    dateFormat.format(e.getBirthDay()), e.getEmail(), e.getNumberPhone(),
                    e.getEmpId(), e.getPosition(), e.getSalary(), e.getExperience(), e.getWorkingDay());
        }
    }

    /**
     * phương thức thêm mới một giám đốc
     *
     * @param input      đối tượng lớp Scanner
     * @param dateFormat định dạng ngày
     * @return giám đốc vừa tạo,null nếu sai định dạng
     * @throws InValidFullNameException
     * @throws InValidEmailException
     * @throws InValidNumberPhoneException tất cả xử lý ngoại lệ
     */
    private static Manager createNewManager(Scanner input, SimpleDateFormat dateFormat)
            throws InValidFullNameException, InValidEmailException,
            InValidNumberPhoneException {
        var emp = createNewEmployee(input, dateFormat);
        out.println("Nhập ngày bắt đầu nhiệm kì : ");
        var start = input.nextLine();
        Date startTerm = null;
        try {
            startTerm = dateFormat.parse(start);
        } catch (ParseException e) {
            out.println("Ngày nhập : " + start + " không hợp lệ !");
            return null;
        }
        out.println("Nhập ngày kết thúc nhiệm kì : ");
        var end = input.nextLine();
        Date endTerm = null;
        try {
            endTerm = dateFormat.parse(end);
        } catch (ParseException e) {
            out.println("Ngày nhập : " + end + " không hợp lệ !");
            return null;
        }
        return new Manager(emp, startTerm, endTerm);
    }

    /**
     * phương thức thêm mới 1 nhân viên
     * yêu cầu nhập các thông tin đúng vs định dạng
     * nhập sai kết thúc chương trình luôn
     *
     * @param input      đối tượng Scanner
     * @param dateFormat chuyển đổi dạng  ngày
     * @return đối tượng vừa tạo,null nếu sai định dậng
     * @throws InValidFullNameException
     * @throws InValidEmailException
     * @throws InValidNumberPhoneException tất cả xử lý ngoại lệ
     */
    private static Employee createNewEmployee(Scanner input, SimpleDateFormat dateFormat) throws
            InValidFullNameException, InValidEmailException, InValidNumberPhoneException {
        Employee employee = new Employee();
        out.println("Nhập số CCCD /CMND : ");
        input.nextLine();
        var id = input.nextLine();
        out.println("Nhập họ tên : ");
        var name = input.nextLine().trim();
        try {
            employee.setFullName(name);
        } catch (InValidFullNameException e) {
            out.println(e.getMessage());
            return null;   //nhập sai kết thúc luôn
        }
        out.println("Nhập địa chỉ : ");
        var address = input.nextLine();
        out.println("Nhập ngày sinh dạng như 02/07/2002 : ");
        var dobFrist = input.nextLine();
        Date dob = null;
        try {
            dob = dateFormat.parse(dobFrist);
        } catch (ParseException e) {
            out.println("Ngày sinh " + dobFrist + " không hợp lệ !");
            return null;   //nhập sai kết thúc bà luôn
        }
        out.println("Nhập email : ");
        var email = input.nextLine();
        try {
            employee.setEmail(email);
        } catch (InValidEmailException e) {
            out.println(e.getMessage());
            return null;   //nhập sai kết thúc luôn 
        }
        out.println("Nhập số điện thoại : ");
        var number = input.nextLine();
        try {
            employee.setNumberPhone(number);
        } catch (InValidNumberPhoneException e) {
            out.println(e.getMessage());
            return null;
        }
        out.println("Nhập chức vụ : ");
        var duty = input.nextLine();
        out.println("Nhập mức lương : ");
        var salary = Float.parseFloat(input.nextLine());
        out.println("Nhập kinh nghiệm : ");
        var exp = Float.parseFloat(input.nextLine());
        out.println("Nhập ngày công : ");
        var workingDay = Float.parseFloat(input.nextLine());
        return new Employee(id, name, address, dob, email, number, null, duty,
                salary, exp, workingDay, 0, 0);
    }

    /**
     * phương thức tạo mã nhân viên tăng tự động
     * mỗi nhân viên 1 mã
     * bắt đầu EMP1001
     *
     * @param employees danh sách nhân viên gốc
     */
    private static void updateEmpId(ArrayList<Employee> employees) {
        var maxId = 1001;
        for (var e : employees) {
            var curId = Integer.parseInt(e.getEmpId().substring(3));
            if (curId > maxId) {
                maxId = curId;
            }
        }
        Employee.setNextId(maxId + 1);
    }

    /**
     * phương thức đọc nhân viên từ file
     *
     * @param fileName   tên file  cần đọc
     * @param dateFormat chuyển đổi sang date
     * @return employees ,null nếu file rỗng
     * @throws IOException
     * @throws ParseException
     * @throws InValidFullNameException
     * @throws InValidEmailException
     * @throws InValidNumberPhoneException tất cả đều xử lý ngoại lệ
     */
    private static ArrayList<Employee> readEmpFromFile(String fileName, SimpleDateFormat dateFormat)
            throws IOException, ParseException, InValidFullNameException, InValidEmailException,
            InValidNumberPhoneException {
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
     * phương thức đọc từng nhân viên từ file
     *
     * @param data       dữ liệu đọc
     * @param dateFormat chuyển đổi dsang date
     * @return đối tượng vừa đọc
     * @throws ParseException
     * @throws InValidFullNameException
     * @throws InValidEmailException
     * @throws InValidNumberPhoneException tất cả đều xử lý ngoại lệ
     */
    private static Employee createEmpFromData(String[] data, SimpleDateFormat dateFormat)
            throws ParseException, InValidFullNameException, InValidEmailException,
            InValidNumberPhoneException {
        Employee employee = new Employee();
        var id = data[0];
        var fullName = data[1];
        employee.setFullName(fullName);
        var address = data[2];
        var dob = dateFormat.parse(data[3]);
        var email = data[4];
        var number = data[5];
        var empId = data[6];
        var duty = data[7];
        var salary = Float.parseFloat(data[8]);
        var exp = Float.parseFloat(data[9]);
        var workingDay = Float.parseFloat(data[10]);
        var toltalSalary = Float.parseFloat(data[11]);
        var bonus = Float.parseFloat(data[12]);
        if (data.length > 13) {
            var start = dateFormat.parse(data[13]);
            var end = dateFormat.parse(data[14]);
            return new Manager(id, fullName, address, dob, email, number, empId, duty,
                    salary, exp, workingDay, toltalSalary, bonus, start, end);
        } else {
            return new Employee(id, fullName, address, dob, email, number, empId, duty,
                    salary, exp, workingDay, toltalSalary, bonus);
        }
    }
}
