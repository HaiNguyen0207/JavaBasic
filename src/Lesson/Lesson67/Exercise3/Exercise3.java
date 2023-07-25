package Lesson.Lesson67.Exercise3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) throws InValidSalaryExcecption {
        var input = new Scanner(System.in);
        List<Instructor> instructors = new LinkedList<>();
        var choice = 0;
        do {
            System.out.println("=================MENU==================");
            System.out.println("= 1. Thêm  giảng viên                 =");
            System.out.println("= 2. Hiển thị danh sách giảng viên    =");
            System.out.println("= 0. kết thúc chương trình            =");
            System.out.println("=======================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("==> Chương trình đã kết thúc <==");
                    break;
                case 1:
                    var ins = createNewInstructor(input);
                    if (ins != null) {
                        instructors.add(ins);
                        System.out.println("==> Thêm mới giảng viên thành công <===");
                    } else {
                        System.out.println("==> Thêm mới giảng viên thất bại  <===");
                    }
                    break;
                case 2:
                    if (instructors.size() > 0) {
                        showInstructors(instructors);
                    } else {
                        System.out.println("==> Danh sách giảng viên rỗng <===");
                    }
                    break;
                default:
                    System.out.println("==> Sai chức năng ! Vui lòng nhập lại <==");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * phương thức hiển thị danh sách giảng viên theo dạng cột
     *
     * @param instructors danh sách giảng viên
     */
    private static void showInstructors(List<Instructor> instructors) {
        System.out.printf("%-15s%-20s%-15s%-15s%-15s\n", "Mã GV", "Họ Tên"
                , "Chuyên Môn", "Mức Lương", "Kinh Nghiệm");
        for (var e : instructors) {
            System.out.printf("%-15s%-20s%-15s%-15.2f%-15.2f\n", e.getId(),
                    e.getName(), e.getExpertise(), e.getSalary(), e.getExperience());
        }
    }

    /**
     * phương thứ thêm mới 1 giảng viên
     *
     * @param input đối tượng lớp Scaner
     * @return giảng viên vừa tạo
     * @throws InValidSalaryExcecption xử lý ngoại lệ
     */
    private static Instructor createNewInstructor(Scanner input)
            throws InValidSalaryExcecption {
        Instructor instructor = new Instructor();
        System.out.println("Nhập mã giảng viên : ");
        input.nextLine();
        var id = input.nextLine();
        System.out.println("Nhập họ tên : ");
        var name = input.nextLine();
        System.out.println("Nhập chuyên môn : ");
        var expertise = input.nextLine();
        System.out.println("Nhập mức lương : ");
        var salaryStr = input.nextLine().trim();
        var isSuccess = true;
        float salary = 0;
        salary = Float.parseFloat(salaryStr);
        try {
            instructor.setSalary(salary);
        } catch (InValidSalaryExcecption e) {
            e.printStackTrace();
            isSuccess = false;
        }
        System.out.println("Nhập năm kinh nghiệm : ");
        var exp = Float.parseFloat(input.nextLine());
        if (isSuccess) {
            return new Instructor(id, name, expertise, salary, exp);
        }

        return null;
    }
}
