package Lesson.Lesson55.Exercise1;

public class Cat extends Mammal {
    private int age;//tuổi
    private String hobby;   //sở thích
    private String eyeColor;    //màu mắt
    private String petName; //tên gọi

    protected Cat() {
        age = 0;
        hobby = "";
        eyeColor = "";
        petName = "";
    }

    public Cat(int age, String hobby, String eyeColor, String petName) {
        this.age = age;
        this.hobby = hobby;
        this.eyeColor = eyeColor;
        this.petName = petName;
    }

    public Cat(int numOfFoot, String color, int numOfTeeth, String behevior,
               int age, String hobby, String eyeColor, String petName) {
        super(numOfFoot, color, numOfTeeth, behevior);
        this.age = age;
        this.hobby = hobby;
        this.eyeColor = eyeColor;
        this.petName = petName;
    }

    public Cat(String name, String species, float height, float weight,
               String habitat, String reproductionForm, int numOfFoot,
               String color, int numOfTeeth, String behevior, int age,
               String hobby, String eyeColor, String petName) {
        super(name, species, height, weight, habitat, reproductionForm,
                numOfFoot, color, numOfTeeth, behevior);
        this.age = age;
        this.hobby = hobby;
        this.eyeColor = eyeColor;
        this.petName = petName;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    public final String getHobby() {
        return hobby;
    }

    public final void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public final String getEyeColor() {
        return eyeColor;
    }

    public final void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public final String getPetName() {
        return petName;
    }

    public final void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    protected void eat() {
        System.out.println("Mèo" + petName + " đang ăn cá bla bla...");
    }

    @Override
    protected void sleep() {
        System.out.println("Mèo" + petName + " đang ngủ trưa bla bla...");
    }

    @Override
    protected void entertainment() {
        System.out.println("Mèo" + petName + " đang nghe nhạc bla bla...");
    }

    @Override
    protected void move() {
        System.out.println("Mèo" + petName + " đang chạy bắt chuộ bla bla...");
    }
}
