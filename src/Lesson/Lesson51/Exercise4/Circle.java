package Lesson.Lesson51.Exercise4;

public class Circle extends Shape{
    private float radius; // bán kính
    private int centerX;
    private int centerY;
    protected Circle() {
        radius=0f;
        centerX=0;
        centerY=0;
    }

    public Circle(float radius, int centerX, int centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public Circle(String name, int x, int y, float radius, int centerX, int centerY) {
        super(name, x, y);
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    @Override
    protected void draw() {
        System.out.println("Vẽ hình tròn ....");
    }

    @Override
    protected void resize() {
        System.out.println("Thay đổi bán kính hình tròn...");
    }
}

