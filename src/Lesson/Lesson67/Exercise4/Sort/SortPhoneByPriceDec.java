package Lesson.Lesson67.Exercise4.Sort;


import Lesson.Lesson67.Exercise4.Phone;

import java.util.Comparator;

public class SortPhoneByPriceDec implements Comparator<Phone> {
    @Override
    public int compare(Phone other1, Phone other2) {
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
