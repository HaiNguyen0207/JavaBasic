package Lesson.Lesson55.Exercise5.Sort;

import Lesson.Lesson55.Exercise5.Employee;

import java.util.Comparator;

public class SortEmpByNameDec implements Comparator<Employee> {
    @Override
    public int compare(Employee other1, Employee other2) {
        return other2.getFirstName().compareTo(other1.getFirstName());
    }


}
