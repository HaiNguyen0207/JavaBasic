package Lesson.Lesson67.Exercise5;

import java.util.Date;

public class Employee extends Person {
    private static int nextId = 1001;
    private String empId;   //mã nhân viên
    private String position;    //chức vụ
    private float salary;   //mức lương
    private float experience;   //kinh nghiệm
    private float workingDay;   //số ngày làm việc
    private float toltalSalary; //tuổng lương
    private float bonus;    //thưởng

    protected Employee() {
        empId = "";
        position = "";
        salary = 0f;
        experience = 0f;
        workingDay = 0f;
        toltalSalary = 0f;
        bonus = 0;
    }

    public Employee(String empId, String position, float salary, float experience,
                    float workingDay, float toltalSalary, float bonus) {
        setEmpId();
        this.position = position;
        this.salary = salary;
        this.experience = experience;
        this.workingDay = workingDay;
        this.toltalSalary = toltalSalary;
        this.bonus = bonus;
    }

    public Employee(String numberId, String fullName, String address, Date birthDay,
                    String email, String numberPhone, String empId, String position,
                    float salary, float experience, float workingDay, float toltalSalary,
                    float bonus) throws InValidFullNameException, InValidNumberPhoneException,
            InValidEmailException {
        super(numberId, fullName, address, birthDay, email, numberPhone);
        setEmpId();
        this.position = position;
        this.salary = salary;
        this.experience = experience;
        this.workingDay = workingDay;
        this.toltalSalary = toltalSalary;
        this.bonus = bonus;
    }

    public final static int getNextId() {
        return nextId;
    }

    public final static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public final String getEmpId() {
        return empId;
    }

    public final void setEmpId() {
        if (empId == null) {//mã nv = null chứng tỏ cần tạo mới
            this.empId = "EMP" + nextId;
            nextId++;
        } else {
            this.empId = empId;
        }
    }

    public final String getPosition() {
        return position;
    }

    public final void setPosition(String position) {
        this.position = position;
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

    public final float getWorkingDay() {
        return workingDay;
    }

    public final void setWorkingDay(float workingDay) {
        this.workingDay = workingDay;
    }

    public final float getToltalSalary() {
        return toltalSalary;
    }

    public final void setToltalSalary(float toltalSalary) {
        this.toltalSalary = toltalSalary;
    }

    public final float getBonus() {
        return bonus;
    }

    public final void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public final void calculWorkingDay() { //tính toán ngày công
        System.out.println("Số ngày công của : " + getFullNameString() + " là : " + workingDay);
    }

    //tính lương
    public float calculSalary() {
        return salary * workingDay / 22;
    }

    //tính thưởng
    public void calculBonus() {
        if (workingDay > 20) {
            bonus = (float) (((workingDay - 20) * salary) * 0.5 / 22);
        } else {
            bonus = 0;
        }
    }

    //tính tổng lương
    public float calculToTalSalary() {
        return toltalSalary = salary * workingDay / 22 + bonus;
    }

    //nhận thương
    public String receiveSalary() {
        return "Nhận tiền mặt ";
    }

    public String receiveBonus() {
        return "Chuyển khoản  ";
    }


    @Override
    public void sleep() {
        System.out.println("Nhân viên " + getFullNameString() + " đang ngủ trưa ...");
    }

    @Override
    public void talk() {
        System.out.println("Nhân viên " + getFullNameString() + " đang nói chuyện v" +
                "ới đồng nghiệp ...");
    }

    @Override
    public void doWork() {
        System.out.println("Nhân viên " + getFullNameString() + " đang soạn dự án ...");
    }

    @Override
    public int compareTo(Person other) {
        return getNumberId().compareTo(other.getNumberId());
    }
}
