package Lesson.Lesson55.Exercise1.Sort;

import Lesson.Lesson55.Exercise1.Animal;

import java.util.Comparator;

public class SortByWeightDec implements Comparator<Animal> {


    @Override
    public int compare(Animal other1, Animal other2) {
        if (other1.getWeight() < other2.getWeight()) {
            return 1;
        }
        if (other1.getWeight() == other2.getWeight()) {
            return 0;
        }
        return -1;
    }
}
