package Lesson.Lesson55.Exercise5.Sort;

import Lesson.Lesson55.Exercise5.Employee;

import java.util.Comparator;

public class SortByEmpTotalSalary implements Comparator<Employee> {
    @Override
    public int compare(Employee other1, Employee other2) {
        var salaryGpa = Float.compare(other2.getTotalSalary(), other1.getTotalSalary());
        if (salaryGpa != 0) {
            return salaryGpa;
        } else {
            var nameSort = other1.getFirstName().compareTo(other2.getFirstName());
            if (nameSort != 0) {
                return nameSort;
            } else {
                return other1.getLastName().compareTo(other2.getLastName());

            }
        }
    }
}
