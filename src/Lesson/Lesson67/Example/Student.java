package Lesson.Lesson67.Example;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String id;  //mã nhân viên
    private String fullName;    //họ tên
    private String major;   //chuyên ngành

    protected Student() {
        id = "";
        fullName = "";
        major = "";
    }

    public Student(String id, String fullName, String major)
            throws InValidStudentIdExecption {
        setId(id);
        this.fullName = fullName;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InValidStudentIdExecption {
        var regex = "^(at|ct|dt){1}\\d{6}$";//regular expression
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(id);
        if (matcher.matches()) {
            this.id = id.toUpperCase(Locale.ROOT);
        } else {
            var msg = "Mã ID : " + id + " không hợp lệ ";
            this.id = null;
            throw new InValidStudentIdExecption(msg, id);
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
