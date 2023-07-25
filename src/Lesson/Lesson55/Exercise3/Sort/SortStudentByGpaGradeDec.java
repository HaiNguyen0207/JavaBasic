package Lesson.Lesson55.Exercise3.Sort;

import Lesson.Lesson55.Exercise3.Student;

import java.util.Comparator;

public class SortStudentByGpaGradeDec implements Comparator<Student> {
    @Override
    public int compare(Student other1, Student other2) {
        if ((other1.getAvgGarde() - other2.getAvgGarde()) > 0) {
            return -1;
        }
        if ((other1.getAvgGarde() - other2.getAvgGarde()) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
