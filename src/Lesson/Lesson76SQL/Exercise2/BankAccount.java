package Lesson.Lesson76SQL.Exercise2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccount {
    private static int nextId = 1;
    private int id;
    private String numberCard;    //số thẻ
    private String numberAcc;   //số tài khoản
    private String name;    //tên tài khoản
    private double surplus; //số dư

    protected BankAccount() {
        id = 0;
        numberCard = "";
        numberAcc = "";
        name = "";
        surplus = 0;
    }

    public BankAccount(int id, String numberCard, String numberAcc, String name, double surplus) {
        this.setId();
        this.numberCard = numberCard;
        this.numberAcc = numberAcc;
        this.name = name;
        this.surplus = surplus;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        BankAccount.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        if (id == 0) {
            this.id = nextId;
            nextId++;
        } else {
            getId();
        }
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
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

    public double getSurplus() {
        return surplus;
    }

    public void setSurplus(double surplus) {
        this.surplus = surplus;
    }



    //paybill
    public boolean checkPayBillException(double amount) {
        var regex = "^\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(amount + "");
        return matcher.matches();
    }

    public boolean deposit(double amount) throws InValidPayBillException {
        if (checkPayBillException(amount)) {
            surplus += amount;
            return true;
        } else {
            var msg = "Số tiền thanh toán không hợp lệ ! Vui lòng xem lại ";
            throw new InValidPayBillException(msg, 0);
        }
    }

    public boolean withdraw(double amount) throws InValidPayBillException {
        if (amount > 0 && amount <= surplus) {
            if (checkPayBillException(amount)) {
                surplus -= amount;
                return true;
            } else {
                var msg = "Số tiền thanh toán không hợp lệ ! Vui lòng xem lại ";
                throw new InValidPayBillException(msg, 0);
            }
        }
        return false;
    }

    public boolean transfer(BankAccount other, double amount) throws InValidPayBillException {
        if (amount > 0 && amount < surplus) {
            if (checkPayBillException(amount)) {
                surplus -= amount;
                other.surplus += amount;
                return true;
            } else {
                var msg = "Số tiền thanh toán không hợp lệ ! Vui lòng xem lại ";
                throw new InValidPayBillException(msg, 0);
            }
        }
        return false;
    }

    public boolean payBill(double amount) throws InValidPayBillException {
        if (amount > 0 && amount < surplus) {
            if (checkPayBillException(amount)) {
                surplus -= amount;
                return true;
            } else {
                var msg = "Số tiền thanh toán không hợp lệ ! Vui lòng xem lại ";
                throw new InValidPayBillException(msg, 0);
            }
        }
        return false;
    }

}
