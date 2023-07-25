package Lesson.Lesson67.Exercise5;

public class InValidEmailException extends Exception {
    private String inValidEmail;

    public InValidEmailException() {
    }

    public InValidEmailException(String inValidEmail) {
        this.inValidEmail = inValidEmail;
    }

    public InValidEmailException(String message, String inValidEmail) {
        super(message);
        this.inValidEmail = inValidEmail;
    }

    public String getInValidEmail() {
        return inValidEmail;
    }

    public void setInValidEmail(String inValidEmail) {
        this.inValidEmail = inValidEmail;
    }
}
