package Lesson.Lesson53.Exercise3;

public abstract class Smartphone implements Funtionality {
    private int serialNumber;   //số seri
    private String brand;   //hãng
    private String name;   //tên máy
    private float weight;//trọng lượng
    private float batteryCapacity; //dung lượng pin
    private float screenSize;  //kích thước màn hinh

    protected Smartphone() {
        screenSize = 0;
        brand = "";
        name = "";
        weight = 0f;
        batteryCapacity = 0f;
    }

    public Smartphone(String name) {
        this.name = name;
    }

    public Smartphone(int serialNumber, String brand, String name, float weight, float batteryCapacity,
                      float screenSize) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.name = name;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.screenSize = screenSize;
    }

    public final int getSerialNumber() {
        return serialNumber;
    }

    public final void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
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

    public final float getWeight() {
        return weight;
    }

    public final void setWeight(float weight) {
        this.weight = weight;
    }

    public final float getBatteryCapacity() {
        return batteryCapacity;
    }

    public final void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public final float getScreenSize() {
        return screenSize;
    }

    public final void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }
    //override

    @Override
    public void turnOff(boolean activated) {
        var message = activated ? " kích hoạt " : "hủy bỏ";
        System.out.println("Smartphone đã" + message + " chức năng tắt máy ");
    }

    @Override
    public void turnOn(boolean activated) {
        var message = activated ? " kích hoạt " : "hủy bỏ";
        System.out.println("Smartphone đã" + message + " chức năng mở máy ");
    }

    @Override
    public void restart(boolean activated) {
        var message = activated ? " kích hoạt " : "hủy bỏ";
        System.out.println("Smartphone đã" + message + " chức năng khởi động lại máy ");
    }

    @Override
    public void offScreen(boolean activated) {
        var message = activated ? " kích hoạt " : "hủy bỏ";
        System.out.println("Smartphone đã" + message + " chức năng tắt màn hình ");
    }

    @Override
    public void changeVolume(int amount) {
        System.out.println("Smartphone đã thay đổi âm lương : " + amount);
    }

    @Override
    public void changeBrightness(int amount) {
        System.out.println("Smartphone đã thay đổi độ sáng màn hình lên : " + amount);
    }

    //mật khẩu cho smartphone
    public void unlock(String method) {
        System.out.println("Smartphone mở khóa bằng mật khẩu và " + method);
    }
}
