package Lesson.Lesson55.Exercise2.Sort;

import Lesson.Lesson55.Exercise2.Vehicle;

import java.util.Comparator;

public class SortByPriceDec implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle other1, Vehicle other2) {
        if ((other1.getPrice() - other2.getPrice()) > 0) {
            return -1;
        }
        if ((other1.getPrice() - other2.getPrice()) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
