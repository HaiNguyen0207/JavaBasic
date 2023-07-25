package Lesson.Lesson53.Exercise1;

public abstract class Animal implements AinmalAction {
    private String name;    //tên
    private int age;  //tuổi
    private String foodMain;    //thức ăn chính
    private float weight;   //trọng lượng

    protected Animal() {
        name = "";
        age = 0;
        foodMain = "";
        weight = 0f;
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int age, String foodMain, float weight) {
        this.name = name;
        this.age = age;
        this.foodMain = foodMain;
        this.weight = weight;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    public final String getFoodMain() {
        return foodMain;
    }

    public final void setFoodMain(String foodMain) {
        this.foodMain = foodMain;
    }

    public final float getWeight() {
        return weight;
    }

    public final void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public void eat() {
        System.out.println("Động vật đang ăn ...");
    }

    @Override
    public void sleep() {
        System.out.println("Đông vật đang ngủ...");
    }

    @Override
    public void move() {
        System.out.println("Động vật đang di chuyển...");
    }

    @Override
    public void reproduction() {
        System.out.println("Đông vật đang sinh con...");
    }

    @Override
    public void speak(String other) {
        AinmalAction.super.speak(other);
    }

    @Override
    public void bask() {
        AinmalAction.super.bask();
    }
}
