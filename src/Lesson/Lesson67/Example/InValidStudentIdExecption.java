package Lesson.Lesson67.Example;

public class InValidStudentIdExecption extends Exception{
    private String inValidId;

    public InValidStudentIdExecption() {
    }

    public InValidStudentIdExecption(String inValidId) {
        this.inValidId = inValidId;
    }

    public InValidStudentIdExecption(String message, String inValidId) {
        super(message);
        this.inValidId = inValidId;
    }

    public String getInValidId() {
        return inValidId;
    }

    public void setInValidId(String inValidId) {
        this.inValidId = inValidId;
    }
}
