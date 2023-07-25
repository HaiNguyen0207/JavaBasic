package Lesson.Lesson55.Exercise3.Sort;

import Lesson.Lesson55.Exercise3.Instructor;

import java.util.Comparator;

public class SortInsBySalaryDec implements Comparator<Instructor> {
    @Override
    public int compare(Instructor other1, Instructor other2) {
        if ((other1.getSalary() - other2.getSalary()) > 0) {
            return -1;
        }
        if ((other1.getSalary() - other2.getSalary()) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
