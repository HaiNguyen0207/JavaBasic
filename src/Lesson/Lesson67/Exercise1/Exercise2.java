package Lesson.Lesson67.Exercise1;

import Lesson.Lesson62.Exercise1.InValidAgeCatException;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập tên của mèo: ");
        var name = input.nextLine();
        Cat myCat = new Cat(name);
        System.out.println("Nhập tuổi của mèo: ");
        var ageStr = input.nextLine().trim();
        var regex = "\\d+";
        if (ageStr.matches(regex)) {
            var age = Integer.parseInt(ageStr);
            try {
                myCat.setAge(age);
            } catch (InValidAgeCatException e) {
                e.printStackTrace();
                System.out.println("Tuổi nhập không hợp lệ [0-50] ");
            }
        }
        showPetInfo(myCat);
    }

    private static void showPetInfo(Cat myCat) {
        System.out.println("==========MEOW==========");
        System.out.println("Pet name: " + myCat.getPetName());
        System.out.println("Age: " + myCat.getAge());
    }
}
