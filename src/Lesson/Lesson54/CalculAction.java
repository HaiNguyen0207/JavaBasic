package Lesson.Lesson54;

public interface CalculAction { //chức năng tính toán
    int add(int a, int b); //cộng 2 số

    int sub(int a, int b); //trừ hai số

    default int mul(int a, int b) {
        return a * b;
    }

    default int div(int a, int b) {
        return  (a / b);
    }

}
