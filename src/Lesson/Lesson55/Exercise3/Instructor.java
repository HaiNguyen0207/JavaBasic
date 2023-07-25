package Lesson.Lesson55.Exercise3;

import java.util.Date;

public class Instructor extends Person {
    private static int nextId = 1001;
    private String instructorId;    //mã giảng viên
    private String expertise;   //chuyên môn
    private float salary;  //mức lương
    private float experience; //kinh nghiệm

    protected Instructor() {
        instructorId = "";
        expertise = "";
        salary = 0f;
        experience = 0f;
    }

    public Instructor(String instructorId, String expertise, float salary, float experience) {
        this.instructorId = instructorId;
        this.expertise = expertise;
        this.salary = salary;
        this.experience = experience;
    }

    public Instructor(String fullName, Date birtDay, String instructorId, String expertise,
                      float salary, float experience) {
        super(fullName, birtDay);
        this.setInstructorId();
        this.expertise = expertise;
        this.salary = salary;
        this.experience = experience;
    }

    public Instructor(String id, String fullName, String address, Date birthDay,
                      String email, String number, String instructorId,
                      String expertise, float salary, float experience) {
        super(id, fullName, address, birthDay, email, number);
        this.instructorId = instructorId;
        this.expertise = expertise;
        this.salary = salary;
        this.experience = experience;
    }

    public final String getInstructorId() {
        return instructorId;
    }

    public final void setInstructorId() {
        if (instructorId == null) {
            this.instructorId = "INS" + nextId;
            nextId++;
        } else {
            getInstructorId();
        }
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Instructor.nextId = nextId;
    }

    public final String getExpertise() {
        return expertise;
    }

    public final void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public final float getSalary() {
        return salary;
    }

    public final void setSalary(float salary) {
        this.salary = salary;
    }

    public final float getExperience() {
        return experience;
    }

    public final void setExperience(float experience) {
        this.experience = experience;
    }

    @Override
    protected void eat() {
        System.out.println("Giảng viên " + getFullNameString() + " đang ăn bữa sáng ...");
    }

    @Override
    protected void sleep() {
        System.out.println("Giảng viên " + getFullNameString() + " đang ăn ngủ nướng ...");
    }

    @Override
    protected void talk() {
        System.out.println("Giảng viên " + getFullNameString() + " đang nói chuyện với đồng nghiệp ...");
    }

    @Override
    protected void entertainment() {
        System.out.println("Giảng viên " + getFullNameString() + " đang ăn giải trí  ...");
    }

    @Override
    protected void work() {
        System.out.println("Giảng viên " + getFullNameString() + " đang ăn bữa sáng giảng dạy");
    }

    //hành động soạn bài
    public void prepare(String subject) {
        System.out.println("Giảng viên " + getFullNameString() + "" +
                " đang soạn bài môn " + subject);
    }

    //hành động chấm đề
    public void mark() {
        System.out.println("Giảng viên " + getFullNameString() + "" +
                " đang chấm điểm môn toán...");
    }

    //họp
    public void joinMeeting() {
        System.out.println("Giảng viên " + getFullNameString() + " đang họp...");
    }

    // ra đề thi
    public void createExam(String subject) {
        System.out.println("Giảng viên đang ra đề thi môn " + subject);
    }
}
