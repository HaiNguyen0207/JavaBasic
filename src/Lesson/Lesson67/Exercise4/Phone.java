package Lesson.Lesson67.Exercise4;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone implements Comparable<Phone> {
    private String idDevice;  //mã thiết bị
    private String brand;   //tên hãng
    private String nameDevice;  //tên thiết bị
    private float price;    //giá bán
    private int startYear; //năm sản xuất
    private float sizeScreen;   //kích thước màn hình

    protected Phone() {
        idDevice = "";
        brand = "";
        nameDevice = "";
        price = 0f;
        startYear = 0;
        sizeScreen = 0f;
    }

    public Phone(String idDevice, String brand, String nameDevice,
                 float price, int startYear, float sizeScreen)
            throws InValidbBrandNameException {
        this.idDevice = idDevice;
        setBrand(brand);
        this.nameDevice = nameDevice;
        this.price = price;
        this.startYear = startYear;
        this.sizeScreen = sizeScreen;
    }

    public String getBrand() {
        return brand;
    }

    public String getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(String idDevice) {
        this.idDevice = idDevice;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public float getSizeScreen() {
        return sizeScreen;
    }

    public void setSizeScreen(float sizeScreen) {
        this.sizeScreen = sizeScreen;
    }

    public void setBrand(String brand) throws InValidbBrandNameException {
        if (isVaild(brand)) {
            this.brand = brand.toUpperCase(Locale.ROOT);
        } else {
            var msg = "Tên hãng không hợp lệ : " + brand;
            throw new InValidbBrandNameException(msg, brand);
        }

    }

    //phương thức so sánh xem tên hãng có hợp lệ không
    public boolean isVaild(String brand) {
        var regex = "^apple|samsung|huawei|xiaomi|oppo|vsmart$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(brand);
        return matcher.matches();
    }

    //phương thức sắp xếp theo mã id tăng
    @Override
    public int compareTo(Phone other) {
        return idDevice.compareTo(other.idDevice);
    }
}
