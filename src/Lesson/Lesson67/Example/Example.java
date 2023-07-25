package Lesson.Lesson67.Example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {
        var regex = "\\s+";
        String str = "Hi there! I love learning Java programming " +
                "language. I hope you enjoy it too. ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        System.out.println("Chuỗi chỉ chứa dấu cách ?" + matcher.matches());
        var newStr = pattern.split(str);
        for (var item : newStr) {
            System.out.println(item);
        }
        var newStr1 = matcher.replaceAll("_");
        System.out.println(newStr1);
    }
}
