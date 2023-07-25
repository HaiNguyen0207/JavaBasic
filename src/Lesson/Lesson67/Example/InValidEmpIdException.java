package Lesson.Lesson67.Example;

public class InValidEmpIdException extends Exception {
    private String inValidEmpId;

    protected InValidEmpIdException() {

    }

    public InValidEmpIdException(String inValidEmpId) {
        this.inValidEmpId = inValidEmpId;
    }

    public InValidEmpIdException(String message, String inValidEmpId) {
        super(message);
        this.inValidEmpId = inValidEmpId;
    }

    public String getInValidEmpId() {
        return inValidEmpId;
    }

    public void setInValidEmpId(String inValidEmpId) {
        this.inValidEmpId = inValidEmpId;
    }
}
