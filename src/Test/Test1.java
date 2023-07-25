package Test;


import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {
    private static ArrayList<Integer> kq;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số n = ");
        int n = input.nextInt();
        System.out.println("Nhập số m = ");
        int m = input.nextInt();
        int[] p = arrayPrime(n); // mảng chức cái nuyên tố
        kq = new ArrayList<>();
        generatemangCon(p, n); // tìm tất cả các tập con có tổng = n
    }

    private static int[] arrayPrime(int n) {
        int[] p = new int[n];
        int j = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                p[j] = i;
                j++;
            }
        }
        return p;
    }

    private static boolean isPrime(int i) {
        if (i < 2) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    // phương thức in tất cả các tập con có tổng == n
    private static void generatemangCon(int[] p, int n) {
        int total = 0;
        int[] mangCon = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            total += p[i];
        }
        if (p[0] <= n && total >= n) {
            mangConum(p, mangCon, 0, 0, 0, n);
        }
    }


    private static void mangConum(int[] p, int[] mangCon,
                                  int sizeCon, int sum, int current, int n) {
        if (n == sum) { // nếu tổng hiện tại bằng tổng mục tiêu
            printSubset(mangCon, sizeCon); // hiển thị tập kết quả
            // nếu chỉ số phần tử kế tiếp còn trong biên mảng tập đầu vào
            // và tổng hiện thời trừ phần tử đang xét + tổng phần tử kế tiếp nhỏ hơn tổng mục tiêu
            if (current + 1 < p.length && sum - p[current] + p[current + 1] <= n) {
                // tiếp tục đệ quy để tìm tập kết quả tiếp theo, loại bỏ phần tử hiện tại
                mangConum(p, mangCon, sizeCon - 1, sum - p[current],
                        current + 1, n);
            }
        } else {
            // kiểm tra ràng buộc chỉ số phần tử
            if (current < p.length && sum + p[current] <= n) {
                // sinh các node dọc theo chiều rộng của mảng đầu vào
                for (int i = current; i < p.length; i++) {
                    mangCon[sizeCon] = p[i];
                    if (sum + p[i] <= n) { // nếu tổng hiện thời với phần tử đang xét nhỏ hơn hoặc bằng mục tiêu
                        // xem xét tìm tổng tập con của level tiếp theo
                        mangConum(p, mangCon, sizeCon + 1,
                                sum + p[i], i + 1, n);
                    }
                }
            }
        }
    }

    private static void printSubset(int[] mangCon, int sizeCon) {
        for (int i = 0; i < sizeCon; i++) {
            System.out.print(mangCon[i] + " ");
        }
        System.out.println();
    }
}
