package Lesson.Lesson67.Exercise5.Sort;

import Lesson.Lesson67.Exercise5.Employee;

import java.util.Comparator;

public class SortEmpBySalaryDec implements Comparator<Employee> {
    @Override
    public int compare(Employee other1, Employee other2) {
        if (other1.calculToTalSalary() > other2.calculToTalSalary()) {
            return -1;
        }
        if (other1.calculToTalSalary() == other2.calculToTalSalary()) {
            return 0;
        } else {
            return 1;
        }
    }
}
