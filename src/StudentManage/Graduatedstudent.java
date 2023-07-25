package StudentManage;


import java.util.Date;

public class Graduatedstudent extends Student {
    //sinh viên đã tốt nghiệp
    private int graduatedYear; // năm tốt nghiệp
    private int creditRetake; // số tín chỉ học lại
    private int failed; // số môn đã trượt
    private float startingSalary; // mức lương khởi điểm
    private String compayName; // tên cty
    private String role; // chức vụ

    protected Graduatedstudent() {
        graduatedYear = 0;
        creditRetake = 0;
        failed = 0;
        startingSalary = 0f;
        compayName = "";
        role = "";
    }

    public Graduatedstudent(int graduatedYear, int creditRetake, int failed,
                            float startingSalary, String compayName, String role) {
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
    protected void eat() {
        System.out.println("Cựu sinh viên " + getFullNameString() + " đang ăn sáng ...");
    }

    @Override
    protected void sleep() {
        System.out.println("Cựu sinh viên " + getFullNameString() + " đang ngủ trưa ...");
    }
}
