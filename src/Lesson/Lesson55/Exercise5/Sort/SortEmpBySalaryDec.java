package Lesson.Lesson55.Exercise5.Sort;

import Lesson.Lesson55.Exercise5.Employee;

import java.util.Comparator;

public class SortEmpBySalaryDec implements Comparator<Employee> {
    @Override
    public int compare(Employee other1, Employee other2) {
        if ((other1.getSalary() - other2.getSalary()) > 0) {
            return -1;
        }
        if ((other1.getSalary()) - other2.getSalary() > 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
