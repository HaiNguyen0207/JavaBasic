package Lesson.Lesson55.Exercise4.Sort;

import Lesson.Lesson55.Exercise4.Phone;

import java.util.Comparator;

public class SortPhoneByStartYearAsc implements Comparator<Phone> {

    @Override
    public int compare(Phone other1, Phone other2) {
        if ((other1.getStartYear() - other2.getStartYear()) > 0) {
            return 1;
        }
        if ((other1.getStartYear() - other2.getStartYear()) == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
