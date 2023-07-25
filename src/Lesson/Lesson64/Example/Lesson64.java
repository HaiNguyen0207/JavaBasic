package Lesson.Lesson64.Example;


import java.util.ArrayList;

public class Lesson64 {
    public static void main(String[] args) {
        // danh sách các số kiểu int
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        // danh sách các số kiểu double
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(1.25);
        doubles.add(5.98);
        doubles.add(78.15);
        // danh sách các String object
        ArrayList<String> names = new ArrayList<>();
        names.add("Hoa");
        names.add("Hương");
        names.add("Phương");
        names.add("Linh");

        // lấy giá trị trung bình của mỗi danh sách:
        System.out.println("Giá trị trung bình mảng số nguyên : "
                + avgValue(integers));
        System.out.println("Giá trị trung bình mảng số thực : "
                + avgValue(doubles));

    }

    public static double avgValue(ArrayList<? extends Number> element) {
        if (element == null || element.size() <= 0) {
            return 0;
        }
        double value = 0;
        for (var item : element) {
            value += item.doubleValue();
        }
        return value / element.size();
    }
}
