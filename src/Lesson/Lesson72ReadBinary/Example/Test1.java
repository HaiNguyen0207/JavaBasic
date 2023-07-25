package Lesson.Lesson72ReadBinary.Example;

import java.io.*;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        var inputFile = "C:\\Users\\unilap\\Downloads\\x.mp3";
        var outputFile = "C:\\Users\\unilap\\Pictures\\x7.mp3";
        File file = new File(inputFile);
        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
             BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);) {
            final int SIZE = 8 * 1024;
            var start = new Date().getTime();
            byte[] bytes = new byte[SIZE];
            while (inputStream.read(bytes) != -1) {
                outputStream.write(bytes, 0, bytes.length);
            }
            var end = new Date().getTime();
            System.out.println("Thời gian cop : " + (end - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
