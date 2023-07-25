package Lesson.Lesson51.Exercise2;

public class Automobile extends Vehicle {
    private int numOfWheels;   //số bánh xe
    private String engineType; //loại động cơ
    private String name;    //tên xe
    private String color;   //màu xe
    private String owner;   //chủ sở hữ

    protected Automobile() {
        numOfWheels = 0;
        engineType = "";
        name = "";
        color = "";
        owner = "";
    }

    public Automobile(int numOfWheels, String engineType, String name, String color, String owner) {
        this.numOfWheels = numOfWheels;
        this.engineType = engineType;
        this.name = name;
        this.color = color;
        this.owner = owner;
    }

    public Automobile(String brand, int year, String madeIn, float price, String size, float weight, String lisensePlate,
                      int numOfWheels, String engineType, String name, String color, String owner) {
        super(brand, year, madeIn, price, size, weight, lisensePlate);
        this.numOfWheels = numOfWheels;
        this.engineType = engineType;
        this.name = name;
        this.color = color;
        this.owner = owner;
    }

    public final int getNumOfWheels() {
        return numOfWheels;
    }

    public final void setNumOfWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    public final String getEngineType() {
        return engineType;
    }

    public final void setEngineType(String engineType) {
        this.engineType = engineType;
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
        System.out.println("Ô tô khởi động bằng công tắc...");
    }

    @Override
    protected void endEngine() {
        System.out.println("Ô tô tắt máy bằng công tắc....");
    }

    @Override
    protected void speedUp() {
        System.out.println("Ô  tô tăng tốc bằng đạp chân ga...");
    }

    @Override
    protected void brake() {
        System.out.println("Ô tô phanh bằng phanh chân ...");
    }

    @Override
    protected void turnLight() {
        System.out.println("Ô tô bật đèn bắt công tắc ...");
    }
}
