package Lesson.Lesson55.Exercise1.Sort;

import Lesson.Lesson55.Exercise1.Animal;

import java.util.Comparator;

public class SortByHeight implements Comparator<Animal> {
    @Override
    public int compare(Animal other1, Animal other2) {
        if (other2.getHeight() < other1.getHeight()) {
            return -1;
        }
        if (other2.getHeight() == other2.getHeight()) {
            return 0;
        }
        return 1;
    }
}
