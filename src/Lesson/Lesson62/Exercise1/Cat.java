package Lesson.Lesson62.Exercise1;

public class Cat {
    private  String color;  //màu lông
    private int age;    //tuổi
    private  String food;   //món ăn
    private String eyeColor;    //màu mắt
    private String petName; //tên gọi

    protected Cat() {
        color="";
        age=0;
        food="";
        eyeColor="";
        petName="";
    }

    public Cat(String color, int age, String food, String eyeColor, String petName)
            throws InValidAgeCatException {
        this.color = color;
        setAge(age);
        this.food = food;
        this.eyeColor = eyeColor;
        this.petName = petName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InValidAgeCatException {
        if(age > 0 && age <= 50) {
            this.age= age;
        }else {
            this.age=0; //mặc định tuổi con mèo =0;
            var msg= " Bạn đã nhập tuổi không hợp lệ ";
            throw  new InValidAgeCatException(msg,age);
        }
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
