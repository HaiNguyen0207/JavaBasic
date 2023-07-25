package Lesson.Lesson51.Exercise5;

import java.util.Date;

public class Employee extends Person {
    private static int nextId = 1001;
    private String empId;   //mã nhân viên
    private String duty;    //chức vụ
    private float salary;   //mức lương
    private float experience;   //kinh nghiệm
    private float workingDay;   //số ngày làm việc
    private float bonus;    //mức thưởng
    private float totalSalary;  //tổng lương

    protected Employee() {
        empId = "";
        duty = "";
        salary = 0f;
        experience = 0f;
        workingDay = 0f;
        bonus = 0f;
        totalSalary = 0f;
    }

    public Employee(String empId, String duty, float salary, float experience, float workingDay, float bonus,
                    float totalSalary) {
        setEmpId(empId);
        this.duty = duty;
        this.salary = salary;
        this.experience = experience;
        this.workingDay = workingDay;
        this.bonus = bonus;
        this.totalSalary = totalSalary;
    }

    public Employee(String id, String fullName, String address, Date bitrhDay, String email, String number,
                    String empId, String duty, float salary, float experience, float workingDay, float bonus,
                    float totalSalary) {
        super(id, fullName, address, bitrhDay, email, number);
        setEmpId(empId);
        this.duty = duty;
        this.salary = salary;
        this.experience = experience;
        this.workingDay = workingDay;
        this.bonus = bonus;
        this.totalSalary = totalSalary;
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

    public final void setEmpId(String empId) {
        if (empId == null) {//mã nhân viên = null ,cần tạo mới
            this.empId = "EMP" + nextId;
            nextId++;
        } else {
            this.empId = empId;
        }
    }

    public final String getDuty() {
        return duty;
    }

    public final void setDuty(String duty) {
        this.duty = duty;
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

    public final float getBonus() {
        return bonus;
    }

    public final void setBouns(float bonus) {
        this.bonus = bonus;
    }

    public final float getTotalSalary() {
        return totalSalary;
    }

    public final void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    //các hành động
    //tính công
    public final void culcalWorkingDay() {
        System.out.println("Ngày đi làm của nhân viên " + getFullName() + " là : " + getWorkingDay());
    }

    //tính  lương
    public final void calculSalary() {
        totalSalary = workingDay * salary / 22;
    }

    //tính thưởng
    public final void calculBounsEmp() {
        if (workingDay >= 20) {
            var bonusDay = workingDay - 20;
            bonus = bonusDay * 0.5f * salary / 22;
        } else {
            bonus = 0;
        }
    }

    public void receiveSalary() { // nhận lương
        System.out.println("Mức lương chuyển khoản của nhân viên "
                + getFullName() + ": " + totalSalary);
    }

    public String receiBonus() {
        return "Nhận tiền mặt";
    }

    @Override
    protected void doWord() {
        System.out.println("Nhân viên " + getFullName() + " đang code...");
    }

    @Override
    public void eat() {
        System.out.println("Nhân viên " + getFullName() + " đang ăn trưa...");
    }

    @Override
    public void sleep() {
        System.out.println("Nhân viên " + getFullName() + " đang ngủ nướng...");
    }

    @Override
    public void talk() {
        System.out.println("Nhân viên " + getFullName() + " đang nói chuyện với đồng nghiệp...");
    }

    @Override
    public void relax() {
        System.out.println("Nhân viên " + getFullName() + " đang thư giãn...");
    }
}
