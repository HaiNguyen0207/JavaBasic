package Lesson.Lesson53.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        Dog bob = new Dog("Bob");
        bob.setColor("Yellow");
        System.out.println("Tên của chó là: " + bob.getNamePet());
        bob.move();
        bob.bark();
        bob.eat();
        bob.wagTail();
        bob.sleep();
    }
}
