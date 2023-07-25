package Lesson.Lesson55.Exercise3;

import Lesson.Lesson55.Exercise3.Sort.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) throws ParseException {
        var input = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();
        var fileName = "STU.DAT";
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        createNewPerson(persons, dateFormat);
        updateStudentId(persons);   //cập nhật mã sinh viên tự động tăng
        updateInstructorId(persons);
        var choice = 0;
        do {
            System.out.println("=============================MENU===============================");
            System.out.println("= 1. Thêm mới giảng viên vào danh sách                         =");
            System.out.println("= 2. Thêm mới sinh viên vào danh sách                          =");
            System.out.println("= 3. Sắp xếp danh sách giảng viên theo tên giảm dần z-a        =");
            System.out.println("= 4. Sắp xếp danh sách giảng viên theo mức lương giảm dần      =");
            System.out.println("= 5. Sắp xếp danh sách giảng viên theo kinh nghiệm giảm dần    =");
            System.out.println("= 6. Sắp xếp danh sách sinh viên theo tên tăng dần a-z         = ");
            System.out.println("= 7. Sắp xếp danh sách sinh viên theo điểm trung bình giảm dần =");
            System.out.println("= 8. Hiển thị danh sách giảng viên                             =");
            System.out.println("= 9. Hiển thị danh sách sinh viên                              =");
            System.out.println("= 10.Tìm kiếm sinh viên theo tên                               =");
            System.out.println("= 11.Xóa sinh viên theo mã                                     =");
            System.out.println("= 12. Ghi danh sách sinh viên vào file                         =");
            System.out.println("= 0. Kết thúc chương trình                                     =");
            System.out.println("================================================================");
            System.out.println("=================> Mời lựa chọn chức năng <=====================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("============> Chương trình đã kết thúc <=============");
                    break;
                case 1:
                    var intructor = createNewIntructor(input, dateFormat);
                    persons.add(intructor);
                    System.out.println("====> Thêm mới giảng viên thành công <===");
                    break;
                case 2:
                    var student = createNewStudent(persons, dateFormat, input);
                    persons.add(student);
                    System.out.println("=======> Thêm mới Sinh viên thành công <=====");
                    break;
                case 3:
                    sortInstructorByNameDec(persons, dateFormat);
                    break;
                case 4:
                    sortInstructorBySalaryDec(persons, dateFormat);
                    break;
                case 5:
                    sortInstructorByExpDec(persons, dateFormat);
                    break;
                case 6:
                    sortStudentByNameAsc(persons, dateFormat);
                    break;
                case 7:
                    sortStudentByGpaGrade(persons, dateFormat);
                    break;
                case 8:
                    showInstructors(persons, dateFormat);
                    break;
                case 9:
                    showStudents(persons, dateFormat);
                    break;
                case 10:
                    findStudentByName(persons, dateFormat, input);
                    break;
                case 11:
                    removeStudentById(persons, input);
                    break;
                case 12:
                    writerListToFile(persons, dateFormat, fileName);
                    break;
                default:
                    System.out.println("=======> Sai chức năng ! Vui lòng chọn lại <======");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * phương thức cập nhật mã giảng viên
     * tự động tăng
     *
     * @param persons danh sách sinh viên gốc
     */
    private static void updateInstructorId(ArrayList<Person> persons) {
        var maxId = 1000;
        for (var e : persons) {
            if (e instanceof Instructor) {
                var curId = Integer.parseInt(((Instructor) e).getInstructorId().substring(3));
                if (curId > maxId) {
                    maxId = curId;
                }
            }
        }
        Instructor.setNextId(maxId + 1);
    }

    /**
     * phương thức cập nhật sinh viên tự động tăng
     *
     * @param persons danh sách gốc
     */
    private static void updateStudentId(ArrayList<Person> persons) {
        var maxId = 1000;
        for (var e : persons) {
            if (e instanceof Student) {
                var curId = Integer.parseInt(((Student) e).getStudentId().substring(3));
                if (curId > maxId) {
                    maxId = curId;
                }
            }
        }
        Student.setNextId(maxId + 1);
    }

    /**
     * phương thức ghi danh sách sinh viên hiện thời
     * vào file
     *
     * @param persons    danh sách gốc
     * @param dateFormat định dạng ngày
     * @param fileName   tên file
     */
    private static void writerListToFile(ArrayList<Person> persons, SimpleDateFormat
            dateFormat, String fileName) {
        ArrayList<Student> students = new ArrayList<>();
        var isSuccess = false;
        for (var e : persons) {
            if (e instanceof Student) {
                students.add((Student) e);
            }
        }
        if (students.size() > 0) {
            File file = new File(fileName);
            try {
                file.createNewFile();
                PrintWriter printWriter = new PrintWriter(file);
                for (var e : students) {
                    printWriter.printf("%s-%s-%s-%s-%s\n", e.getStudentId(),
                            e.getFullNameString(), dateFormat.format(e.getBirthDay()),
                            e.getMajor(), e.getAvgGarde());
                }
                isSuccess = true;
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (isSuccess) {
                System.out.println("====> Ghi file thành công <====");
            }
        } else {
            System.out.println("===> Danh sách sinh viên rỗng !" +
                    " Không thể ghi file !");
        }
    }

    /**
     * phương thức xóa sinh viên theo mã
     *
     * @param persons danh sách người (bao gồm sinh viên và giảng viên)
     * @param input   đối tượng lớp Scanner
     */
    private static void removeStudentById(ArrayList<Person> persons, Scanner input) {
        System.out.println("Nhập mã sinh viên cần xóa : ");
        input.nextLine();
        var id = input.nextLine();
        var valid = false;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i) instanceof Student) {
                var s = (Student) persons.get(i);
                if (s.getStudentId().compareToIgnoreCase(id) == 0) {
                    persons.remove(persons.get(i));
                    valid = true;
                }
            }
        }
        if (valid) {
            System.out.println("===> Đã xóa mã sinh viên " + id + " " +
                    "thành công <====");
        } else {
            System.out.println("===> Xóa mã sinh viên " + id + "" +
                    " thất bại.Vui lòng xem lại !  <====");
        }
    }

    /**
     * phương thức tìm kiếm sinh viên theo tên
     *
     * @param persons    danh sách người
     * @param dateFormat định dạng ngày
     * @param input      đối tượng lớp Scanner
     */
    private static void findStudentByName(ArrayList<Person> persons, SimpleDateFormat dateFormat, Scanner input) {
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("Nhập tên sinh viên cần tìm kiếm : ");
        input.nextLine();
        var name = input.nextLine();
        for (var e : persons) {
            if (e instanceof Student) {
                var student = (Student) e;
                if (student.getFullName().getFirst().compareToIgnoreCase(name) == 0) {
                    students.add(student);
                }
            }
        }
        if (students.size() > 0) {
            System.out.println("====> Đã tìm thấy " + students.size() + " kết quả <====");
            showStudent(students, dateFormat);
        } else {
            System.out.println("====> Không tìm kiếm sinh viên nào tên : " +
                    "" + name + " <=====");
        }
    }

    /**
     * phương thức hiển thị danh sách
     * sinh viên theo điểm TB giảm dần
     *
     * @param persons    danh sách sinh viên và giảng viên
     * @param dateFormat định dạng ngày
     */
    private static void sortStudentByGpaGrade(ArrayList<Person> persons, SimpleDateFormat dateFormat) {
        ArrayList<Student> students = new ArrayList<>();
        for (var item : persons) {
            if (item instanceof Student) {
                var student = (Student) item;
                students.add(student);
            }
        }
        Collections.sort(students, new SortStudentByGpaGradeDec());
        System.out.println("====> Đã sắp xếp sinh viên theo điểm giảm dần <===");
        showStudent(students, dateFormat);
    }

    /**
     * phương thức hiển thị danh sách
     * sinh viên theo tên tăng dần
     *
     * @param persons    danh sách sinh viên và giảng viên
     * @param dateFormat định dạng ngày
     */
    private static void sortStudentByNameAsc(ArrayList<Person> persons, SimpleDateFormat dateFormat) {
        ArrayList<Student> students = new ArrayList<>();
        for (var item : persons) {
            if (item instanceof Student) {
                var student = (Student) item;
                students.add(student);
            }
        }
        Collections.sort(students, new SortStudentByNameAsc());
        System.out.println("====> Đã sắp xếp tên sinh viên tăng dần <===");
        showStudent(students, dateFormat);

    }

    /**
     * phương thức hiển thị giảng viên
     * theo năm kinh nghiệm giảm dần
     *
     * @param persons    danh sách sinh viên và giảng viên
     * @param dateFormat định dạng ngày
     */
    private static void sortInstructorByExpDec(ArrayList<Person> persons, SimpleDateFormat dateFormat) {
        ArrayList<Instructor> instructors = new ArrayList<>();
        for (var item : persons) {
            if (item instanceof Instructor) {
                var ins = (Instructor) item;
                instructors.add(ins);
            }
        }
        Collections.sort(instructors, new SortInsByExpDec());
        System.out.println("====> Đã sắp xếp theo năm kinh nghiệm giảm dần <===");
        showIns(instructors, dateFormat);
    }

    /**
     * phương thức hiển thị giảng viên
     * theo mức lương giảm dần
     *
     * @param persons    danh sách sinh viên và giảng viên
     * @param dateFormat định dạng ngày
     */
    private static void sortInstructorBySalaryDec(ArrayList<Person> persons, SimpleDateFormat dateFormat) {
        ArrayList<Instructor> instructors = new ArrayList<>();
        for (var item : persons) {
            if (item instanceof Instructor) {
                var ins = (Instructor) item;
                instructors.add(ins);
            }
        }
        Collections.sort(instructors, new SortInsBySalaryDec());
        System.out.println("====> Đã sắp xếp theo mức lương giảm dần <===");
        showIns(instructors, dateFormat);
    }

    /**
     * phương thức sắp xếp giảng viên
     * theo tên giảm dần
     *
     * @param persons
     * @param dateFormat
     */
    private static void sortInstructorByNameDec(ArrayList<Person> persons, SimpleDateFormat dateFormat) {
        ArrayList<Instructor> instructors = new ArrayList<>();
        for (var item : persons) {
            if (item instanceof Instructor) {
                var ins = (Instructor) item;
                instructors.add(ins);
            }
        }
        Collections.sort(instructors, new SortInsByNameDec());
        System.out.println("====> Đã sắp xếp theo tên giảm dần <===");
        showIns(instructors, dateFormat);
    }

    /**
     * phương thúc hiển thị sinh viên hay giảng viên
     * theo dạng cột
     *
     * @param persons    danh sách sinh viên và giảng viên gốc
     * @param dateFormat định dạng ngày
     */
    private static void showStudents(ArrayList<Person> persons, SimpleDateFormat dateFormat) {
        ArrayList<Student> students = new ArrayList<>();
        for (var item : persons) {
            if (item instanceof Student) {
                var student = (Student) item;
                students.add(student);
            }
        }
        showStudent(students, dateFormat);
    }

    /**
     * phương thức hiển thị từng sinh viên
     *
     * @param students   danh sách sinh viên
     * @param dateFormat định dạng ngày
     */
    private static void showStudent(ArrayList<Student> students, SimpleDateFormat dateFormat) {
        if (students.size() > 0) {
            System.out.println("=========> Danh sách sinh viên <=======");
            System.out.printf("%-20s%-20s%-20s%-20s%-15s\n", "Mã SV", "Tên SV", "Ngày sinh", "Chuyên ngành",
                    "Điểm TB");
            for (var item : students) {
                System.out.printf("%-20s%-20s%-20s%-20s%-15.2f\n", item.getStudentId(), item.getFullNameString(),
                        dateFormat.format(item.getBirthDay()), item.getMajor(), item.getAvgGarde());
            }
        } else {
            System.out.println("=====> Danh sách sinh viên rỗng ! Vui lòng thêm <====");
        }
    }

    /**
     * phương thức thêm mới sinh viên
     *
     * @param persons    danh sách sinh viên cả giảng viên
     * @param dateFormat định dạng ngày
     * @param input      đối tượng lớp Scanner
     * @return đối tượng sinh viên vừa tạo
     */
    private static Student createNewStudent(ArrayList<Person> persons, SimpleDateFormat dateFormat, Scanner input) {
        System.out.println("Nhập tên sinh viên : ");
        input.nextLine();
        var name = input.nextLine();
        System.out.println("Nhập ngày sinh : ");
        Date dob = null;
        try {
            dob = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
            dob = new Date(); //nhập sai ,mặc định là ngày hiện tại
        }
        System.out.println("Nhập chuyên ngành : ");
        var major = input.nextLine();
        System.out.println("Nhập điểm trung bình  : ");
        var gpaGrade = Float.parseFloat(input.nextLine());
        return new Student(name, dob, null, major, gpaGrade);
    }

    /**
     * phương thức hiển thị
     * danh sách giảng viên
     * ép kiểu lấy giảng viên
     *
     * @param persons    danh sách chứa giảng viên và sinh viên
     * @param dateFormat định dạng ngày
     */
    private static void showInstructors(ArrayList<Person> persons, SimpleDateFormat dateFormat) {
        ArrayList<Instructor> instructors = new ArrayList<>();
        for (var item : persons) {
            if (item instanceof Instructor) {
                var ins = (Instructor) item;
                instructors.add(ins);
            }
        }
        showIns(instructors, dateFormat);
    }

    /**
     * phương thức hiển thị
     * từng giảng viên theo dạng cột
     *
     * @param instructors danh sách giảng viên gốc
     * @param dateFormat  định dạng ngày
     */
    private static void showIns(ArrayList<Instructor> instructors, SimpleDateFormat dateFormat) {

        if (instructors.size() > 0) {
            System.out.println("=========> Danh sách giảng viên <======");
            System.out.printf("%-20s%-20s%-20s%-20s%-15s%-15s\n", "Mã GV", "Tên GV", "Ngày sinh", "Chuyên môn",
                    "Mức lương", "Kinh nghiệm");
            for (var item : instructors) {
                System.out.printf("%-20s%-20s%-20s%-20s%-15.2f%-15.2f\n", item.getInstructorId(),
                        item.getFullNameString(), dateFormat.format(item.getBirthDay()), item.getExpertise(),
                        item.getSalary(), item.getExperience());
            }
        } else {
            System.out.println("====> Danh sách giảng viên rỗng ! Vui lòng xem thêm <===");
        }
    }

    /**
     * phương thức thêm mới 1 giảng viên
     *
     * @param input      đối tượng lớp Scanner
     * @param dateFormat định dạng ngày
     * @return đối tượng vừa tạo
     */
    private static Instructor createNewIntructor(Scanner input, SimpleDateFormat dateFormat) {
        System.out.println("Nhập tên giảng viên : ");
        input.nextLine();
        var name = input.nextLine();
        System.out.println("Nhập ngày sinh : ");
        Date dob = null;
        try {
            dob = dateFormat.parse(input.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
            dob = new Date(); //nhập sai ,mặc định là ngày hiện tại
        }
        System.out.println("Nhập chuyên môn dạy : ");
        var expertise = input.nextLine();
        System.out.println("Nhập mức lương : ");
        var salary = Float.parseFloat(input.nextLine());
        System.out.println("Nhập năm kinh nghiệm : ");
        var exp = Float.parseFloat(input.nextLine());
        return new Instructor(name, dob, null, expertise, salary, exp);
    }

    /**
     * phương thức thêm hàng loạt
     * sinh viên và giảng viên
     * nhằm tiết kiệm thời gian code
     *
     * @param persons    danh sách sinh viên và giảng viên
     * @param dateFormat đinh dạng ngày
     * @throws ParseException xử lý ngoại lệ
     */
    private static void createNewPerson(ArrayList<Person> persons, SimpleDateFormat dateFormat) throws ParseException {
        persons.add(new Instructor("Nguyễn Văn Đạt", dateFormat.parse("1/2/1980"), "INS1001",
                "Java", 12000f, 2.5f));
        persons.add(new Instructor("Nguyễn Văn Dương", dateFormat.parse("9/2/1979"), "INS1002",
                "Java", 19000f, 5.5f));
        persons.add(new Instructor("Nguyễn Thị Dung", dateFormat.parse("19/2/1990"), "INS1003",
                "Java", 9000f, 1.5f));
        persons.add(new Instructor("Bùi Thị Giang", dateFormat.parse("19/6/1986"), "INS1004",
                "Java", 15000f, 4.0f));
        persons.add(new Instructor("Dương Văn Tân", dateFormat.parse("1/2/1992"), "INS1005",
                "Java", 9000f, 1.5f));
        persons.add(new Student("Nguyễn Thị Dương", dateFormat.parse("11/9/2002"), "STU1001",
                "ATTT", 7.94f));
        persons.add(new Student("Nguyễn Văn An", dateFormat.parse("16/3/2000"), "STU1002",
                "ATTT", 8.91f));
        persons.add(new Student("Nguyễn Văn Hải", dateFormat.parse("2/7/2002"), "STU1003",
                "ATTT", 8.74f));
        persons.add(new Student("Nguyễn Thị Nhung", dateFormat.parse("3/6/2001"), "STU1004",
                "ATTT", 8.92f));
        persons.add(new Student("Nguyễn Văn Ân", dateFormat.parse("4/5/2000"), "STU1005",
                "ATTT", 8.64f));

    }

}
