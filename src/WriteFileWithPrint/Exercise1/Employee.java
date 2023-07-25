package WriteFileWithPrint.Exercise1;

public class Employee {
    private static int nextId = 1001;
    private String id; //mã nhân viên
    private String fullName;    // họ tên
    private String address;    // địa chỉ
    private int age;    //tuổi
    private String phoneNumber;    // số điện thoại
    private float salaray;  //mức lương
    private int exp;    // kinh nghiệm

    public Employee() {
    }

    public Employee(String fullName, String address, int age,
                    String phoneNumber, float salaray, int exp) {
        this.setId();
        this.fullName = fullName;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salaray = salaray;
        this.exp = exp;
    }

    public Employee(String id, String fullName, String address, int age,
                    String phoneNumber, float salaray, int exp) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salaray = salaray;
        this.exp = exp;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        if (id == null) {
            this.id = "EMP" + nextId;
            nextId++;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getSalaray() {
        return salaray;
    }

    public void setSalaray(float salaray) {
        this.salaray = salaray;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }
}
