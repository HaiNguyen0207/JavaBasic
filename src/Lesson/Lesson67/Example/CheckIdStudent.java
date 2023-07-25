package Lesson.Lesson67.Example;

import java.util.Scanner;

public class CheckIdStudent {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Nhập ID sinh viên theo dang AT170415 : ");
        var id = input.nextLine().trim();
        try {
            student.setId(id);
        } catch (InValidStudentIdExecption e) {
            System.out.println(e.getMessage());
        }
        System.out.println("ID : " + student.getId());
    }
}
