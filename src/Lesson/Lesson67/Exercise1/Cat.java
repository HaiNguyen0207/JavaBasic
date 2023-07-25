package Lesson.Lesson67.Exercise1;

import Lesson.Lesson62.Exercise1.InValidAgeCatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat {
    private String color;  //màu lông
    private int age;   //tuổi
    private String food;    //món ăn
    private String eyeColor;    //màu mắt
    private String petName; //tên gọi

    protected Cat() {
        color = "";
        age = 0;
        food = "";
        eyeColor = "";
        petName = "";
    }

    public Cat(String petName) {
        this.petName = petName;
    }

    public Cat(String petName, int age) throws InValidAgeCatException {
        this.petName = petName;
        setAge(age);
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InValidAgeCatException {
        var regex = "[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0] ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(age + "");
        if (matcher.matches()) {
            this.age = age;

        } else {
            this.age = 0;
            var msg = "Tuổi khong hợp lệ : " + age;
            throw new InValidAgeCatException(msg, age);
        }
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
