package Lesson.Lesson62.Exercise1;

public class InValidAgeCatException extends Exception{
    private  long inValidAge ;

    public InValidAgeCatException() {
    }

    public InValidAgeCatException(String message, long inValidAge) {
        super(message);
        this.inValidAge = inValidAge;
    }

    public long getInValidAge() {
        return inValidAge;
    }

    public void setInValidAge(int inValidAge) {
        this.inValidAge = inValidAge;
    }
}
