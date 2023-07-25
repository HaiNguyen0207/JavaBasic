package Lesson.Lesson51.Exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        triangle.draw();
        triangle.resize();
        System.out.println("=======================");
        Shape circle = new Circle();
        circle.draw();
        circle.resize();
    }
}

