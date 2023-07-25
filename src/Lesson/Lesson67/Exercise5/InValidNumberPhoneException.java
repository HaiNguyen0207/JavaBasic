package Lesson.Lesson67.Exercise5;

public class InValidNumberPhoneException extends Exception{
    private String inValidNumberPhone;

    public InValidNumberPhoneException() {
    }

    public InValidNumberPhoneException(String inValidNumberPhone) {
        this.inValidNumberPhone = inValidNumberPhone;
    }

    public InValidNumberPhoneException(String message, String inValidNumberPhone) {
        super(message);
        this.inValidNumberPhone = inValidNumberPhone;
    }

    public void setInValidNumberPhone(String inValidNumberPhone) {
        this.inValidNumberPhone = inValidNumberPhone;
    }

    public String getInValidNumberPhone() {
        return inValidNumberPhone;
    }
}
