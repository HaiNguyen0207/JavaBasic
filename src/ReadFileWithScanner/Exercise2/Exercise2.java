package ReadFileWithScanner.Exercise2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Exercise2 {

    /**
     * Bài 2. Viết chương đọc vào một mảng chứa điểm trung bình học kì của n sinh viên trong một
     * lớp và sắp xếp mảng này theo thứ tự giảm dần. Hiển thị mảng trước và sau khi sắp xếp. Nội
     * dung cần đọc cho trong file input2.txt. Định dạng như sau:
     * - Dòng đầu tiên là số sinh viên n.
     * - Dòng tiếp theo là n điểm tương ứng của n sinh viên phân tách nhau bởi 1 vài khoảng
     * trắng.
     * Ví dụ file input2.txt:
     */
    public static void main(String[] args) throws IOException {
        File file = new File("input2.txt");
        var input = new Scanner(file);
        var n = input.nextInt();
        var mark = getMark(n, input);
        sortAsc(mark, 0, mark.length - 1);
        show(mark);
    }

    private static float[] getMark(int n, Scanner input) {
        float[] mark = new float[n];
        for (int i = 0; i < n; i++) {
            mark[i] = input.nextFloat();
        }
        return mark;
    }

    private static void sortAsc(float[] numbers, int left, int right) {
        if (left < right) {
            var mid = (right + left) / 2;
            sortAsc(numbers, left, mid);
            sortAsc(numbers, mid + 1, right);
            merge(numbers, left, mid, right);
        }
    }

    private static void merge(float[] numbers, int left, int mid, int right) {
        var size1 = mid - left + 1;
        var size2 = right - mid;
        float[] arr1 = new float[size1];
        float[] arr2 = new float[size2];
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
            if (arr1[i] > arr2[j]) {
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

    private static void show(float[] numbers) {
        for (var e : numbers) {
            System.out.print(e + " ");
        }
        System.out.println();
    }


}
