package Lesson.Lesson62.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        Cat cat = new Cat();
        System.out.println("Nhập màu lông : ");
        var color = input.nextLine();
        cat.setColor(color);
        System.out.println("Nhập tuổi : ");
        var age = Integer.parseInt(input.nextLine());
        try {
            cat.setAge(age);
        } catch (InValidAgeCatException e) {
            e.printStackTrace();
        }
        System.out.println("Nhập thức ăn : ");
        var food = input.nextLine();
        cat.setFood(food);
        System.out.println("Nhập màu mắt : ");
        var colorEye = input.nextLine();
        cat.setEyeColor(colorEye);
        System.out.println("Nhập tên gọi :");
        var name = input.nextLine();
        cat.setPetName(name);
        show(cat);
    }

    private static void show(Cat cat) {
        System.out.println("Màu lông : " + cat.getColor());
        System.out.println("Tuổi : " + cat.getAge());
        System.out.println("Thức ăn : " + cat.getFood());
        System.out.println("Màu mắt : " + cat.getEyeColor());
        System.out.println("Tên gọi : " + cat.getPetName());
    }

}
