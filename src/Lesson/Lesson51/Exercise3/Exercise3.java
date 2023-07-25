package Lesson.Lesson51.Exercise3;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exercise3 {
    public static void main(String[] args) throws ParseException {
        var format = "dd/MM/yyyy"; // date format
        var dateFormat = new SimpleDateFormat(format);
        Person person = new Person("001202033751", "Nguyễn văn hải", "Hà Nội",
                dateFormat.parse("02/07/2002"), "hai@xmail.com", "0983638524") {
            @Override
            protected void doWork() {

            }
        };
        Instructor myInstructor = new Instructor("09167875426", "Nguyễn Thị B",
                "Hà Nội", dateFormat.parse("27/10/2005"),
                "b@xmail.com", "0123456789",
                "BKMA001", "Java", 990000, 5.5f);

        Student myStudent = new Student("09167875428", "Nguyễn  Văn C",
                "Cầu Giấy, Hà Nội", dateFormat.parse("17/11/2006"),
                "c@xmail.com", "0123456789",
                "STU100005", "KMA", "D25CN5", "CNTT", 8.75f);

        GraduatedStudent graduatedStudent = new GraduatedStudent("09167875428", "Nguyễn Văn A",
                "Cầu Giấy, Hà Nội", dateFormat.parse("17/11/2006"),
                "a@xmail.com", "0123456789",
                "STU100005", "PTIT", "D25CN5",
                "CNTT", 8.75f, 2022, 18, 4,
                1500000.25f, "Google Inc", "IT Engineer");
//hiển thị thông tin
        System.out.println("=====> Thông tin về người <=====");
        showPerson(person, dateFormat);
        person.eat();
        person.sleep();
        person.talk();
        person.relax();
        person.doWork();


        System.out.println("====> Thông tin về giảng viên <====");
        showsIntructor(dateFormat,myInstructor);
        myInstructor.doWork();
        myInstructor.eat();
        myInstructor.talk();
        myInstructor.relax();
        myInstructor.sleep();
    }

    private static void showsIntructor(SimpleDateFormat dateFormat, Instructor myInstructor) {
        System.out.println("Số CCCD/CMND :"+myInstructor.getId());
        System.out.println("Họ Tên : "+myInstructor.getFullName());
        System.out.println("Địa chỉ : "+myInstructor.getAddress());
        System.out.println("Ngày sinh : "+dateFormat.format(myInstructor.getBirthDay()));
        System.out.println("Email : "+myInstructor.getEmail());
        System.out.println("Số điện thoại : "+myInstructor.getNumber());
        System.out.println("Mã giảng viên : "+myInstructor.getInstructorId());
        System.out.println("Chuyên môn : "+myInstructor.getExpertise());
        System.out.println("Mức lương : "+myInstructor.getSalary());
        System.out.println("Kinh nghiệm : "+myInstructor.getExperience());
    }

    /**
     * phương thức hiển thị thông tin người
     *
     * @param person     người
     * @param dateFormat định dạng ngày sinh 02/07/2002
     */
    private static void showPerson(Person person, SimpleDateFormat dateFormat) {
        System.out.println("Số CCCD/CMND : " + person.getId());
        System.out.println("Họ Tên : " + person.getFullName());
        System.out.println("Địa chỉ : " + person.getAddress());
        System.out.println("Ngày sinh : " + dateFormat.format(person.getBirthDay()));
        System.out.println("Email : " + person.getEmail());
        System.out.println("Số điện thoại : " + person.getNumber());
    }
}
