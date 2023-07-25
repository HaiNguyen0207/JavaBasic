package Lesson.Lesson54;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    protected void move() {
        System.out.println("Mèo" + getName() + " đang di chuyển trên trần nhà");
    }

    @Override
    protected void eat() {
        System.out.println("Mèo" + getName() + " đang ăn sáng ..");
    }
}
