package Lesson.Lesson55.Exercise3.Sort;

import Lesson.Lesson55.Exercise3.Instructor;


import java.util.Comparator;

public class SortInsByNameDec implements Comparator<Instructor> {


    @Override
    public int compare(Instructor other1, Instructor other2) {
        return other2.getFirstName().compareTo(other1.getFirstName());
    }
}
