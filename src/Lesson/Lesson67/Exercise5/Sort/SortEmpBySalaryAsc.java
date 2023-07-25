package Lesson.Lesson67.Exercise5.Sort;


import Lesson.Lesson67.Exercise5.Employee;

import java.util.Comparator;

public class SortEmpBySalaryAsc implements Comparator<Employee> {
    @Override
    public int compare(Employee other1, Employee other2) {
        if (other1.getSalary() > other2.getSalary()) {
            return 1;
        }
        if (other1.getSalary() == other2.getSalary()) {
            return 0;
        } else {
            return -1;
        }
    }
}
