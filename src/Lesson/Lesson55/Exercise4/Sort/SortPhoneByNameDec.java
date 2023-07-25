package Lesson.Lesson55.Exercise4.Sort;

import Lesson.Lesson55.Exercise4.Phone;

import java.util.Comparator;

public class SortPhoneByNameDec implements Comparator<Phone> {
    @Override
    public int compare(Phone other1, Phone other2) {
        return other2.getName().compareTo(other1.getName());
    }
}
