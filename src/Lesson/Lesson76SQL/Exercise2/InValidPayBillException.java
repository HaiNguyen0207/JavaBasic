package Lesson.Lesson76SQL.Exercise2;

public class InValidPayBillException extends Exception{
    private double inValidPayBill;
    protected  InValidPayBillException() {

    }

    public InValidPayBillException(double inValidPayBill) {
        this.inValidPayBill = inValidPayBill;
    }

    public InValidPayBillException(String message, double inValidPayBill) {
        super(message);
        this.inValidPayBill = inValidPayBill;
    }

    public double getInValidPayBill() {
        return inValidPayBill;
    }

    public void setInValidPayBill(double inValidPayBill) {
        this.inValidPayBill = inValidPayBill;
    }
}
