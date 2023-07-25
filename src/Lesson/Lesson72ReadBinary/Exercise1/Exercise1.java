package Lesson.Lesson72ReadBinary.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        Cat cat = new Cat();
        System.out.println("Nhập tuổi : ");
        var age = Integer.parseInt(input.nextLine());
        try {
            cat.setAge(age);
        } catch (InValidAgeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(cat.getAge());
    }
}
