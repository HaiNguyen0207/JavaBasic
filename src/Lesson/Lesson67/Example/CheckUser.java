package Lesson.Lesson67.Example;

import java.util.Scanner;

public class CheckUser {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        User user = new User();
        System.out.println("Nhập gmail : ");
        var account = input.nextLine();
        System.out.println("Nhập password : ");
        var password = input.nextLine();
        try {
            user.setAccount(account);
            user.setPassword(password);
        } catch (InValidAccountException e) {
            System.out.println(e.getMessage());
        } catch (InValidPasswordException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Tài khoản người dùng  : " + user.getAccount());
        System.out.println("Password : " + user.getPassword());
    }
}
