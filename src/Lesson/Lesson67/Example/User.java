package Lesson.Lesson67.Example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String account;     //tài khoản
    private String password;    //mật khẩu

    protected User() {
    }

    public User(String account, String password)
            throws InValidAccountException, InValidPasswordException {
        setAccount(account);
        setPassword(password);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) throws InValidAccountException {
        var regex = "^[a-z]+[\\w._]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(account);
        if (matcher.matches()) {
            this.account = account;
        } else {
            var msg = "Tài khoản : " + account + " không hợp lệ .Vui lòng xem lại !";
            this.account = null;
            throw new InValidAccountException(msg, account);
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InValidPasswordException {
        var regex1 = "^(.){8,}$";
        var regex2 = "^.*[a-z]+.*+$";
        var regex3 = "^.*[A-Z]+.*+$";
        var regex4 = "^.*[0-9]+.*+$";
        var regex5 = account;
        Pattern pattern1 = Pattern.compile(regex1, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(password);
        Pattern pattern2 = Pattern.compile(regex2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(password);
        Pattern pattern3 = Pattern.compile(regex3, Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(password);
        Pattern pattern4 = Pattern.compile(regex4, Pattern.CASE_INSENSITIVE);
        Matcher matcher4 = pattern4.matcher(password);
        Pattern pattern5 = Pattern.compile(regex5, Pattern.CASE_INSENSITIVE);
        Matcher matcher5 = pattern5.matcher(password);
        if (matcher1.matches() && matcher2.matches() && matcher3.matches()
                && matcher4.matches() && !matcher5.matches()) {
            this.password = password;
        } else {
            this.password = null;
            var msg = "Password nhập không hợp lệ ! ";
            throw new InValidPasswordException(msg, password);
        }
    }
}
