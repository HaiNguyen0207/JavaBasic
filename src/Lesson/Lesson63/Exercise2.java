package Lesson.Lesson63;


public class Exercise2 {

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 6, 5, 5, 9, 2, 8};
        Double[] interestRate = {0.25, 1.5, 6.35, 4.75, 5.5,0.25,0.4};
        Student[] students = new Student[3];
        students[0] = new Student("S1", "Tran Van Hung", 3.25f);
        students[1] = new Student("S2", "Nguyen Tran Duy", 2.59f);
        students[2] = new Student("S3", "Hoang Xuan Quynh", 3.54f);
        System.out.println("==== > Kiểm tra mảng Integer <==== ");
        checkInteger(numbers);
        System.out.println("==== > Kiểm tra mảng Double <==== ");
        checkDouble(interestRate);
        System.out.println("==== > Kiểm tra mảng Student <==== ");
        checkStudent(students);


    }

    private static void checkStudent(Student[] students) {
        Student s = new Student("S2", "Nguyen Tran Duy", 2.59f);
        var value = findX(students, s);
        if (value != -1) {
            System.out.println("X xuất hiện tại vị trí cuối cùng: " + value);
        } else {
            System.out.println("x không tồn tại trong mảng ");
        }
    }

    /**
     * phương thức kiểm tra xem 1 số thực có tồn tại trong mảng hay không
     *
     * @param number mảng chứa các giá trị cần tìm
     */
    private static void checkDouble(Double[] number) {
        Double x = 0.25;
        var indexOfXDouble = findX(number, x);
        if (indexOfXDouble != -1) {
            System.out.println("Tìm thấy 0.25 tại vị trí cuối cùng : " + indexOfXDouble);
        } else {
            System.out.println("Giá trị " + x + " không tồn tại trong mảng ");
        }
    }

    /**
     * phương thức kiểm tra 1 số nguyên có tồn tại trong mảng không
     *
     * @param number mảng chứa các giá trị cần kêm tra
     */
    private static void checkInteger(Integer[] number) {
        Integer x = 2;
        var indexOfXInteger = findX(number, x);
        if (indexOfXInteger != -1) {
            System.out.println("Tìm thấy 2 tại vị trí cuối cùng  : " + indexOfXInteger);
        } else {
            System.out.println("Giá trị " + x + " không tồn tại trong mảng ");
        }

    }

    /**
     * phương thức  chỉ dùng cho câc kiểu có thực thi interface Comparable
     *
     * @param list danh sách chứa các phần tử cần timg
     * @param x    giá trị x cần tìm
     * @param <T>  kiểu các phần tử thao tác
     * @return vị trị phần tử đầu tiên trong mảng nếu tìm thấy
     * return -1 nếu không tìm thấy
     */
    private static <T extends Comparable> int findX(T[] list, T x) {
        for (int i = list.length-1; i >= 0; i--) {
            if (list[i].compareTo(x) == 0) {
                return i;
            }
        }
        return -1;

    }

}
