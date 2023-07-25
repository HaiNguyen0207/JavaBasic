package Lesson.Lesson55.Exercise3;


import java.util.Date;

public class Student extends Person {
    private  static int nextId=1001;
    private String studentId;   //mã sinh viên
    private String schoolName;  //tên trường
    private String className;   //tên lớp
    private String major;   //chuyên ngành
    private float avgGarde; //điểm trung bình
    protected Student() {
        studentId="";
        schoolName="";
        className="";
        major="";
        avgGarde=0f;
    }

    public Student( String schoolName, String className,
                   String major, float avgGarde) {
        this.setStudentId();
        this.schoolName = schoolName;
        this.className = className;
        this.major = major;
        this.avgGarde = avgGarde;
    }

    public Student( String fullName,Date birtday, String studentId, String major, float avgGarde) {
        super( fullName,birtday);
        this.setStudentId();
        this.major = major;
        this.avgGarde = avgGarde;
    }

    public Student(String id, String fullName, String address, Date birthDay,
                   String email, String number, String studentId, String schoolName,
                   String className, String major, float avgGarde) {
        super(id, fullName, address, birthDay, email, number);
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.className = className;
        this.major = major;
        this.avgGarde = avgGarde;
    }

    public final String getStudentId() {
        return studentId;
    }

    public final void setStudentId() {
       if(studentId == null) {
           this.studentId="STU" +nextId;
           nextId++;
       }else {
           getStudentId();
       }
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
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

    public final float getAvgGarde() {
        return avgGarde;
    }

    public final void setAvgGarde(float avgGarde) {
        this.avgGarde = avgGarde;
    }
    public void doHomework(String subject) {
        System.out.println("Sinh viên đang làm bài tập môn " + subject);
    }

    public void doExam(String subject) {
        System.out.println("Sinh viên đang làm bài thi môn " + subject);
    }

    public void payFee(float amount) {
        System.out.println("Sinh viên đóng học phí " + amount + "đ");
    }

    public void registerCredit(int credit) {
        System.out.println("Sinh viên đăng kí " + credit + " tín chỉ");
    }

    @Override
    protected void eat() {
        System.out.println("Sinh viên "+getFullNameString()+" đang ăn sáng ...");
    }

    @Override
    protected void sleep() {
        System.out.println("Sinh viên "+getFullNameString()+" đang ngủ nướng  ...");
    }

    @Override
    protected void talk() {
        System.out.println("Sinh viên "+getFullNameString()+" đang nói chuyện bla ba ...");
    }

    @Override
    protected void entertainment() {
        System.out.println("Sinh viên "+getFullNameString()+" đang giải trí...");
    }

    @Override
    protected void work() {
        System.out.println("Sinh viên "+getFullNameString()+" đang code dạo ...");
    }
}
