package Lesson.Lesson67.Example;


import java.util.Scanner;

public class CheckEmpId {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        Exmployee exmployee = new Exmployee();
        System.out.println("Nhập mã nhân viên theo định dạng " +
                " NV100000IT hoặc NV100002GDNS : ");
        var id = input.nextLine();
        try {
            exmployee.setId(id);
        } catch (InValidEmpIdException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Mã nhân viên : " + exmployee.getId());
    }
}
