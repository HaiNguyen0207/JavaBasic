package Lesson.Lesson67.Exercise3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Instructor {
    private String id;  //mả giảng viên
    private String name;    //họ tên
    private String expertise;   //chuyên môn
    private float salary;   //mức lương
    private float experience;//kinh nghiệm

    protected Instructor() {
        id = "";
        name = "";
        experience = 0f;
        salary = 0f;
        expertise = "";
    }

    public Instructor(String id, String name, String expertise, float salary,
                      float experience) throws InValidSalaryExcecption {
        this.id = id;
        this.name = name;
        this.expertise = expertise;
        setSalary(salary);
        this.experience = experience;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) throws InValidSalaryExcecption {
        if (isvalid(salary)) {
            this.salary = salary;
        } else {
            var msg = "Mức lương không hợp lệ: " + salary
                    + ", giá trị hợp lệ phải nằm trong đoạn [0.00, 80.00]";
            throw new InValidSalaryExcecption(msg, 0);
        }
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    //kiểm tra mức lương có hợp lệ k
    public boolean isvalid(float salary) {
        var regex = "(([0-7]\\d?).\\d{1,3})|(80.[0]{1,3})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(salary + "");
        return matcher.matches();
    }
}
