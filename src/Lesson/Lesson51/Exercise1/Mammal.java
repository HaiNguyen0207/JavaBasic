package Lesson.Lesson51.Exercise1;

public class Mammal extends Animal {
    private int numOfFeet; //số chân
    private String color;   //màu lông
    private int numOfTeeth; //số răng
    private String behavior;    //tập tính

    protected Mammal() {
        numOfFeet = 0;
        color = "";
        numOfTeeth = 0;
        behavior = "";
    }

    public Mammal(int numOfFeet, String color, int numOfTeeth, String behavior) {
        this.numOfFeet = numOfFeet;
        this.color = color;
        this.numOfTeeth = numOfTeeth;
        this.behavior = behavior;
    }

    public Mammal(String name, String type, float height, float weight, String habitat, String reproductionForm,
                  int numOfFeet, String color, int numOfTeeth, String behavior) {
        super(name, type, height, weight, habitat, reproductionForm);
        this.numOfFeet = numOfFeet;
        this.color = color;
        this.numOfTeeth = numOfTeeth;
        this.behavior = behavior;
    }

    public final int getNumOfFeet() {
        return numOfFeet;
    }

    public final void setNumOfFeet(int numOfFeet) {
        this.numOfFeet = numOfFeet;
    }

    public final String getColor() {
        return color;
    }

    public final void setColor(String color) {
        this.color = color;
    }

    public final int getNumOfTeeth() {
        return numOfTeeth;
    }

    public final void setNumOfTeeth(int numOfTeeth) {
        this.numOfTeeth = numOfTeeth;
    }

    public final String getBehavior() {
        return behavior;
    }

    public final void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    @Override
    protected void eat() {
        System.out.println("Hổ đang ăn thịt ...");
    }

    @Override
    protected void sleep() {
        System.out.println("Hổ đang nằm ngủ ...");
    }

    @Override
    protected void relax() {
        System.out.println("Hổ đang thư giãn ...");
    }

    @Override
    protected void entertainment() {
        System.out.println("Hổ đang  giải trí ..");
    }

    @Override
    protected void move() {
        System.out.println("Hổ đang săn mồi ....");
    }
}
