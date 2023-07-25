package Lesson.Lesson72ReadBinary.Exercise1;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat implements Serializable {
    private String color;   //màu lông
    private int age;    //tuổi
    private String favoriteFood;    //món ăn ưa thích
    private String petName; //tên gọi riêng

    protected Cat() {
        color = "";
        age = 0;
        favoriteFood = "";
        petName = "";
    }

    public Cat(String color, int age, String favoriteFood, String petName)
            throws InValidAgeException {
        this.color = color;
        setAge(age);
        this.favoriteFood = favoriteFood;
        this.petName = petName;
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
        var regex1 = "^(0|1|2|3|4)\\d{1,2}$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(age + "");
        if (matcher1.matches()) {
            this.age = age;
        } else {
            var msg = "Tuổi nhập không hợp lệ ! Vui lòng xem lại ";
            throw new InValidAgeException(msg, 0);
        }
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
