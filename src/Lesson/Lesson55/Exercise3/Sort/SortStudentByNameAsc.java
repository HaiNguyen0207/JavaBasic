package Lesson.Lesson55.Exercise3.Sort;

import Lesson.Lesson55.Exercise3.Student;

import java.util.Comparator;

public class SortStudentByNameAsc implements Comparator<Student> {
    @Override
    public int compare(Student other1, Student other2) {
        return other1.getFirstName().compareTo(other2.getFirstName());
    }
}
