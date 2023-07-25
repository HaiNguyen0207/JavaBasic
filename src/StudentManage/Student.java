package StudentManage;


import java.util.Date;

public class Student extends Person {
    private static int nextId = 1001;
    private String studentId;   //mã sinh viên
    private String schoolName;  //tên trường
    private String className;   //tên lớp
    private String major;   //chuyên ngành
    private Transcript transcript;  //bảng điểm

    protected Student() {
        studentId = "";
        schoolName = "";
        className = "";
        major = "";
        transcript = null;
    }

    public Student(String studentId, String schoolName, String className,
                   String major, Transcript transcript) {
        this.transcript =new Transcript();
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.className = className;
        this.major = major;
        this.transcript = transcript;
    }

    public Student(String fullName, Date birthDay, String studentId, String major) {
        super(fullName, birthDay);
        this.transcript =new Transcript();
        this.studentId = studentId;
        this.major = major;
    }

    public Student(String fullName, Date birthDay, String studentId,
                   String schoolName, String className, String major,
                   Transcript transcript) {
        super(fullName, birthDay);
        this.transcript =new Transcript();
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.className = className;
        this.major = major;
        this.transcript = transcript;
    }

    public Student(String id, String fullName, String studentId, String schoolName,
                   String className, String major, Transcript transcript) {
        super(id, fullName);
        this.transcript =new Transcript();
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.className = className;
        this.major = major;
        this.transcript = transcript;
    }

    public Student(String id, String fullName, String address, Date birthDay, String email,
                   String number, String studentId, String schoolName, String className,
                   String major, Transcript transcript) {
        super(id, fullName, address, birthDay, email, number);
        this.transcript =new Transcript();
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.className = className;
        this.major = major;
        this.transcript = transcript;
    }

    public final String getStudentId() {
        return studentId;
    }

    public final void setStudentId() {
        if (studentId == null) {
            this.studentId = "STU" + nextId;
            nextId++;
        } else {
            getStudentId();
        }
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
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
        System.out.println("Sinh viên " + getFullNameString() + " đang ăn sáng ...");
    }

    @Override
    protected void sleep() {
        System.out.println("Sinh viên " + getFullNameString() + " đang ngủ nướng  ...");
    }

    @Override
    protected void talk() {
        System.out.println("Sinh viên " + getFullNameString() + " đang nói chuyện bla ba ...");
    }

    @Override
    protected void entertainment() {
        System.out.println("Sinh viên " + getFullNameString() + " đang giải trí...");
    }

    @Override
    protected void work() {
        System.out.println("Sinh viên " + getFullNameString() + " đang code dạo ...");
    }
}
