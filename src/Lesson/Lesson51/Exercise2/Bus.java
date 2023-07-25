package Lesson.Lesson51.Exercise2;

public class Bus extends Automobile {
    private int numOfseat;  //số ghế ngồi
    private float maxPayload;   //trọng tải tối đa
    private String orbit;   //tầm hoạt động
    private float fuelCapacity; //dung tích nhiên liệu
    private int numOfCustomer;  //số khách hàng đã vận chuyển

    protected Bus() {
        numOfCustomer = 0;
        numOfseat = 0;
        maxPayload = 0f;
        orbit = "";
        fuelCapacity = 0f;
    }

    public Bus(int numOfseat, float maxPayload, String orbit, float fuelCapacity, int numOfCustomer) {
        this.numOfseat = numOfseat;
        this.maxPayload = maxPayload;
        this.orbit = orbit;
        this.fuelCapacity = fuelCapacity;
        this.numOfCustomer = numOfCustomer;
    }

    public Bus(int numOfWheels, String engineType, String name, String color, String owner, int numOfseat,
               float maxPayload, String orbit, float fuelCapacity, int numOfCustomer) {
        super(numOfWheels, engineType, name, color, owner);
        this.numOfseat = numOfseat;
        this.maxPayload = maxPayload;
        this.orbit = orbit;
        this.fuelCapacity = fuelCapacity;
        this.numOfCustomer = numOfCustomer;
    }

    public Bus(String brand, int year, String madeIn, float price, String size, float weight, String lisensePlate,
               int numOfWheels, String engineType, String name, String color, String owner, int numOfseat,
               float maxPayload, String orbit, float fuelCapacity, int numOfCustomer) {
        super(brand, year, madeIn, price, size, weight, lisensePlate, numOfWheels, engineType, name, color, owner);
        this.numOfseat = numOfseat;
        this.maxPayload = maxPayload;
        this.orbit = orbit;
        this.fuelCapacity = fuelCapacity;
        this.numOfCustomer = numOfCustomer;
    }

    public final int getNumOfseat() {
        return numOfseat;
    }

    public final void setNumOfseat(int numOfseat) {
        this.numOfseat = numOfseat;
    }

    public final float getMaxPayload() {
        return maxPayload;
    }

    public final void setMaxPayload(float maxPayload) {
        this.maxPayload = maxPayload;
    }

    public final String getOrbit() {
        return orbit;
    }

    public final void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public final float getFuelCapacity() {
        return fuelCapacity;
    }

    public final void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public final int getNumOfCustomer() {
        return numOfCustomer;
    }

    public final void setNumOfCustomer(int numOfCustomer) {
        this.numOfCustomer = numOfCustomer;
    }
    ///override

    @Override
    protected void startEngine() {
        super.startEngine();
        System.out.println("Xe khách khỏi động bằng động cơ...");
    }

    @Override
    protected void endEngine() {
        super.endEngine();
        System.out.println("Xe khách tắt đông cơ  bắt tay ...");
    }

    @Override
    protected void speedUp() {
        super.speedUp();
        System.out.println("Xe khách tăng tốc tăng tốc bằng cách đạp chân ga...");
    }

    @Override
    protected void brake() {
        super.brake();
        System.out.println("Xe khách phanh bằng chân...");
    }

    @Override
    protected void turnLight() {
        super.turnLight();
        System.out.println("Xe khách bật đèn bằng công tắc ...");
    }
}
