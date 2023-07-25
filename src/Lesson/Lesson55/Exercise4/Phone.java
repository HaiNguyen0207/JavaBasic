package Lesson.Lesson55.Exercise4;

public class Phone implements Comparable<Phone> {
    private String id;  //mã thiết bị
    private String brand;   //hãng
    private String name;    //tên thiết bị
    private float price;    //giá bán
    private int startYear;  //năm sản xuất
    private float sizeScreen;  // kích thước màn hình

    protected Phone() {
        id = "";
        brand = "";
        name = "";
        price = 0f;
        startYear = 0;
        sizeScreen = 0f;
    }

    public Phone(String id, String brand, String name, float price, int startYear, float sizeScreen) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.startYear = startYear;
        this.sizeScreen = sizeScreen;
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    public final String getBrand() {
        return brand;
    }

    public final void setBrand(String brand) {
        this.brand = brand;
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

    public final int getStartYear() {
        return startYear;
    }

    public final void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public final float getSizeScreen() {
        return sizeScreen;
    }

    public final void setSizeScreen(float sizeScreen) {
        this.sizeScreen = sizeScreen;
    }

    @Override
    public int compareTo(Phone other) {
        return id.compareTo(other.id);
    }
}
