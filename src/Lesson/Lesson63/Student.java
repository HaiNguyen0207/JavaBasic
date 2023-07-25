package Lesson.Lesson63;

public class Student implements Comparable<Student> {
    private String id;
    private String fullName;
    private float avgGrade;

    public Student() {
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public Student(String id, String fullName, float avgGrade) {
        this.id = id;
        this.fullName = fullName;
        this.avgGrade = avgGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(float avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int compareTo(Student other) {
        return id.compareToIgnoreCase(other.id);
    }
}
