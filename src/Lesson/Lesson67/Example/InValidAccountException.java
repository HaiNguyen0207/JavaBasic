package Lesson.Lesson67.Example;

public class InValidAccountException extends Exception{
    private String inVlalidAccount;

    public InValidAccountException() {
    }

    public InValidAccountException(String inVlalidAccount) {
        this.inVlalidAccount = inVlalidAccount;
    }

    public InValidAccountException(String message, String inVlalidAccount) {
        super(message);
        this.inVlalidAccount = inVlalidAccount;
    }

    public String getInVlalidAccount() {
        return inVlalidAccount;
    }

    public void setInVlalidAccount(String inVlalidAccount) {
        this.inVlalidAccount = inVlalidAccount;
    }
}
