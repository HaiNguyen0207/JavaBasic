package Lesson.Lesson55.Exercise1;

public abstract class Animal {
    private String name;    //tên
    private String species; //loài
    private float height;   //chiều cao
    private float weight;  //cân nặng
    private String habitat; //môi trường sống
    private String reproductionForm;    //hình thức sinh sản

    protected Animal() {
        name = "";
        species = "";
        height = 0f;
        weight = 0f;
        habitat = "";
        reproductionForm = "";
    }

    public Animal(String name, String species, float height, float weight) {
        this.name = name;
        this.species = species;
        this.height = height;
        this.weight = weight;
    }

    public Animal(String name, String species, float height, float weight, String habitat, String reproductionForm) {
        this.name = name;
        this.species = species;
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

    public final String getSpecies() {
        return species;
    }

    public final void setSpecies(String species) {
        this.species = species;
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
    protected abstract void eat();  //ăn

    protected abstract void sleep(); //ngủ

    protected abstract void entertainment();  //giải trí

    protected abstract void move();    //di chuyển
}
