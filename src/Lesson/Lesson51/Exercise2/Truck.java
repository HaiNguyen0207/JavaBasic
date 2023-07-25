package Lesson.Lesson51.Exercise2;

public class Truck extends Automobile {
    private float payload;  //trong tải
    private String purpose; //mục đích sử dụng
    private float shippedAmount; // số lượng hàng háo đã vận chuyển

    protected Truck() {
        payload = 0f;
        purpose = "";
        shippedAmount = 0f;

    }

    public Truck(float payload, String purpose, float shippedAmount) {
        this.payload = payload;
        this.purpose = purpose;
        this.shippedAmount = shippedAmount;
    }

    public Truck(int numOfWheels, String engineType, String name, String color, String owner, float payload,
                 String purpose, float shippedAmount) {
        super(numOfWheels, engineType, name, color, owner);
        this.payload = payload;
        this.purpose = purpose;
        this.shippedAmount = shippedAmount;
    }

    public Truck(String brand, int year, String madeIn, float price, String size, float weight, String lisensePlate,
                 int numOfWheels, String engineType, String name, String color, String owner, float payload,
                 String purpose, float shippedAmount) {
        super(brand, year, madeIn, price, size, weight, lisensePlate, numOfWheels, engineType, name, color, owner);
        this.payload = payload;
        this.purpose = purpose;
        this.shippedAmount = shippedAmount;
    }
    //overridel

    @Override
    protected void startEngine() {
        super.startEngine();
        System.out.println("Xe tải khởi động xe bằng tay...");
    }

    @Override
    protected void endEngine() {
        super.endEngine();
        System.out.println("Xe tải tắt động cơ bằng tay ...");
    }

    @Override
    protected void speedUp() {
        super.speedUp();
        System.out.println("Xe tải tăng tốc bằng chân ga ...");
    }

    @Override
    protected void brake() {
        System.out.println("Xe tải phanh bằng dây côn...");
        super.brake();
    }

    @Override
    protected void turnLight() {
        System.out.println("Xe tải bật đèn bằng tay ....");
        super.turnLight();
    }
}
