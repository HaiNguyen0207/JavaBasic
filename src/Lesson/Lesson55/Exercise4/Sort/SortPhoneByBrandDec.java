package Lesson.Lesson55.Exercise4.Sort;

import Lesson.Lesson55.Exercise4.Phone;

import java.util.Comparator;

public class SortPhoneByBrandDec implements Comparator<Phone> {
    @Override
    public int compare(Phone other1, Phone other2) {
        return other2.getBrand().compareTo(other1.getBrand());
    }
}
