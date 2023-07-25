package Lesson.Lesson51.Exercise4;

public class Triangle extends Shape{
    private  int a;
    private  int b;
    private  int c;
    protected Triangle() {
        a=0;
        b=0;
        c=0;
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(String name, int x, int y, int a, int b, int c) {
        super(name, x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    protected void draw() {
        System.out.println("Vẽ hình tam giác bla bla ...");
    }

    @Override
    protected void resize() {
        System.out.println("Thay đổi kích thước 3 cạnh tam giác bla bla ...");
    }
}
