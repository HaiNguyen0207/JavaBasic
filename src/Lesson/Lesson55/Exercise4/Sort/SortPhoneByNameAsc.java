package Lesson.Lesson55.Exercise4.Sort;

import Lesson.Lesson55.Exercise4.Phone;

import java.util.Comparator;

public class SortPhoneByNameAsc implements Comparator<Phone> {
    @Override

        public int compare(Phone other1, Phone other2) {
            return other1.getBrand().compareTo(other2.getBrand());
        }

}
