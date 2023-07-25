package Test;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên : ");
        int n = input.nextInt();
        Student[] students = new Student[n];
        int choice = 0;
        getStudentInfor(students, n, input);
        do {
            System.out.println("=================> Menu <===============");
            System.out.println("= 1. Xuất thông tin sinh viên          =");
            System.out.println("= 2. Tìm  sinh viên lớn tuổi nhất      =");
            System.out.println("= 3. Sắp xếp sinh viên theo tuổi       =");
            System.out.println("= 0. Kết thúc chương trình             =");
            System.out.println("========================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("===> Chương trình kết thúc <=====");
                    break;
                case 1:
                    showStudentsInfor(students, n);
                    break;
                case 2:
                    int maxAge = findStudentAgeLargest(students);
                    showStudentInforMaxAge(students, maxAge);
                    break;
                case 3:
                    // cop mảng gốc ra mảng khác
                    // sắp xếp k ảnh hương đến mảng gốc
                    Student[] students1 = studentsCopy(students, n);
                    sortStudentsByAge(students1, 0, n - 1);
                    showStudentsInfor(students1, n);
            }
        } while (choice != 0);
    }

    private static Student[] studentsCopy(Student[] students, int n) {
        Student[] students1 = new Student[n];
        for (int i = 0; i < n; i++) {
            students1[i] = students[i];
        }
        return students1;
    }

    /**
     * phương thức sắp xếp sinh viên theo tuỏi
     * có gọi theo lời đệ quy
     *
     * @param students1
     * @param left
     * @param right
     */
    private static void sortStudentsByAge(Student[] students1, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortStudentsByAge(students1, left, mid - 1);
            sortStudentsByAge(students1, mid + 1, right);
            mergeSortStudents(students1, left, mid, right);
        }
    }

    /**
     * phương thức sắp xếp merge sort theo tuổi
     *
     * @param students1 danh sách sinh viên
     * @param left      phần tử đầu
     * @param mid       giữa
     * @param right     cuối
     */
    private static void mergeSortStudents(Student[] students1, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;
        Student[] arr1 = new Student[size1];
        Student[] arr2 = new Student[size2];
        for (int i = 0; i < size1; i++) {
            arr1[i] = students1[left + i];
        }
        for (int j = 0; j < size2; j++) {
            arr2[j] = students1[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < size1 && j < size2) {
            if (arr1[i].getAge() < arr2[j].getAge()) {
                students1[k++] = arr1[i++];
            } else {
                students1[k++] = arr2[j++];
            }
        }
        while ((i < size1)) {
            students1[k++] = arr1[i++];
        }
        while (j < size2) {
            students1[k++] = arr2[j++];
        }
    }

    /**
     * phương thức hiển thị thông tin sinh viên nhiều tuoir nhất
     *
     * @param students danh sách sinh viên
     * @param maxAge   tuổi max
     */
    private static void showStudentInforMaxAge(Student[] students, int maxAge) {
        System.out.printf("%-20s%-20s%-20s\n", "Mã ID", "Họ Tên", "Tuổi");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getAge() == maxAge) {
                System.out.printf("%-20s%-20s%-20d\n", students[i].getId(),
                        students[i].getFullName(), students[i].getAge());
            }
        }
    }

    /**
     * Phương thức tìm sinh viên có tuổi lớn nhất
     *
     * @param students danh sách sinh viên
     * @return tuổi lớn nhất
     */
    private static int findStudentAgeLargest(Student[] students) {
        int maxAge = students[0].getAge();
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > maxAge) {
                maxAge = students[i].getAge();
            }
        }
        return maxAge;
    }

    /**
     * Hiển thị danh sách sinh viên
     *
     * @param students danh sách sinh viên
     * @param n        số lượng sinh viên
     */
    private static void showStudentsInfor(Student[] students, int n) {
        System.out.printf("%-20s%-20s%-20s\n", "Mã ID", "Họ Tên", "Tuổi");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s%-20s%-20d\n", students[i].getId(),
                    students[i].getFullName(), students[i].getAge());

        }
    }

    /**
     * phương thức nhập sinh viên
     *
     * @param students danh sách sinh viên
     * @param n        số lượng sinh viên
     * @param input    đầu vào lớp Scanner
     */
    private static void getStudentInfor(Student[] students, int n, Scanner input) {
        for (int i = 0; i < n; i++) {
            System.out.println("===> Mời nhập thông tin sinh viên thứ " + (i + 1) + " <===");
            System.out.println("Nhập mã sinh viên : ");
            input.nextLine();
            String id = input.nextLine();
            System.out.println("Nhập họ tên sinh viên : ");
            String name = input.nextLine();
            System.out.println("Nhập tuổi sinh viên : ");
            int age = input.nextInt();
            students[i] = new Student(id, name, age);
            System.out.println("===> Đã thêm thành công sinh viên thứ :" + (i + 1) + " <===");
        }

    }
}
