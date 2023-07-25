package Lesson.Lesson53.Exercise1;

public class Dog extends Animal {
    private String namePet;    //tên
    private String color;   //màu lông
    private String species; //loài nào ;giống

    protected Dog() {
        namePet = "";
        color = "";
        species = "";
    }

    public Dog(String namePet) {
        this.namePet = namePet;
    }

    public Dog(String namePet, String color, String species) {
        this.namePet = namePet;
        this.color = color;
        this.species = species;
    }

    public Dog(String name, int age, String foodMain, float weight, String namePet, String color, String species) {
        super(name, age, foodMain, weight);
        this.namePet = namePet;
        this.color = color;
        this.species = species;
    }

    public final String getNamePet() {
        return namePet;
    }

    public final void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public final String getColor() {
        return color;
    }

    public final void setColor(String color) {
        this.color = color;
    }

    public final String getSpecies() {
        return species;
    }

    public final void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public void eat() {
        System.out.println("Chó " + namePet + " đang ăn ...");
    }

    @Override
    public void sleep() {
        System.out.println("Chó " + namePet + " đang ngủ ...");
    }


    @Override
    public void move() {
        System.out.println("Chó " + namePet + " đang di chuyển ...");
    }

    public void bark() {//sủa
        System.out.println("Chó " + namePet + " đang sủa ...");
    }

    public void wagTail() {//vẫy đuôi
        System.out.println("Chó " + namePet + " đang vẫy đuôi ...");
    }
}



