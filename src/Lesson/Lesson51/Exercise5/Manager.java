package Lesson.Lesson51.Exercise5;

import java.util.Date;

public class Manager extends Employee {
    private Date start; //ngày bắt dầu nhiệm kì
    private Date end;   //ngày kết thúc nhiệm kì

    protected Manager() {
        start = new Date();
        end = new Date();
    }

    public Manager(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Manager(Employee employee, Date start, Date end) {
        super(employee.getId(), employee.getFullName(), employee.getAddress(), employee.getBitrhDay(), employee.getEmail(),
                employee.getNumber(), employee.getEmpId(), employee.getDuty(), employee.getSalary(),
                employee.getExperience(), employee.getWorkingDay(), employee.getBonus(), employee.getTotalSalary());
        this.start = start;
        this.end = end;
    }

    public Manager(String empId, String duty, float salary, float experience, float workingDay, float bonus,
                   float totalSalary, Date start, Date end) {
        super(empId, duty, salary, experience, workingDay, bonus, totalSalary);
        this.start = start;
        this.end = end;
    }

    public Manager(String id, String fullName, String address, Date bitrhDay, String email, String number, String empId,
                   String duty, float salary, float experience, float workingDay, float bonus, float totalSalary,
                   Date start, Date end) {
        super(id, fullName, address, bitrhDay, email, number, empId, duty, salary, experience, workingDay, bonus,
                totalSalary);
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    //tính tiền thưởng giám đốc
    public final void calculBonusMna() {
        if (getWorkingDay() >= 22) {
            setBouns(getTotalSalary() * 1.25f);
        } else {
            setBouns(0);
        }
    }

    @Override
    public void receiveSalary() {
        super.receiveSalary();
    }

    @Override
    public String receiBonus() {
        return "Nhận tiền mặt hoặc cổ phiếu";
    }

    @Override
    protected void doWord() {
        System.out.println("Giám đốc " + getFullName() + " đang kí kết hợp đồng...");
    }

    @Override
    public void eat() {
        System.out.println("Giám đốc " + getFullName() + " đang ăn trưa ...");
    }

    @Override
    public void sleep() {
        System.out.println("Giám đốc " + getFullName() + " đang ngủ trưa...");
    }

    @Override
    public void talk() {
        System.out.println("Giám đốc " + getFullName() + " đang nói chuyện với nhân viên...");
    }

    @Override
    public void relax() {
        System.out.println("Giám đốc " + getFullName() + " đang thư giãn nghỉ ngơi ...");
    }

    public final void meeting() {
        System.out.println("Giám đốc " + getFullName() + " đang họp hội đồng quản trị ...");
    }
}
