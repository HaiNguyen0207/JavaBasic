package Lesson.Lesson55.Exercise1;

public class Bird extends Animal{
    private String color;   //màu lông
    private String foodMain;    //thức ăn chính
    private String wingSpan;    //sải cánh
    protected  Bird() {
        color="";
        foodMain="";
        wingSpan="";
    }
    public Bird(String name, String species, float height, float weight){
        super(name,species,height,weight);
    }
    public Bird(String color, String foodMain, String wingSpan) {
        this.color = color;
        this.foodMain = foodMain;
        this.wingSpan = wingSpan;
    }

    public Bird(String name, String species, float height, float weight,
                String habitat, String reproductionForm, String color,
                String foodMain, String wingSpan) {
        super(name, species, height, weight, habitat, reproductionForm);
        this.color = color;
        this.foodMain = foodMain;
        this.wingSpan = wingSpan;
    }

    public final String getColor() {
        return color;
    }

    public final void setColor(String color) {
        this.color = color;
    }

    public final String getFoodMain() {
        return foodMain;
    }

    public final void setFoodMain(String foodMain) {
        this.foodMain = foodMain;
    }

    public final String getWingSpan() {
        return wingSpan;
    }

    public final void setWingSpan(String wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    protected void eat() {
        System.out.println("Chim đang ăn sâu...");
    }

    @Override
    protected void sleep() {
        System.out.println("Chim đang ngủ trưa...");
    }

    @Override
    protected void entertainment() {
        System.out.println("Chim đang giải trí bla bla...");
    }

    @Override
    protected void move() {
        System.out.println("Chim đang bay trên bầu trời...");
    }
}
