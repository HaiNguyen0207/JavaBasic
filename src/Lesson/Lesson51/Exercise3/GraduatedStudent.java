package Lesson.Lesson51.Exercise3;

import java.util.Date;

public class GraduatedStudent extends Student {
    private int graduatedYear; // năm tốt nghiệp
    private int creditRetake; // số tín chỉ học lại
    private int failed; // số môn đã trượt
    private float startingSalary; // mức lương khởi điểm
    private String compayName; // tên cty
    private String role; // chức vụ

    protected GraduatedStudent() {
        graduatedYear = 0;
        creditRetake = 0;
        failed = 0;
        startingSalary = 0;
        compayName = "";
        role = "";
    }

    public GraduatedStudent(int graduatedYear, int creditRetake, int failed, float startingSalary, String compayName,
                            String role) {
        this.graduatedYear = graduatedYear;
        this.creditRetake = creditRetake;
        this.failed = failed;
        this.startingSalary = startingSalary;
        this.compayName = compayName;
        this.role = role;
    }

    public GraduatedStudent(String studentId, String schoolName, String className, String major, float avgGade,
                            int graduatedYear, int creditRetake, int failed, float startingSalary, String compayName,
                            String role) {
        super(studentId, schoolName, className, major, avgGade);
        this.graduatedYear = graduatedYear;
        this.creditRetake = creditRetake;
        this.failed = failed;
        this.startingSalary = startingSalary;
        this.compayName = compayName;
        this.role = role;
    }

    public GraduatedStudent(String id, String fullName, String address, Date birthDay, String email, String number,
                            String studentId, String schoolName, String className, String major, float avgGade,
                            int graduatedYear, int creditRetake, int failed, float startingSalary, String compayName,
                            String role) {
        super(id, fullName, address, birthDay, email, number, studentId, schoolName, className, major, avgGade);
        this.graduatedYear = graduatedYear;
        this.creditRetake = creditRetake;
        this.failed = failed;
        this.startingSalary = startingSalary;
        this.compayName = compayName;
        this.role = role;
    }

    public final int getGraduatedYear() {
        return graduatedYear;
    }

    public final void setGraduatedYear(int graduatedYear) {
        this.graduatedYear = graduatedYear;
    }

    public final int getCreditRetake() {
        return creditRetake;
    }

    public final void setCreditRetake(int creditRetake) {
        this.creditRetake = creditRetake;
    }

    public final int getFailed() {
        return failed;
    }

    public final void setFailed(int failed) {
        this.failed = failed;
    }

    public final float getStartingSalary() {
        return startingSalary;
    }

    public final void setStartingSalary(float startingSalary) {
        this.startingSalary = startingSalary;
    }

    public final String getCompayName() {
        return compayName;
    }

    public final void setCompayName(String compayName) {
        this.compayName = compayName;
    }

    public final String getRole() {
        return role;
    }

    public final void setRole(String role) {
        this.role = role;
    }
    //override

    @Override
    public void eat() {
        System.out.println("Cựu sinh viên " + getFullName() + " đang ăn ...");
    }

    @Override
    public void sleep() {
        System.out.println("Cựu sinh viên " + getFullName() + " đang ngủ nướng ...");
    }

    @Override
    public void talk() {
        System.out.println("Cựu sinh viên " + getFullName() + " đang nói chuyện với bạn ...");
    }

    @Override
    public void relax() {
        System.out.println("Cựu sinh viên " + getFullName() + " đang thư giãn ...");
    }

    @Override
    protected void doWork() {
        System.out.println("Cựu sinh viên " + getFullName() + " đang làm việc  ...");
    }
}
