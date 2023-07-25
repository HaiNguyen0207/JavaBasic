package Lesson.Lesson54;

public class FatherExample {
    public static void main(String[] args) {
        Father son = new Father() {
            @Override
            public void speak() {
                super.speak();
                System.out.println("Son is speaking Vietnamese");
            }
        };
        son.speak();

    }
}
