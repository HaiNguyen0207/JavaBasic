package Lesson.Lesson67.Exercise4;

public class InValidbBrandNameException extends Exception {
    private String InValidNameBrand;
    protected InValidbBrandNameException() {

    }

    public InValidbBrandNameException(String inValidNameBrand) {
        InValidNameBrand = inValidNameBrand;
    }

    public InValidbBrandNameException(String message, String inValidNameBrand) {
        super(message);
        InValidNameBrand = inValidNameBrand;
    }

    public String getInValidNameBrand() {
        return InValidNameBrand;
    }

    public void setInValidNameBrand(String inValidNameBrand) {
        InValidNameBrand = inValidNameBrand;
    }
}
