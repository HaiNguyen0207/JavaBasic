package Lesson.Lesson75SQL.Example;

public class Student {
    private String id;  //id
    private String name;    //fullname
    private String address;     //address
    private String email;   //email
    private String major;   //major
    private float avgGrade;         // avg Grade

    protected Student() {
        id = "";
        name = "";
        address = "";
        email = "";
        major = "";
        avgGrade = 0f;
    }

    public Student(String id, String name, String address, String email,
                   String major, float avgGrade) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.major = major;
        this.avgGrade = avgGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(float avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
