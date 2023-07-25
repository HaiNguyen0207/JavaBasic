package Lesson.Lesson63;


import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        ArrayList<Integer> number = new ArrayList<>();
        addNumber(number);
        ArrayList<String> myFriend = new ArrayList<>();
        addMyFriend(myFriend);
        System.out.println("Danh sách các con số : ");
        show(number);
        System.out.println("Danh sách những người bạn : ");
        show(myFriend);

    }

    private static <T> void show(ArrayList<T> list) {
        for (var item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    //Thêm người bạn
    private static void addMyFriend(ArrayList<String> myFriend) {
        myFriend.add("Hải");
        myFriend.add("Huy");
        myFriend.add("Minh");
        myFriend.add("Mạnh");
        myFriend.add("Hưng");
    }

    //Thêm phần tử vô number list
    private static void addNumber(ArrayList<Integer> number) {
        number.add(1);
        number.add(3);
        number.add(7);
        number.add(4);
        number.add(19);
    }
}
