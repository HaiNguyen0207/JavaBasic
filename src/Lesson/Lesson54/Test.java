package Lesson.Lesson54;

public class Test {
    public static void main(String[] args) {
        Calcul calcul = new Calcul();
        System.out.printf("%d + %d = %d \n", 10, 20, calcul.add(10, 20));
        System.out.printf("%d - %d = %d \n", 10, 20, calcul.sub(10, 20));
        System.out.printf("%d * %d = %d \n", 10, 20, calcul.mul(10, 20));
        System.out.printf("%d / %d = %d \n", 40, 20, calcul.div(40, 20));

        System.out.println("Lớp vô danh ");
        CalculAction calculAction=new CalculAction() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }

            @Override
            public int sub(int a, int b) {
                return a - b;
            }
        };
        System.out.printf("%d + %d = %d \n", 10, 20, calculAction.add(10, 20));
        System.out.printf("%d - %d = %d \n", 10, 20, calculAction.sub(10, 20));
    }
}
