package Lesson.Lesson63;

public class Exercise4 {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 6, 5, 5, 9, 2, 2, 2, 8};
        Double[] interestRate = {0.25, 1.5, 6.35, 1.5, 4.75, 1.5, 1.5, 5.5, 0.25, 0.4};
        Student[] students = new Student[5];
        students[0] = new Student("S1", "Tran Van Hung", 3.25f);
        students[1] = new Student("S2", "Nguyen Tran Duy", 2.59f);
        students[2] = new Student("S3", "Hoang Xuan Quynh", 3.54f);
        students[3] = new Student("S2", "Nguyen Tran Duy", 2.59f);
        students[4] = new Student("S2", "Nguyen Tran Duy", 2.59f);


        System.out.println("Số lần xuất hiện của x = 2: " + countX(numbers, 2));
        System.out.println("=========================");
        System.out.println("Số lần xuất hiện của x = 5.5: "
                + countX(interestRate, 5.5));
        System.out.println("=========================");
        System.out.println("Số lần xuất hiện của sinh viên có mã \""
                + students[1].getId() + "\": " + countX(students,students[1] ));
    }

    /**
     * phương thức này dùng cho các kiểu có thục thi interface Comparable
     * dùng để đếm giá số lần giá trị x xuất hiện nào đó
     *
     * @param list danh sách chưa các giá trị cần tìm
     * @param x    giá trị cần tìm
     * @param <T>  kiểu thực thi
     * @return số lần x xuất hiện
     */
    private static <T extends Comparable> int countX(T[] list, T x) {
        var index = 0;
        for (var item : list) {
            if (item.compareTo(x) == 0) {
                index++;
            }
        }
        return index;
    }


}

