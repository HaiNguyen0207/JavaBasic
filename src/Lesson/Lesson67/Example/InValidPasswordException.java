package Lesson.Lesson67.Example;

public class InValidPasswordException extends Exception{
    private String inValidPassword;

    public InValidPasswordException() {
    }

    public InValidPasswordException(String inValidPassword) {
        this.inValidPassword = inValidPassword;
    }

    public InValidPasswordException(String message, String inValidPassword) {
        super(message);
        this.inValidPassword = inValidPassword;
    }

    public String getInValidPassword() {
        return inValidPassword;
    }

    public void setInValidPassword(String inValidPassword) {
        this.inValidPassword = inValidPassword;
    }
}
