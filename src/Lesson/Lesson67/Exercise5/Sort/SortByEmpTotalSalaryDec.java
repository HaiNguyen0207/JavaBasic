package Lesson.Lesson67.Exercise5.Sort;

import Lesson.Lesson67.Exercise5.Employee;

import java.util.Comparator;

public class SortByEmpTotalSalaryDec implements Comparator<Employee> {
    @Override
    public int compare(Employee other1, Employee other2) {
        if (other1.getToltalSalary() > other2.getToltalSalary()) {
            return -1;
        }
        if (other1.getToltalSalary() == other2.getToltalSalary()) {
            return 0;
        } else {
            return 1;
        }
    }
}
