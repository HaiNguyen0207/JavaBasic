package Lesson.Lesson67.Exercise2;

public class InValidAmountException extends Exception{
    private  long inValidAmount;

    public InValidAmountException() {
    }

    public InValidAmountException(long inValidAmount) {
        this.inValidAmount = inValidAmount;
    }

    public InValidAmountException(String message, long inValidAmount) {
        super(message);
        this.inValidAmount = inValidAmount;
    }

    public float getInValidAmount() {
        return inValidAmount;
    }

    public void setInValidAmount(long inValidAmount) {
        this.inValidAmount = inValidAmount;
    }
}
