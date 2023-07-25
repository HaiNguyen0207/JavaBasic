package Lesson.Lesson55.Exercise1;

public class Fish extends Animal {
    private String color;   //màu lông
    private String food;    //thức ăn

    protected Fish() {
        color = "";
        food = "";
    }

    public Fish(String color, String food) {
        this.color = color;
        this.food = food;
    }
    public Fish(String name, String species, float height, float weight) {
        super(name, species, height, weight);
    }

    public final String getColor() {
        return color;
    }

    public final void setColor(String color) {
        this.color = color;
    }

    public final String getFood() {
        return food;
    }

    public final void setFood(String food) {
        this.food = food;
    }

    @Override
    protected void eat() {
        System.out.println("Cá đang ăn rêu...");
    }

    @Override
    protected void sleep() {
        System.out.println("Cá đang ngủ trưa...");
    }

    @Override
    protected void entertainment() {
        System.out.println("Cá đang giải trí ...");
    }

    @Override
    protected void move() {
        System.out.println("Cá đang bơi tung tăng dưới nước...");
    }
}
