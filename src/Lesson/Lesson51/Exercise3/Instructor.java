package Lesson.Lesson51.Exercise3;

import java.util.Date;

public class Instructor extends Person {//giảng viên
    private String instructorId;  //mã giảng viên
    private String expertise;   //chuyên môn
    private float salary;   //mức lương
    private float experience;//kinh nghiệm

    protected Instructor() {
        instructorId = "";
        expertise = "";
        experience = 0f;
        salary = 0f;
    }

    public Instructor(String instructorId, String expertise, float salary, float experience) {
        this.instructorId = instructorId;
        this.expertise = expertise;
        this.salary = salary;
        this.experience = experience;
    }

    public Instructor(String id, String fullName, String address, Date birthDay, String email, String number,
                      String instructorId, String expertise, float salary, float experience) {
        super(id, fullName, address, birthDay, email, number);
        this.instructorId = instructorId;
        this.expertise = expertise;
        this.salary = salary;
        this.experience = experience;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public String getExpertise() {
        return expertise;
    }

    public float getSalary() {
        return salary;
    }

    public float getExperience() {
        return experience;
    }

    public final void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public final void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public final void setSalary(float salary) {
        this.salary = salary;
    }

    public final void setExperience(float experience) {
        this.experience = experience;
    }

    //override

    @Override
    public void eat() {
        System.out.println("Giảng viên " + getFullName() + " đang ăn sáng ...");
    }

    @Override
    public void sleep() {
        System.out.println("Giảng viên " + getFullName() + " đang ngủ nướng ...");
    }

    @Override
    public void talk() {
        System.out.println("Giảng viên " + getFullName() + " đang nói chuyện...");
    }

    @Override
    public void relax() {
        System.out.println("Giảng viên " + getFullName() + " đang nghỉ ngơi ,thư giãn...");
    }

    //abstract
    @Override
    protected void doWork() {
        System.out.println(getFullName() + " đang giảng dạy ....");
    }

    //hành động
    public final void mark() {
        //hành động chấm điểm
        System.out.println(getFullName() + " đang chấm điểm ....");
    }

    public final void prepare(String subject) {
        //soạn bài
        System.out.println(getFullName() + " đang soạn bài môn" + subject);
    }

    public final void createExam(String subject) {
        //ra đề
        System.out.println(getFullName() + " đang ra đề môn " + subject);
    }

    public final void joinMeeting() {
        //họp
        System.out.println("Giảng viên đang họp");
    }
}
