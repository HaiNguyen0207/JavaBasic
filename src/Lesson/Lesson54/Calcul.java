package Lesson.Lesson54;

public class Calcul implements CalculAction { //tính toán
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }
}
