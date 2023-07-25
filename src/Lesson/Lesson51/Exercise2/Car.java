package Lesson.Lesson51.Exercise2;

public class Car extends Automobile {
    private int numOfDoor;  //số cửa
    private int numOfSeat;  //số ghế
    private String category;    //loại xe ,thể loại
    private String driverForm;//
    private String typeOfEnergy;    //loại năng lượng sử dụng

    protected Car() {
        numOfDoor = 0;
        numOfSeat = 0;
        category = "";
        driverForm = "";
        typeOfEnergy = "";
    }

    public Car(int numOfDoor, int numOfSeat, String category, String driverForm, String typeOfEnergy) {
        this.numOfDoor = numOfDoor;
        this.numOfSeat = numOfSeat;
        this.category = category;
        this.driverForm = driverForm;
        this.typeOfEnergy = typeOfEnergy;
    }

    public Car(int numOfWheels, String engineType, String name, String color, String owner, int numOfDoor,
               int numOfSeat, String category, String driverForm, String typeOfEnergy) {
        super(numOfWheels, engineType, name, color, owner);
        this.numOfDoor = numOfDoor;
        this.numOfSeat = numOfSeat;
        this.category = category;
        this.driverForm = driverForm;
        this.typeOfEnergy = typeOfEnergy;
    }

    public Car(String brand, int year, String madeIn, float price, String size, float weight, String lisensePlate,
               int numOfWheels, String engineType, String name, String color, String owner, int numOfDoor,
               int numOfSeat, String category, String driverForm, String typeOfEnergy) {
        super(brand, year, madeIn, price, size, weight, lisensePlate, numOfWheels, engineType, name, color, owner);
        this.numOfDoor = numOfDoor;
        this.numOfSeat = numOfSeat;
        this.category = category;
        this.driverForm = driverForm;
        this.typeOfEnergy = typeOfEnergy;
    }

    public final int getNumOfDoor() {
        return numOfDoor;
    }

    public final void setNumOfDoor(int numOfDoor) {
        this.numOfDoor = numOfDoor;
    }

    public final int getNumOfSeat() {
        return numOfSeat;
    }

    public final void setNumOfSeat(int numOfSeat) {
        this.numOfSeat = numOfSeat;
    }

    public final String getCategory() {
        return category;
    }

    public final void setCategory(String category) {
        this.category = category;
    }

    public final String getDriverForm() {
        return driverForm;
    }

    public final void setDriverForm(String driverForm) {
        this.driverForm = driverForm;
    }

    public final String getTypeOfEnergy() {
        return typeOfEnergy;
    }

    public final void setTypeOfEnergy(String typeOfEnergy) {
        this.typeOfEnergy = typeOfEnergy;
    }
    //override

    @Override
    protected void startEngine() {
        super.startEngine();
        System.out.println("Xe con khởi động bằng tay ...");
    }

    @Override
    protected void endEngine() {
        super.endEngine();
        System.out.println("Xe con tắt máy bằng tay ...");
    }

    @Override
    protected void speedUp() {
        super.speedUp();
        System.out.println("Xe con tăng tốc bằng cách tăng ga...");
    }

    @Override
    protected void brake() {
        super.brake();
        System.out.println("Xe con phanh xe bằng phanh...");
    }

    @Override
    protected void turnLight() {
        super.turnLight();
        System.out.println("xe con bật đèn bằng tay ....");
    }
}
