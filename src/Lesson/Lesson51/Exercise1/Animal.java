package Lesson.Lesson51.Exercise1;

public abstract class Animal {
    private String name;    //tên
    private String type;    //loài
    private float height;   //chiều coa
    private float weight;  //cân nặng
    private String habitat; //môi trường sống
    private String reproductionForm;    //hình thức sinh sản

    protected Animal() {
        name = "";
        type = "";
        height = 0f;
        weight = 0f;
        habitat = "";
        reproductionForm = "";
    }

    public Animal(String name, String type, float height, float weight, String habitat, String reproductionForm) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.habitat = habitat;
        this.reproductionForm = reproductionForm;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String type) {
        this.type = type;
    }

    public final float getHeight() {
        return height;
    }

    public final void setHeight(float height) {
        this.height = height;
    }

    public final float getWeight() {
        return weight;
    }

    public final void setWeight(float weight) {
        this.weight = weight;
    }

    public final String getHabitat() {
        return habitat;
    }

    public final void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public final String getReproductionForm() {
        return reproductionForm;
    }

    public final void setReproductionForm(String reproductionForm) {
        this.reproductionForm = reproductionForm;
    }

    //abstract
    protected abstract void eat(); //ăn

    protected abstract void sleep(); //ngủ

    protected abstract void relax();  //thư giãn

    protected abstract void entertainment();    //thư giãn

    protected abstract void move(); //di chuyển
}
