package StudentManage;

import StudentManage.Sort.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RunProgram {
    public static void main(String[] args) throws ParseException {
        var input = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();
        var fileName = "STU.DAT";
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        createNewPerson(persons, dateFormat);
        updateStudentId(persons);   //cập nhật mã sinh viên tự động tăng
        updateInstructorId(persons); //cập nhật mã giảng viên tự tăng
        var choice = 0;
        do {
            System.out.println("=============================MENU===============================");
            System.out.println("= 1. Thêm mới giảng viên vào danh sách                         =");
            System.out.println("= 2. Thêm mới sinh viên vào danh sách                          =");
            System.out.println("= 3. Hiển thị danh sách giảng viên                             =");
            System.out.println("= 4. Hiển thị danh sách sinh viên                              =");
            System.out.println("= 5. Sắp xếp danh sách sinh viên theo tên tăng dần a-z         = ");
            System.out.println("= 6. Tìm kiếm sinh viên theo tên                               =");
            System.out.println("= 7. Xóa sinh viên theo mã                                     =");
            System.out.println("= 8. Cập nhật điểm cho sinh viên                               =");
            System.out.println("= 9 .Sửa điểm sinh viên theo mã ID                             =");
            System.out.println("= 10. Xét học lực cho sinh viên                                =");
            System.out.println("= 11. Hiển thị bảng điểm và học lực của sinh viên              =");
            System.out.println("= 12. Sắp xếp sinh viên theo điểm TB giảm dần                  =");
            System.out.println("= 13. Ghi danh sách sinh viên vào file                         =");
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
                    showInstructors(persons, dateFormat);
                    break;
                case 4:
                    showStudents(persons, dateFormat);
                    break;
                case 5:
                    sortStudentByNameAsc(persons, dateFormat);
                    break;
                case 6:
                    findStudentByName(persons, dateFormat, input);
                    break;
                case 7:
                    removeStudentById(persons, input);
                    break;
                case 8:
                    updateTranscriptOfStudent(persons, input);
                    break;
                case 9:
                    editTranscriptOfStudent(persons, input);
                    break;
                case 10:
                    var value = capacityOfStudent(persons);
                    if (value) {
                        System.out.println("===> Đã xét học lực cho sinh viên xong ! <===");
                    } else {
                        System.out.println("===> Xét học lực thất bại ! Vui lòng xem lại <===");
                    }
                    break;
                case 11:
                    showCapacityOfStudent(persons, dateFormat);
                    break;
                case 12:
                    sortStudentByAvgMarkDec(persons, dateFormat);
                case 13:
                    writerListToFile(persons, dateFormat, fileName);
                    break;
                default:
                    System.out.println("=======> Sai chức năng ! Vui lòng chọn lại <======");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * phương thức hiển thị sinh viên theo điểm tb tăng dần
     *
     * @param persons    danh sách người
     * @param dateFormat định dạng ngày
     */
    private static void sortStudentByAvgMarkDec(ArrayList<Person> persons,
                                                SimpleDateFormat dateFormat) {
        ArrayList<Student> students = new ArrayList<>();
        for (var e : persons) {
            if (e instanceof Student) {
                var student = (Student) e;
                students.add(student);
            }
        }
        Collections.sort(students, new SortStudentByGpaGradeDec());
        showStudentByAvgMark(students, dateFormat);
    }

    private static void showStudentByAvgMark(ArrayList<Student> students,
                                             SimpleDateFormat dateFormat) {
        System.out.println("=========> Danh sách sinh viên giảm dần theo điểm TB <=======");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Mã SV", "Tên SV", "Ngày sinh",
                "Chuyên ngành", "Điểm TB");
        for (var item : students) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20.2f\n", item.getStudentId(),
                    item.getFullNameString(), dateFormat.format(item.getBirthDay()),
                    item.getMajor(), item.getTranscript().getAvgMark());
        }
    }

    /**
     * phương thức sửa điểm sinh viên theo mã
     *
     * @param persons danh sách người gốc
     * @param input   đối tượng lớp Scanner
     */
    private static void editTranscriptOfStudent(ArrayList<Person> persons, Scanner input) {
        ArrayList<Student> students = new ArrayList<>();
        for (var e : persons) {
            if (e instanceof Student) {
                var student = (Student) e;
                students.add(student);
            }
        }
        System.out.println("Nhập mã sinh viên cần sửa điểm : ");
        input.nextLine();
        var id = input.nextLine().toUpperCase(Locale.ROOT);
        var student = findStudentById(students, id);
        if (student != null) {
            System.out.println("Nhập điểm hệ số 1 : ");
            var mark1 = input.nextFloat();
            System.out.println("Nhập điểm hệ số 2 : ");
            var mark2 = input.nextFloat();
            System.out.println("Nhập điểm hệ số 3 : ");
            var mark3 = input.nextFloat();
            student.getTranscript().setMark1(mark1);
            student.getTranscript().setMark2(mark2);
            student.getTranscript().setMark3(mark3);
            System.out.println("======> Đã chỉnh sửa điểm ID " + id + " xong ! <==== ");
        } else {
            System.out.println("==> Không tồn tại sinh viên có mã " + id + " không thể sửa điểm ! ");
        }
    }

    /**
     * phương thức tìm sinh viên theo mã
     *
     * @param students danh sách sinh viên
     * @param id       mã sinh viên cần tìm
     * @return
     */
    private static Student findStudentById(ArrayList<Student> students, String id) {
        for (var student : students) {
            if (student.getStudentId().compareToIgnoreCase(id) == 0) {
                return student;
            }
        }
        return null;
    }

    private static void showCapacityOfStudent(ArrayList<Person> persons,
                                              SimpleDateFormat dateFormat) {
        ArrayList<Student> students = new ArrayList<>();
        for (var e : persons) {
            if (e instanceof Student) {
                var student = (Student) e;
                students.add(student);
            }
        }
        System.out.printf("%-20s%-20s%-20s%-20s%-15s%-15s%-15s%-15s%-15s\n",
                "Mã SV", "Họ Tên", "Ngày Sinh", "Chuyên Ngành", "Điểm HS1", "Điểm HS2",
                "Điểm HS3", "Điểm TB", "Học Lực");
        for (var e : students) {
            System.out.printf("%-20s%-20s%-20s%-20s%-15.2f%-15.2f%-15.2f%-15.2f%-15s\n",
                    e.getStudentId(), e.getFullNameString(), dateFormat.format(e.getBirthDay()),
                    e.getMajor(), e.getTranscript().getMark1(), e.getTranscript().getMark2(),
                    e.getTranscript().getMark3(), e.getTranscript().getAvgMark(),
                    e.getTranscript().getCapacity());
        }


    }

    /**
     * phương thức cập nhật điểm cho sinh viên
     *
     * @param persons danh sách người
     * @return true đã cập nhật thành công ,flase ngc lại
     */
    private static boolean capacityOfStudent(ArrayList<Person> persons) {
        ArrayList<Student> students = new ArrayList<>();
        for (var e : persons) {
            if (e instanceof Student) {
                var student = (Student) e;
                students.add(student);
            }
        }

        for (var student : students) {
            if (student.getTranscript().getMark1() == 0) {
                System.out.println("===> Chưa cập nhật hết điểm cho sinh viên ! Vui lòng thực hiện chức năng 11 !");
                return false;
            }
        }
        for (var e : students) {
            e.getTranscript().calculAvgMark();
            e.getTranscript().calculCapacity();

        }
        return true;
    }

    /**
     * phương thức cập nhật điểm cho sinh viên
     *
     * @param persons danh sách người
     * @param input   đối tượng lớp Scanner
     */
    private static void updateTranscriptOfStudent(ArrayList<Person> persons, Scanner input) {
        ArrayList<Student> students = new ArrayList<>();
        for (var e : persons) {
            if (e instanceof Student) {
                var student = (Student) e;
                students.add(student);
            }
        }
        if (students.size() > 0) {
            for (var e : students) {
                System.out.println("Nhập điểm cho ID " + e.getStudentId() + " : ");
                System.out.println("Nhập điểm hệ số 1 : ");
                input.nextLine();
                var mark1 = input.nextFloat();
                System.out.println("Nhập điểm hệ số 2 : ");
                var mark2 = input.nextFloat();
                System.out.println("Nhập điểm hệ số 3 : ");
                var mark3 = input.nextFloat();
                e.setTranscript(new Transcript(mark1, mark2, mark3));
            }
            System.out.println("===> Cập nhật điểm thành công ! <===");
        } else {
            System.out.println("===> Danh sách hiện thời sinh viên rỗng . Không thể cập nhật điểm ! ");
        }
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
                    printWriter.printf("%s-%s-%s-%s\n", e.getStudentId(),
                            e.getFullNameString(), dateFormat.format(e.getBirthDay()),
                            e.getMajor());
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
    private static void findStudentByName(ArrayList<Person> persons,
                                          SimpleDateFormat dateFormat, Scanner input) {
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
            System.out.printf("%-20s%-20s%-20s%-20s\n", "Mã SV", "Tên SV", "Ngày sinh", "Chuyên ngành"
            );
            for (var item : students) {
                System.out.printf("%-20s%-20s%-20s%-20s\n", item.getStudentId(), item.getFullNameString(),
                        dateFormat.format(item.getBirthDay()), item.getMajor());
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
        return new Student(name, dob, null, major);
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
                "CNTT"));
        persons.add(new Student("Nguyễn Văn An", dateFormat.parse("16/3/2000"), "STU1002",
                "CNTT"));
        persons.add(new Student("Nguyễn Văn Hải", dateFormat.parse("2/7/2002"), "STU1003",
                "CNTT"));
        persons.add(new Student("Nguyễn Thị Nhung", dateFormat.parse("3/6/2001"), "STU1004",
                "CNTT"));
        persons.add(new Student("Nguyễn Văn Ân", dateFormat.parse("4/5/2000"), "STU1005",
                "CNTT"));

    }

}
