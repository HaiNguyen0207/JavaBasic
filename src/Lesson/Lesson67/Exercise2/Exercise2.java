package Lesson.Lesson67.Exercise2;

import Lesson.Lesson62.Exercise1.InValidAgeCatException;


import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) throws InValidAmountException {
        var input = new Scanner(System.in);
        BankAccount acc1 = new BankAccount("3690102072002", 200000);
        BankAccount acc2 = new BankAccount("03946592301", 200000);
        var chocice = 0;
        do {
            System.out.println("==============MENU==============");
            System.out.println("= 1.Nạp tiền                   =");
            System.out.println("= 2.Chuyển tiền                =");
            System.out.println("= 3.Rút tiền                   =");
            System.out.println("= 4.Thanh toán hóa đơn         =");
            System.out.println("================================");
            chocice = input.nextInt();
            switch (chocice) {
                case 0:
                    System.out.println("Kết thúc chương trình ");
                    break;
                case 1:
                    deposit(acc1, input);//nạp tiền
                    System.out.println("Số dư hiện tại của " + acc1.getNumberAcc()
                            + ": " + acc1.getSurlus());
                    break;
                case 2:
                    transfer(acc1, acc2, input);
                    System.out.println("Số dư hiện tại của " + acc1.getNumberAcc()
                            + ": " + acc1.getSurlus());
                    System.out.println("Số dư hiện tại của " + acc2.getNumberAcc()
                            + ": " + acc2.getSurlus());
                    break;
                case 3:
                    withdraw(acc2, input);
                    System.out.println("Số dư hiện tại của " + acc2.getNumberAcc()
                            + ": " + acc2.getSurlus());
                    break;
                case 4:
                    payBill(acc1, input);
                    System.out.println("Số dư hiện tại của " + acc1.getNumberAcc()
                            + ": " + acc1.getSurlus());
                    break;
                default:
                    System.out.println("sai chức năng ! Vui lòng chọn lại ");
            }
        } while (chocice != 0);
        deposit(acc1, input);//nạp tiền
    }

    /**
     * phương thức thanh toán hóa đơn
     * mặc định acc1 thanh toán
     *
     * @param acc1  tk thanh toán
     * @param input đối tượng lớp Scanner
     * @throws InValidAmountException xử lý ngoại lệ
     */
    private static void payBill(BankAccount acc1, Scanner input)
            throws InValidAmountException {
        System.out.println("Nhập tổng tiền thanh toán hóa đơn : ");
        input.nextLine();
        var amountStr = input.nextLine().trim();
        if (amountStr.matches("\\d+")) {
            long amount = Long.parseLong(amountStr);
            try {
                acc1.payBill(amount);
            } catch (InValidAgeCatException e) {
                e.printStackTrace();
                System.out.println("Số tiền giao dịch không hợp lệ -Giao dịch thất bại ");
            }
        } else {
            throw new InValidAmountException("Giao dịch không hợp lệ ", 0);
        }
    }

    /**
     * phương thức chuyển tiền
     * mặc định acc1 là stk chuyển
     * acc2 là stk nhận
     *
     * @param acc1  tk chuyển
     * @param acc2  tk nhận
     * @param input đối tượng lớp Scanner
     * @throws InValidAmountException xử lý ngoại lệ
     */
    private static void transfer(BankAccount acc1, BankAccount acc2, Scanner input)
            throws InValidAmountException {
        System.out.println("Nhập số tiền chuyển : ");
        input.nextLine();
        var amountStr = input.nextLine().trim();
        if (amountStr.matches("\\d+")) {
            long amunt = Long.parseLong(amountStr);
            try {
                acc1.transfer(acc2, amunt);
            } catch (InValidAgeCatException e) {
                e.printStackTrace();
                System.out.println("Số tiền giao dịch không hợp lệ -Giao dịch thất bại ");
            }
        } else {
            throw new InValidAmountException("Số tiền giao dịch không hợp lệ ", 0);
        }
    }

    /**
     * phương thức rút tiền
     *
     * @param acc2  tk rút
     * @param input đối tượng lớp Scanner
     * @throws InValidAmountException xử lý ngoại lệ
     */
    private static void withdraw(BankAccount acc2, Scanner input)
            throws InValidAmountException {
        System.out.println("Nhập số tiền rút : ");
        input.nextLine();
        var amountStr = input.nextLine().trim();
        if (amountStr.matches("\\d+")) {
            long amount = Long.parseLong(amountStr);
            try {
                acc2.withraw(amount);
            } catch (InValidAgeCatException e) {
                e.printStackTrace();
                System.out.println("Số tiền rút không hợp lệ -Giao dịch thất bại  ");
            }
        } else {
            throw new InValidAmountException("Số tiền giao dịch không hợp lệ ", 0);
        }
    }

    /**
     * phương thức nạp tiền vào tài khoản
     *
     * @param acc1  tài khoản nạp tiền
     * @param input đối tượng scanner
     * @throws InValidAmountException xử lý ngoại lệ
     */
    private static void deposit(BankAccount acc1, Scanner input)
            throws InValidAmountException {
        System.out.println("Nhập số tiền cần nạp vào tài khoản : ");
        input.nextLine();
        var amountStr = input.nextLine().trim();
        if (amountStr.matches("\\d+")) {
            long amount = Long.parseLong(amountStr);
            System.out.println("Số dư ban dầu : " + acc1.getSurlus());
            try {
                acc1.deposit(amount);
            } catch (InValidAgeCatException e) {
                e.printStackTrace();
                System.out.println("Giao dịch thất bại ");
            }
        } else {
            throw new InValidAmountException("Số tiền giao dịch không hợp lệ ", 0);

        }
    }
}
