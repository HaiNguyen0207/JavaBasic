package Lesson.Lesson55.Exercise5;

import java.util.Date;

public class Manager extends Employee {
    private Date startDate; //ngày bắt đầu nhiệm kì
    private Date endDate;  //ngày kết thúc nhiệm kì

    protected Manager() {
        startDate = new Date();
        endDate = new Date();
    }

    public Manager(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Manager(Employee employee, Date startDate,
                   Date endDate) {
        super(employee.getEmpId(), employee.getPesition(), employee.getSalary(),
                employee.getExperciene(), employee.calculWorkingDay(),
                employee.calculSalary(), employee.getBonus());
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Manager(String id, String fullName, String address, Date birthDay, String email,
                   String number, String empId, String pesition, float salary, float experciene,
                   float workingDay, float totalSalary, float bonus, Date startDate, Date endDate) {
        super(id, fullName, address, birthDay, email, number, empId, pesition, salary, experciene,
                workingDay, totalSalary, bonus);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public final Date getStartDate() {
        return startDate;
    }

    public final void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public final Date getEndDate() {
        return endDate;
    }

    public final void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void joinMeeting() {
        System.out.println("Giám đốc " + getFullName().getFirst() + " đang họp ...");
    }

    public void signDocument() {
        System.out.println("Giám đốc đang kí văn bản");
    }

    public void meetPartner() {
        System.out.println("Giám đốc đang gặp gỡ đối tác");
    }


    @Override
    public float calculTotalSalary() { //tính tổng lương
        return super.calculTotalSalary();
    }

    @Override
    public void calculBonus() {//tính thưởng
        if (getWorkingDay() > 22) {
            setBonus(0.25f * getSalary());
        } else {
            setBonus(0);
        }
    }

    @Override
    public float calculSalary() {//tính lương
        return super.calculSalary();
    }

    @Override
    public String receiBonus() {
        return "Nhận cổ phiếu ";
    }

    @Override
    protected void eat() {
        System.out.println("Giám đốc " + getFullName().getFirst() + " đang ăn trưa ...");
    }

    @Override
    protected void sleep() {
        System.out.println("Giám đốc " + getFullName().getFirst() + " đang ngủ ...");
    }
}
