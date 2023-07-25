package ReadFileWithScanner.Exercise1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {
    /**
     * Bài 1. Viết chương trình đọc vào một mảng gồm n phần tử các số nguyên từ file input1.txt sau
     * đó sắp xếp mảng này theo thứ tự tăng dần.
     */
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            var input = new Scanner(file);
            var n = input.nextInt();
            var numbers = getNumbers(n, input);
            System.out.println("Mảng trước trước khi sắp xếp :");
            showNumbers(numbers);
            System.out.println("Mảng sau khi sắp xếp : ");
            sortAsc(numbers, 0, numbers.length - 1);
            showNumbers(numbers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void sortAsc(int[] numbers, int left, int right) {
        if (left < right) {
            var mid = (right + left) / 2;
            sortAsc(numbers, left, mid );
            sortAsc(numbers, mid + 1, right);
            merge(numbers, left, mid, right);
        }
    }

    private static void merge(int[] numbers, int left, int mid, int right) {
        var size1 = mid - left + 1;
        var size2 = right - mid;
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        for (int i = 0; i < size1; i++) {
            arr1[i] = numbers[left + i];
        }
        for (int i = 0; i < size2; i++) {
            arr2[i] = numbers[mid + 1 + i];
        }
        var i = 0;
        var j = 0;
        var k = left;
        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                numbers[k++] = arr1[i++];
            } else {
                numbers[k++] = arr2[j++];
            }
        }
        while (i < size1) {
            numbers[k++] = arr1[i++];
        }
        while (j < size2) {
            numbers[k++] = arr2[j++];
        }
    }

    private static void showNumbers(int[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static int[] getNumbers(int n, Scanner input) {
        int numbers[] = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }
        return numbers;
    }
}
