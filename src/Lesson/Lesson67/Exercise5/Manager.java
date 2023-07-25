package Lesson.Lesson67.Exercise5;

import java.util.Date;

public class Manager extends Employee {
    private Date start; //ngày bắt đầu nhiệm kì
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
        super(employee.getEmpId(), employee.getPosition(), employee.getSalary(),
                employee.getExperience(), employee.getWorkingDay(),
                employee.getToltalSalary(), employee.getBonus());
        this.start = start;
        this.end = end;
    }

    public Manager(String empId, String position, float salary, float experience,
                   float workingDay, float toltalSalary, float bonus, Date start, Date end) {
        super(empId, position, salary, experience, workingDay, toltalSalary, bonus);
        this.start = start;
        this.end = end;
    }

    public Manager(String numberId, String fullName, String address, Date birthDay,
                   String email, String numberPhone, String empId, String position,
                   float salary, float experience, float workingDay, float toltalSalary,
                   float bonus, Date start, Date end) throws InValidFullNameException,
            InValidNumberPhoneException, InValidEmailException {
        super(numberId, fullName, address, birthDay, email, numberPhone, empId, position,
                salary, experience, workingDay, toltalSalary, bonus);
        this.start = start;
        this.end = end;
    }

    public final Date getStart() {
        return start;
    }

    public final void setStart(Date start) {
        this.start = start;
    }

    public final Date getEnd() {
        return end;
    }

    public final void setEnd(Date end) {
        this.end = end;
    }

    //override


    @Override
    public float calculSalary() {
        return super.calculSalary();
    }


    public void calculBonusManager() {
        if (getWorkingDay() > 22) {
            setBonus((float) (0.25 * getSalary()));
        } else {
            setBonus(0);
        }
    }

    @Override
    public float calculToTalSalary() {
        return super.calculToTalSalary();
    }


    @Override
    public String receiveSalary() {
        return "Nhận cổ phiếu  ";
    }

    @Override
    public String receiveBonus() {
        return "Nhận tiền mặt ";
    }

    @Override
    public void sleep() {
        System.out.println("Giám đốc " + getFullNameString() + " đang ngủ....");
    }

    @Override
    public void talk() {
        System.out.println("Giám đốc " + getFullNameString() + " đang nói chuyện....");
    }

    @Override
    public void doWork() {
        System.out.println("Giám đốc " + getFullNameString() + " đang làm việc....");
    }

    public void joinMeeting() {
        System.out.println("Giám đốc " + getFullNameString() + " đang họp ");
    }

}
