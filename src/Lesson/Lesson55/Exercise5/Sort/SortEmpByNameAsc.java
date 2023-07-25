package Lesson.Lesson55.Exercise5.Sort;

import Lesson.Lesson55.Exercise5.Employee;

import java.util.Comparator;

public class SortEmpByNameAsc implements Comparator<Employee> {
    @Override
    public int compare(Employee other1, Employee other2) {
        return other1.getFirstName().compareTo(other2.getFirstName());
    }
}
