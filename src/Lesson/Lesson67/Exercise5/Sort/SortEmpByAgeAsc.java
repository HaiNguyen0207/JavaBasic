package Lesson.Lesson67.Exercise5.Sort;

import Lesson.Lesson67.Exercise5.Employee;

import java.util.Comparator;

public class SortEmpByAgeAsc implements Comparator<Employee> {
    @Override
    public int compare(Employee other1,Employee other2) {
        if ((other1. yearOfBirth()- other2.yearOfBirth()) > 0) {
            return 1;
        }
        if ((other1.yearOfBirth() - other2.yearOfBirth()) == 0) {
            return 0;
        }
        return -1;
    }
}
