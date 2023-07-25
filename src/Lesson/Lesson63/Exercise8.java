package Lesson.Lesson63;

import java.util.ArrayList;

public class Exercise8 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(1);

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Mai");
        friends.add("Anh");
        friends.add("Hoa");
        friends.add("Nhung");
        friends.add("Huong");
        friends.add("Hoa");

        var s1 = new Student("S1", "Tran Van Hung", 3.25f);
        var s2 = new Student("S2", "Nguyen Tran Duy", 2.59f);
        var s3 = new Student("S3", "Hoang Xuan Quynh", 3.54f);
        var s4 = new Student("S7", "Nguyen Hoai Nam", 2.95f);
        var s5 = new Student("S4", "Huynh Lan Huong", 3.66f);
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        // tiến hành thay thế các phần tử x bởi phần tử y:
        System.out.println("Sau khi thay thế số 1 bởi 99: ");
        replaceXY(numbers, 2, 99);
        showArrayElement(numbers);
        System.out.println("Sau khi thay thế các Hoa bởi Linh: ");
        replaceXY(friends, "Hoa", "Linh");
        showArrayElement(friends);
        System.out.println("Sau khi thay thế các SV mã S1 bởi SV mã S4: ");
        replaceXY(students, s1, s5); // thay s1 bởi s5
        showArrayElement(students);
    }

    /**
     * Phương thức dùng để hiển thị danh sách các phần tử
     *
     * @param elements danh sách cần hiển thị
     * @param <T>      kiểu của danh sách`
     */
    public static <T> void showArrayElement(ArrayList<T> elements) {
        for (var element : elements) {
            System.out.println(element);
        }
    }

    /**
     * Phương thức dùng để thay thế các phần tử x trong danh sách
     * bởi phần tử y
     *
     * @param elements danh sách các phần tử cần thay đổi
     * @param x        giá trị cần thay thế
     * @param y        giá trị thay thế mới
     * @param <T>      kiểu của các phần tử cần thao tác
     */
    public static <T extends Comparable> void replaceXY(ArrayList<T> elements, T x, T y) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).equals(x)) {
                elements.set(i, y);
            }
        }
    }
}
