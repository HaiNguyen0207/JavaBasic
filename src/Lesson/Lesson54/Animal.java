package Lesson.Lesson54;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    protected abstract void move(); // di chuyển

    protected abstract void eat(); // ăn

    public String getName() {
        return name;
    }
}
