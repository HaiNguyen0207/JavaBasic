package Lesson.Lesson55.Exercise3.Sort;

import Lesson.Lesson55.Exercise3.Instructor;

import java.util.Comparator;

public class SortInsByExpDec implements Comparator<Instructor> {
    @Override
    public int compare(Instructor other1, Instructor other2) {
        if ((other1.getExperience() - other2.getExperience()) > 0) {
            return -1;
        }
        if ((other1.getExperience() - other2.getExperience()) == 00) {
            return 0;
        } else {
            return 1;
        }

    }
}
