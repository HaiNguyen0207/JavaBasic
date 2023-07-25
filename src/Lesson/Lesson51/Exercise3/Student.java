package Lesson.Lesson51.Exercise3;

import java.util.Date;

public class Student extends Person {
    private String studentId;   //mã sinh viên
    private String schoolName;  //trưởng học
    private String className;   //tên lóp
    private String major;   //chuyên ngành
    private float avgGade; //điểm trung bình

    protected Student() {
        studentId = "";
        schoolName = "";
        className = "";
        major = "";
        avgGade = 0f;
    }

    public Student(String studentId, String schoolName, String className, String major, float avgGade) {
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.className = className;
        this.major = major;
        this.avgGade = avgGade;
    }

    public Student(String id, String fullName, String address, Date birthDay, String email, String number,
                   String studentId, String schoolName, String className, String major, float avgGade) {
        super(id, fullName, address, birthDay, email, number);
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.className = className;
        this.major = major;
        this.avgGade = avgGade;
    }

    public final String getStudentId() {
        return studentId;
    }

    public final void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public final String getSchoolName() {
        return schoolName;
    }

    public final void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public final String getClassName() {
        return className;
    }

    public final void setClassName(String className) {
        this.className = className;
    }

    public final String getMajor() {
        return major;
    }

    public final void setMajor(String major) {
        this.major = major;
    }

    public final float getAvgGade() {
        return avgGade;
    }

    public void setAvgGade(float avgGade) {
        this.avgGade = avgGade;
    }

    @Override
    public void eat() {
        System.out.println("Sinh viên " + getFullName() + " đang ăn ...");
    }

    @Override
    public void sleep() {
        System.out.println("Sinh viên " + getFullName() + " đang ngủ nướng ...");
    }

    @Override
    public void talk() {
        System.out.println("Sinh viên " + getFullName() + " đang nói chuyện với bạn...");
    }

    @Override
    public void relax() {
        System.out.println("Sinh viên " + getFullName() + " đang thư giãn ...");
    }

    @Override
    protected void doWork() {
        System.out.println("Sinh viên " + getFullName() + " đang làm bài tập ...");
    }
}
