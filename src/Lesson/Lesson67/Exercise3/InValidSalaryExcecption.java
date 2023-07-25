package Lesson.Lesson67.Exercise3;

public class InValidSalaryExcecption extends Exception {
    private float inValidSalary;

    public InValidSalaryExcecption() {
    }

    public InValidSalaryExcecption(float inValidSalary) {
        this.inValidSalary = inValidSalary;
    }

    public float getInValidSalary() {
        return inValidSalary;
    }

    public void setInValidSalary(float inValidSalary) {
        this.inValidSalary = inValidSalary;
    }

    public InValidSalaryExcecption(String message, float inValidSalary) {
        super(message);
        this.inValidSalary = inValidSalary;
    }

    public InValidSalaryExcecption(String message) {
        super(message);
    }
}
