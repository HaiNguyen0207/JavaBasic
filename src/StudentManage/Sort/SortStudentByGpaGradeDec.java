package StudentManage.Sort;

import StudentManage.Student;

import java.util.Comparator;

public class SortStudentByGpaGradeDec implements Comparator<Student> {
    @Override
    public int compare(Student other1, Student other2) {
        if ((other1.getTranscript().getAvgMark() - other2.getTranscript().getAvgMark()) > 0) {
            return -1;
        }
        if ((other1.getTranscript().getAvgMark() - other2.getTranscript().getAvgMark()) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
