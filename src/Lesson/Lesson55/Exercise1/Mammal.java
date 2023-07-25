package Lesson.Lesson55.Exercise1;

public class  Mammal extends Animal {
    private int numOfFoot;  //số chân
    private String color;   //màu lông
    private int numOfTeeth; //số trắng
    private  String behevior;   //tập tính
    protected Mammal() {
        numOfFoot=0;
        color="";
        numOfFoot=0;
        behevior="";
    }
    public Mammal(String name, String species, float height, float weight){
        super(name,species,height,weight);
    }
    public Mammal(int numOfFoot, String color, int numOfTeeth, String behevior) {
        this.numOfFoot = numOfFoot;
        this.color = color;
        this.numOfTeeth = numOfTeeth;
        this.behevior = behevior;
    }

    public Mammal(String name, String species, float height, float weight, String habitat,
                  String reproductionForm, int numOfFoot, String color, int numOfTeeth,
                  String behevior) {
        super(name, species, height, weight, habitat, reproductionForm);
        this.numOfFoot = numOfFoot;
        this.color = color;
        this.numOfTeeth = numOfTeeth;
        this.behevior = behevior;
    }

    public final int getNumOfFoot() {
        return numOfFoot;
    }

    public final void setNumOfFoot(int numOfFoot) {
        this.numOfFoot = numOfFoot;
    }

    public final String getColor() {
        return color;
    }

    public final void setColor(String color) {
        this.color = color;
    }

    public final int getNumOfTeeth() {
        return numOfTeeth;
    }

    public final void setNumOfTeeth(int numOfTeeth) {
        this.numOfTeeth = numOfTeeth;
    }

    public final String getBehevior() {
        return behevior;
    }

    public final void setBehevior(String behevior) {
        this.behevior = behevior;
    }

    @Override
    protected void eat() {
        System.out.println("Động vật có vú đang ăn ....");
    }

    @Override
    protected void sleep() {
        System.out.println("Động vật có vú đang ngủ ....");
    }

    @Override
    protected void entertainment() {
        System.out.println("Động vật có vú giải trí ....");
    }

    @Override
    protected void move() {
        System.out.println("Động vật có vú đang di chuyển ....");
    }
}
