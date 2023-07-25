package Lesson.Lesson55.Exercise2;

public class Bus extends Automobile {
    private int numOfSeat;  //số ghế ngồi
    private float maxTonnage;   //trọng tải tối đa
    private float orbit;   //tầm hoạt động
    private float fuelTankCapacity; //dung tích bình xăng
    private int shippedCustomer;   //khách hàng đã vận chuyển

    protected Bus() {
        numOfSeat = 0;
        maxTonnage = 0f;
        orbit = 0f;
        fuelTankCapacity = 0f;
        shippedCustomer = 0;
    }

    public Bus(int numOfSeat, float maxTonnage, float orbit, float fuelTankCapacity,
               int shippedCustomer) {
        this.numOfSeat = numOfSeat;
        this.maxTonnage = maxTonnage;
        this.orbit = orbit;
        this.fuelTankCapacity = fuelTankCapacity;
        this.shippedCustomer = shippedCustomer;
    }

    public Bus(int numOfWheel, String typeEngine, String name, String color, String owner,
               int numOfSeat, float maxTonnage, float orbit, float fuelTankCapacity,
               int shippedCustomer) {
        super(numOfWheel, typeEngine, name, color, owner);
        this.numOfSeat = numOfSeat;
        this.maxTonnage = maxTonnage;
        this.orbit = orbit;
        this.fuelTankCapacity = fuelTankCapacity;
        this.shippedCustomer = shippedCustomer;
    }

    public Bus(String brand, int year, float price, float weight, int numOfSeat, float maxTonnage,
               float orbit, float fuelTankCapacity, int shippedCustomer) {
        super(brand, year, price, weight);
        this.numOfSeat = numOfSeat;
        this.maxTonnage = maxTonnage;
        this.orbit = orbit;
        this.fuelTankCapacity = fuelTankCapacity;
        this.shippedCustomer = shippedCustomer;
    }

    public Bus(String brand, int year, float price, float weight) {
        super(brand, year, price, weight);
    }

    public Bus(String brand, int year, String madeIn, float price, String size,
               float weight, String lisensePlate, int numOfWheel, String typeEngine,
               String name, String color, String owner, int numOfSeat, float maxTonnage,
               float orbit, float fuelTankCapacity, int shippedCustomer) {
        super(brand, year, madeIn, price, size, weight, lisensePlate, numOfWheel,
                typeEngine, name, color, owner);
        this.numOfSeat = numOfSeat;
        this.maxTonnage = maxTonnage;
        this.orbit = orbit;
        this.fuelTankCapacity = fuelTankCapacity;
        this.shippedCustomer = shippedCustomer;
    }

    public final int getNumOfSeat() {
        return numOfSeat;
    }

    public final void setNumOfSeat(int numOfSeat) {
        this.numOfSeat = numOfSeat;
    }

    public final float getMaxTonnage() {
        return maxTonnage;
    }

    public final void setMaxTonnage(float maxTonnage) {
        this.maxTonnage = maxTonnage;
    }

    public final float getOrbit() {
        return orbit;
    }

    public final void setOrbit(float orbit) {
        this.orbit = orbit;
    }

    public final float getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public final void setFuelTankCapacity(float fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public final int getShippedCustomer() {
        return shippedCustomer;
    }

    public final void setShippedCustomer(int shippedCustomer) {
        this.shippedCustomer = shippedCustomer;
    }
    //override

    @Override
    protected void startEngine() {
        System.out.println("Xe khách mở máy bằng tay....");
    }

    @Override
    protected void endEngine() {
        System.out.println("Xe khách tắt máy bằng tay....");
    }

    @Override
    protected void speedUp() {
        System.out.println("Xe khách tăng tốc bằng đạp chân ga....");
    }
}
