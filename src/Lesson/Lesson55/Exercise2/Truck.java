package Lesson.Lesson55.Exercise2;

public class Truck extends Automobile {
    private float tonnage;  //trọng tải
    private String purpose; //mục đích
    private String shippedAmount;   //số lượng háng hóa vận chuyển

    protected Truck() {
        tonnage = 0f;
        purpose = "";
        shippedAmount = "";
    }

    public Truck(float tonnage, String purpose, String shippedAmount) {
        this.tonnage = tonnage;
        this.purpose = purpose;
        this.shippedAmount = shippedAmount;
    }

    public Truck(int numOfWheel, String typeEngine, String name, String color,
                 String owner, float tonnage, String purpose, String shippedAmount) {
        super(numOfWheel, typeEngine, name, color, owner);
        this.tonnage = tonnage;
        this.purpose = purpose;
        this.shippedAmount = shippedAmount;
    }

    public Truck(String brand, int year, float price, float weight, float tonnage,
                 String purpose, String shippedAmount) {
        super(brand, year, price, weight);
        this.tonnage = tonnage;
        this.purpose = purpose;
        this.shippedAmount = shippedAmount;
    }

    public Truck(String brand, int year, String madeIn, float price, String size,
                 float weight, String lisensePlate, int numOfWheel, String typeEngine,
                 String name, String color, String owner, float tonnage, String purpose,
                 String shippedAmount) {
        super(brand, year, madeIn, price, size, weight, lisensePlate, numOfWheel,
                typeEngine, name, color, owner);
        this.tonnage = tonnage;
        this.purpose = purpose;
        this.shippedAmount = shippedAmount;
    }

    public Truck(String brand, int year, float price, float weight) {
        super(brand, year, price, weight);
    }

    public final float getTonnage() {
        return tonnage;
    }

    public final void setTonnage(float tonnage) {
        this.tonnage = tonnage;
    }

    public final String getPurpose() {
        return purpose;
    }

    public final void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public final String getShippedAmount() {
        return shippedAmount;
    }

    public final void setShippedAmount(String shippedAmount) {
        this.shippedAmount = shippedAmount;
    }
    //override

    @Override
    protected void startEngine() {
        System.out.println("Xe tải khởi động máy bằng tay...");
    }

    @Override
    protected void endEngine() {
        System.out.println("Xe tải tắt máy bằng tay...");
    }

    @Override
    protected void speedUp() {
        System.out.println("Xe tải tăng tốc bằng cách tăng ga...");
    }

    @Override
    protected void brake() {
        System.out.println("Xe tải phanh xe bằng chân...");
    }

    @Override
    protected void turnLight() {
        System.out.println("Xe tải bật đèn bằng tay...");
    }
}