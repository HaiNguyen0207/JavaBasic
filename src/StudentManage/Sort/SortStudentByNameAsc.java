package StudentManage.Sort;

import StudentManage.Student;

import java.util.Comparator;

public class SortStudentByNameAsc implements Comparator<Student> {
    @Override
    public int compare(Student other1, Student other2) {
        return other1.getFirstName().compareTo(other2.getFirstName());
    }
}
