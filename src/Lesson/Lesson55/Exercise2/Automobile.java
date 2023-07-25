package Lesson.Lesson55.Exercise2;

public class Automobile extends Vehicle {
    private int numOfWheel;  //số bánh xe
    private String typeEngine;  //loại động cơ
    private String name;    //tên xe
    private String color;   //màu xe
    private String owner;    //chủ sở hữu

    protected Automobile() {
        numOfWheel=0;
        typeEngine="";
        name="";
        color="";
        owner="";
    }

    public Automobile(int numOfWheel, String typeEngine, String name,
                      String color, String owner) {
        this.numOfWheel = numOfWheel;
        this.typeEngine = typeEngine;
        this.name = name;
        this.color = color;
        this.owner = owner;
    }
    public Automobile(String brand, int year, float price, float weight) {
        super(brand, year, price, weight);
    }

    public Automobile(String brand, int year, String madeIn, float price,
                      String size, float weight, String lisensePlate, int numOfWheel,
                      String typeEngine, String name, String color, String owner) {
        super(brand, year, madeIn, price, size, weight, lisensePlate);
        this.numOfWheel = numOfWheel;
        this.typeEngine = typeEngine;
        this.name = name;
        this.color = color;
        this.owner = owner;
    }

    public final int getNumOfWheel() {
        return numOfWheel;
    }

    public final void setNumOfWheel(int numOfWheel) {
        this.numOfWheel = numOfWheel;
    }

    public final String getTypeEngine() {
        return typeEngine;
    }

    public final void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getColor() {
        return color;
    }

    public final void setColor(String color) {
        this.color = color;
    }

    public final String getOwner() {
        return owner;
    }

    public final void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    protected void startEngine() {
        System.out.println("Xe ô tô bật máy bằng điều khiển ...");
    }

    @Override
    protected void endEngine() {
        System.out.println("Xe ô tô tắt máy bằng điều khiển ...");
    }

    @Override
    protected void speedUp() {
        System.out.println("Xe ô tô bật tăng tốc bằng đạp chân ga ...");
    }

    @Override
    protected void brake() {
        System.out.println("Xe ô tô phanh xe bẵng chân...");
    }

    @Override
    protected void turnLight() {
        System.out.println("Xe ô tô bật đèn bằng điều khiển ...");
    }

}
