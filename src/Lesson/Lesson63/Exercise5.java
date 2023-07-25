package Lesson.Lesson63;

import java.util.ArrayList;

public class Exercise5 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(7);
        numbers.add(6);
        numbers.add(12);
        numbers.add(9);
        numbers.add(3);
        ArrayList<Double> interestRate = new ArrayList<>();
        interestRate.add(0.53);
        interestRate.add(0.89);
        interestRate.add(2.43);
        interestRate.add(2.11);
        interestRate.add(7.88);
        interestRate.add(9.21);
        interestRate.add(1.11);
        ArrayList<Student> students = new ArrayList<>();
        crateNewStudent(students);
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Mai");
        friends.add("Anh");
        friends.add("Hoa");
        friends.add("Nhung");
        friends.add("Huong");
        System.out.println("====== Check Array Integer <===");
        System.out.println(" Trước : ");
        show(numbers);
        System.out.println("Sau : ");
        sortAsc(numbers);
        show(numbers);
        System.out.println("====== Check Array Double <===");
        System.out.println(" Trước : ");
        show(interestRate);
        System.out.println("Sau : ");
        sortAsc(interestRate);
        show(interestRate);
        System.out.println("====== Check Array Frends <===");
        System.out.println(" Trước : ");
        show(friends);
        System.out.println("Sau : ");
        sortAsc(friends);
        show(friends);
        System.out.println("====== Check Array Student <===");
        System.out.println(" Trước : ");
        show(students);
        System.out.println("Sau : ");
        sortAsc(students);
        show(students);

    }

    /**
     * phương thức thêm vài sinh viên
     *
     * @param students danh sách sinh viên
     */
    private static void crateNewStudent(ArrayList<Student> students) {
        var s1 = new Student("a", "Tran Van Hung", 3.25f);
        var s2 = new Student("c", "Nguyen Tran Duy", 2.59f);
        var s3 = new Student("b", "Hoang Xuan Quynh", 3.54f);
        var s4 = new Student("e", "Nguyen Hoai Nam", 2.95f);
        var s5 = new Student("d", "Huynh Lan Huong", 3.66f);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
    }

    /**
     * phương thức hiển thị kết quả trước và sau sắp xếp
     *
     * @param element mảng chứa các phần tử
     * @param <T>     kiểu thực thi
     */
    private static <T> void show(ArrayList<T> element) {
        for (var item : element) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * phương thức chỉ dành cho các kiểu có thực thi interface Comparable
     * sắp xếp các phần tử trong mảng theo giá trị tăng dần
     *
     * @param elements mảng chứa các phần tử cần sắp xếp
     * @param <T>      kiểu thực thi
     */
    private static <T extends Comparable> void sortAsc(ArrayList<T> elements) {
        for (int i = 0; i < elements.size() - 1; i++) {
            for (int j = elements.size() - 1; j > i; j--) {
                if (elements.get(j).compareTo(elements.get(j - 1)) < 0) {
                    var x = elements.get(j);
                    elements.set(j, elements.get(j - 1));
                    elements.set(j - 1, x);
                }
            }
        }
    }


}
