package Lesson.Lesson67.Exercise5;

public class InValidFullNameException extends Exception{
    private String inValidFullName;

    public InValidFullNameException() {
    }

    public InValidFullNameException(String inValidFullName) {
        this.inValidFullName = inValidFullName;
    }

    public InValidFullNameException(String message, String inValidFullName) {
        super(message);
        this.inValidFullName = inValidFullName;
    }

    public String getInValidFullName() {
        return inValidFullName;
    }

    public void setInValidFullName(String inValidFullName) {
        this.inValidFullName = inValidFullName;
    }
}
