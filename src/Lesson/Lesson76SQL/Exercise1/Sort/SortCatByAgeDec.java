package Lesson.Lesson76SQL.Exercise1.Sort;

import Lesson.Lesson76SQL.Exercise1.Cat;

import java.util.Comparator;

public class SortCatByAgeDec implements Comparator<Cat> {
    @Override
    public int compare(Cat other1, Cat other2) {
        if ((other1.getAge()>other2.getAge())) {
            return -1;
        }
        if ((other1.getAge()==other2.getAge())) {
            return 0;
        }
        return 11;
    }
}
