package Lesson.Lesson76SQL.Exercise1;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat implements Serializable {
    private static int nextId = 1001; //mặc định mã con mèo là 1001
    private String id;  //id
    private String color;   //màu lông
    private int age;    //tuổi
    private String food;    //món ăn
    private String eyeColor;    //màu mắt
    private String petName; //tên gọi riêng

    protected Cat() {
        id = "";
        color = "";
        age = 0;
        food = "";
        eyeColor = "";
        petName = "";
    }

    public Cat(String id, String color, int age, String food, String eyeColor,
               String petName) throws InValidAgeException {
        this.setId();
        this.color = color;
        this.setAge(age);
        this.food = food;
        this.eyeColor = eyeColor;
        this.petName = petName;
    }

    public String getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Cat.nextId = nextId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId() {
        if (id == null) { //id== null ,chứng tỏ cần tạo mới
            this.id = "CAT" + nextId;
            nextId++;
        } else {
            getId();
        }
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

    public void setAge(int age) throws InValidAgeException {
        var regex = "^[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0]$";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(age + "");

        if (matcher.matches()) {
            this.age = age;
        } else {
            var msg = "Tuổi " + age + " không hợp lệ ! Vui lòng nhập [0-50]";
            throw new InValidAgeException(msg, 0);
        }

    }

    @Override
    public String toString() {
        return "Cat{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", food='" + food + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", petName='" + petName + '\'' +
                '}';
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
