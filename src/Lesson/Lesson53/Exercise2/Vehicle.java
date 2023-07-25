package Lesson.Lesson53.Exercise2;

public abstract class Vehicle implements VehicleAction {
    private int year;  //năm sản xuất
    private String name;    //tên xe
    private float price;    //giá bán ,giá thành
    private String type;    //loại xe
    private float weight;   //trọng lượng

    protected Vehicle() {
        year = 0;
        name = "";
        price = 0f;
        type = "";
        weight = 0f;
    }

    public Vehicle(String name) {
        this.name = name;
    }

    public Vehicle(int year, String name, float price, String type, float weight) {
        this.year = year;
        this.name = name;
        this.price = price;
        this.type = type;
        this.weight = weight;
    }

    public final int getYear() {
        return year;
    }

    public final void setYear(int year) {
        this.year = year;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final float getPrice() {
        return price;
    }

    public final void setPrice(float price) {
        this.price = price;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String type) {
        this.type = type;
    }

    public final float getWeight() {
        return weight;
    }

    public final void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public void startEngine() {
        System.out.println("Xe" + name + " khởi động bằng điều khiển...");
    }

    @Override
    public void endEngine() {
        System.out.println("Xe" + name + " tắt máy bằng điều khiển...");
    }

    @Override
    public void speedUp() {
        System.out.println("Xe" + name + " tăng tốc bằng chân ga...");
    }

    @Override
    public void brake() {
        System.out.println("Xe" + name + " khởi động bằng tay...");
    }

    @Override
    public void turnLight() {
        System.out.println("Xe" + name + " bật đèn bằng điều khiển...");
    }
}
