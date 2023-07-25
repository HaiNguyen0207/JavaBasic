package Lesson.Lesson55.Exercise2.Sort;

import Lesson.Lesson55.Exercise2.Vehicle;

import java.util.Comparator;


public class SortByWeightAsc implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle oher1, Vehicle other2) {
        if ((oher1.getWeight() - other2.getWeight()) > 0) {
            return 1;
        }
        if ((oher1.getWeight() - other2.getWeight()) == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
