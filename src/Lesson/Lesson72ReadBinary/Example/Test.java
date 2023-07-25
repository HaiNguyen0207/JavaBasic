package Lesson.Lesson72ReadBinary.Example;

import java.io.*;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        var inputFile = "C:\\Users\\unilap\\Downloads\\x.mp3";
        var outputFile = "C:\\Users\\unilap\\Pictures\\x10.mp3";
        File file = new File(inputFile);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
             BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)) {
            var start = new Date().getTime();
            final int SIZE = 8 * 1024;
            byte[] buffer = new byte[SIZE];
            while ((inputStream.read(buffer)) != -1) {
                outputStream.write(buffer);
            }
            var end = new Date().getTime();
            System.out.println("Kích thước file : " + (file.length() / 1024) + "KB");
            System.out.println("Thời gian copy: " + (end - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
