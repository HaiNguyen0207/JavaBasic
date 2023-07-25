package Lesson.Lesson51.Exercise2;

public abstract class Vehicle { // phương tiện giao thông
    private String brand;   //hãng sản xuất
    private int year;   //năm sản xuất
    private String madeIn;  //nơi sản xuất
    private float price;   //giá thành
    private String size;    //kích thước
    private float weight;   //trọng lượng ,cân nặng
    private String lisensePlate;   //biển số xe

    protected Vehicle() {
        brand = "";
        year = 0;
        madeIn = "";
        price = 0f;
        size = "";
        weight = 0f;
        lisensePlate = "";
    }

    public Vehicle(String brand, int year, String madeIn, float price, String size, float weight, String lisensePlate) {
        this.brand = brand;
        this.year = year;
        this.madeIn = madeIn;
        this.price = price;
        this.size = size;
        this.weight = weight;
        this.lisensePlate = lisensePlate;
    }

    public final String getBrand() {
        return brand;
    }

    public final void setBrand(String brand) {
        this.brand = brand;
    }

    public final int getYear() {
        return year;
    }

    public final void setYear(int year) {
        this.year = year;
    }

    public final String getMadeIn() {
        return madeIn;
    }

    public final void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public final float getPrice() {
        return price;
    }

    public final void setPrice(float price) {
        this.price = price;
    }

    public final String getSize() {
        return size;
    }

    public final void setSize(String size) {
        this.size = size;
    }

    public final float getWeight() {
        return weight;
    }

    public final void setWeight(float weight) {
        this.weight = weight;
    }

    public final String getLisensePlate() {
        return lisensePlate;
    }

    public final void setLisensePlate(String lisensePlate) {
        this.lisensePlate = lisensePlate;
    }

    //abstract
    protected abstract void startEngine(); //nổ máy

    protected abstract void endEngine();//tắt máy

    protected abstract void speedUp(); //tăng tốc

    protected abstract void brake();  //phanh

    protected abstract void turnLight();   //bật đèn
}
