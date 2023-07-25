package Lesson.Lesson55.Exercise5;

import java.util.Calendar;
import java.util.Date;

public class Employee extends Person {
    private static int nextId = 1001;
    private String empId;   //mã nhân viên
    private String pesition;    //chức vụ
    private float salary;   //mức lương
    private float experciene;   //kinh nghiệm
    private float workingDay;   //số ngày làm việc
    private float totalSalary;  //tổng lương
    private float bonus;   //thưởng

    protected Employee() {
        empId = "";
        pesition = "";
        salary = 0f;
        experciene = 0f;
        workingDay = 0f;
        totalSalary = 0f;
        bonus = 0f;
    }

    public Employee(String empId, String pesition, float salary, float experciene,
                    float workingDay, float totalSalary, float bonus) {
        setEmpId();
        this.pesition = pesition;
        this.salary = salary;
        this.experciene = experciene;
        this.workingDay = workingDay;
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    public Employee(String id, String fullName, String address, Date birthDay, String email,
                    String number, String empId, String pesition, float salary, float experciene,
                    float workingDay, float totalSalary, float bonus) {
        super(id, fullName, address, birthDay, email, number);
        setEmpId();
        this.pesition = pesition;
        this.salary = salary;
        this.experciene = experciene;
        this.workingDay = workingDay;
        this.totalSalary = totalSalary;
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
        if (empId == null) {//mã NV =null ,cần tạo mới
            this.empId = "EMP" + nextId;
            nextId++;
        } else {
            this.empId = empId;
        }
    }

    //lấy năm sinh
    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getBirthDay());
        return calendar.get(Calendar.YEAR);
    }

    public final String getPesition() {
        return pesition;
    }

    public final void setPesition(String pesition) {
        this.pesition = pesition;
    }

    public final float getSalary() {
        return salary;
    }

    public final void setSalary(float salary) {
        this.salary = salary;
    }

    public final float getExperciene() {
        return experciene;
    }

    public final void setExperciene(float experciene) {
        this.experciene = experciene;
    }

    public final float getWorkingDay() {
        return workingDay;
    }

    public final void setWorkingDay(float workingDay) {
        this.workingDay = workingDay;
    }

    public final float getTotalSalary() {
        return totalSalary;
    }

    public final void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    public final float getBonus() {
        return bonus;
    }

    public final void setBonus(float bonus) {
        this.bonus = bonus;
    }

    //hành động tính công
    public final float calculWorkingDay() {
        return workingDay;
    }

    //tính lương
    public float calculSalary() {
        return workingDay * salary / 22;
    }

    public void receiveSalary() { // nhận lương
        System.out.println("Mức lương chuyển khoản của nhân viên "
                + getFullNameString() + ": " + totalSalary);
    }

    public String receiBonus() {
        return "Nhận tiền mặt";
    }

    //tính thưởng
    public void calculBonus() {
        if (workingDay >= 20) {
            var s = workingDay - 20;
            bonus = s * 0.5f * salary / 22;
        } else {
            bonus = 0;
        }
    }

    //tính tổng lương
    public float calculTotalSalary() {
        var s = calculSalary();
        return totalSalary = s + bonus;
    }

    @Override
    protected void eat() {
        System.out.println("Nhân viên " + getFullNameString() + " đang ăn trưa...");
    }

    @Override
    protected void sleep() {
        System.out.println("Nhân viên " + getFullNameString() + " đang ngủ nướng...");
    }

    @Override
    protected void doWork() {
        System.out.println("Nhân viên " + getFullNameString() + " đang làm việc...");
    }

    @Override
    protected void talk() {
        System.out.println("Nhân viên " + getFullNameString() + " đang nói chuyện với đồng nghiệp..");
    }

    @Override
    protected void entertainment() {
        System.out.println("Nhân viên " + getFullNameString() + " đang giải trí...");
    }

}
