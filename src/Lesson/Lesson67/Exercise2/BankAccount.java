package Lesson.Lesson67.Exercise2;

import Lesson.Lesson62.Exercise1.InValidAgeCatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccount {
    private String number;  //số thẻ
    private String numberAcc;   //số tài khoản
    private String name;    //tên chủ tài khoản
    private long surlus;   //số dư

    protected BankAccount() {
        number = "";
        name = "";
        numberAcc = "";
        surlus = 0;
    }

    public BankAccount(String numberAcc) {
        this.numberAcc = numberAcc;
    }

    public BankAccount(String numberAcc, long surlus) {
        this.numberAcc = numberAcc;
        this.surlus = surlus;
    }

    public BankAccount(String number, String numberAcc, String name, long surlus) {
        this.number = number;
        this.numberAcc = numberAcc;
        this.name = name;
        this.surlus = surlus;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberAcc() {
        return numberAcc;
    }

    public void setNumberAcc(String numberAcc) {
        this.numberAcc = numberAcc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSurlus() {
        return surlus;
    }

    public void setSurlus(long surlus) {
        this.surlus = surlus;
    }

    //nạp tiền
    public void deposit(long amount) throws InValidAgeCatException {
        if (isValid(amount)) {
            surlus += amount;
            System.out.println("Giao dịch nạp tiền vào tài khoản \"" +
                    numberAcc + "\" hoàn tất!");
        } else {
            this.surlus = 0;
            var msg = "Số tiền nạp đã quá hạn mức ";
            throw new InValidAgeCatException(msg, amount);
        }

    }

    //rút tiền
    public void withraw(long amount) throws InValidAgeCatException {
        if (isValid(amount) && amount <= surlus) {
            surlus -= amount;
            System.out.println("Rút " + amount + " khỏi số tài khoản : " +
                    "" + numberAcc + " thành công !");
        } else {
            var msg = "Số tiền rút không hợp lệ " + amount;
            throw new InValidAgeCatException(msg, amount);
        }
    }

    //chuyển tiền
    public void transfer(BankAccount other, long amount) throws InValidAgeCatException {
        if (isValid(amount) && amount <= surlus) {
            other.surlus += amount;
            surlus -= amount;
            System.out.println("Chuyển số tiền " + amount + " đến số tài khoản "
                    + other.numberAcc + " thành công !");
        } else {
            var msg = "Giao dịch không hợp lệ :" + amount;
            throw new InValidAgeCatException(msg, amount);
        }

    }

    //thanh toán hóa đơn
    public void payBill(long amount) throws InValidAgeCatException {
        if (isValid(amount) && amount <= surlus) {
            surlus -= amount;
            System.out.println("Thanh toán hóa đơn thành công : " + amount);
        } else {
            var msg = "Giao dịch không hợp lệ : " + amount;
            throw new InValidAgeCatException(msg, amount);
        }
    }


    //phương thức helper
    public boolean isValid(long amount) {
        var regex = "\\d{1,8}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(amount + "");
        return matcher.matches();
    }


}
