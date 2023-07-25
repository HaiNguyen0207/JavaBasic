package Lesson.Lesson64;

import java.util.TreeSet;

public class Lesson66A {
    public static void main(String[] args) {
        TreeSet<String> myFriends = new TreeSet<>();
        myFriends.add("Huy");
        myFriends.add("Hưng");
        myFriends.add("Minh");
        myFriends.add("Quang");
        myFriends.add("Mạnh");
        for (var e : myFriends) {
            System.out.println(e);
        }
    }
}
