package Lesson.Lesson51.Exercise4;

public abstract class Shape {
    private String name;    //tên hình học
    private int x; //tọa độ x
    private int y;  //tọa độ y

    protected Shape() {
        name = "";
        x = 0;
        y = 0;
    }

    public Shape(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //abstract
    protected abstract void draw();

    protected abstract void resize();   //thay đổi kích thước
}
