package Lesson.Lesson53.Exercise1;

public interface AinmalAction {
    void eat();   //ăn

    void sleep();   //ngủ

    void move();    //di chuyển

    void reproduction();// sinh sản

    default void speak(String other) {//động vật nói chuyện
        System.out.println("Động vật đang nói chuyện với " + other);
    }

    default void bask() {
        System.out.println("Động vật đang tắm nắng ...");
    }
}
