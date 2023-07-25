package Lesson.Lesson51.Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        Animal mamal = new Mammal();
        Animal bird = new Bird();
        Animal fish = new Fish();
        mamal.eat();
        System.out.println("=======");
        bird.eat();
        System.out.println("=======");
        fish.eat();
        System.out.println("=======");

    }
}
