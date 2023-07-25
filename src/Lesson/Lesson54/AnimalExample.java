package Lesson.Lesson54;

public class AnimalExample {
    public static void main(String[] args) {

        Animal cat = new Animal("Tom") {
            @Override
            protected void move() {
                System.out.println("Mèo" + getName() + " đang di chuyển ...");
            }

            @Override
            protected void eat() {
                System.out.println("Mèo" + getName() + " đang ăn...");
            }
        };
        cat.move();
        cat.eat();
    }
}
