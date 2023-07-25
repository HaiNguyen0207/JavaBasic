package Lesson.Lesson67.Exercise1;

public class InValidAgeException extends Exception{
    private int inValidAge;

    public InValidAgeException() {
    }

    public InValidAgeException(int inValidAge) {
        this.inValidAge = inValidAge;
    }

    public InValidAgeException(String message, int inValidAge) {
        super(message);
        this.inValidAge = inValidAge;
    }

    public int getInValidAge() {
        return inValidAge;
    }

    public void setInValidAge(int inValidAge) {
        this.inValidAge = inValidAge;
    }
}
