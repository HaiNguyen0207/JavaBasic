package Lesson.Lesson67.Exercise4.Sort;



import Lesson.Lesson67.Exercise4.Phone;

import java.util.Comparator;

public class SortPhoneByNameAsc implements Comparator<Phone> {

    @Override
    public int compare(Phone other1, Phone other2) {
        return other1.getNameDevice().compareTo(other2.getNameDevice());
    }
}
