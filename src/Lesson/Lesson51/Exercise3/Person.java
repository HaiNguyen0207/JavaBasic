package Lesson.Lesson51.Exercise3;

import java.util.Date;

public abstract class Person {
    private String id; //sô cmt /số cccd
    private FullName fullName;  //họ tên
    private String address;    //địa chỉ
    private Date birthDay;  //ngày sinh
    private String email;   //email
    private String number;  //số điện thoại

    protected Person() {
        id = "";
        fullName = new FullName();
        address = "";
        birthDay = new Date();
        email = "";
        number = "";
    }

    public Person(String id, String fullName, String address, Date birthDay, String email, String number) {
        this.fullName = new FullName();
        this.id = id;
        this.setFullName(fullName);
        this.address = address;
        this.birthDay = birthDay;
        this.email = email;
        this.number = number;
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    public final String getFullName() {
        return fullName.last + " " + fullName.mid + fullName.first;
    }

    public final void setFullName(String fullName) {
        var words = fullName.split(" ");
        this.fullName.last = words[0];
        this.fullName.first = words[words.length - 1];
        this.fullName.mid = "";
        for (int i = 1; i < words.length - 1; i++) {
            this.fullName.mid += words[i] + " ";
        }
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

    public final Date getBirthDay() {
        return birthDay;
    }

    public final void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        this.email = email;
    }

    public final String getNumber() {
        return number;
    }

    public final void setNumber(String number) {
        this.number = number;
    }

    //hành động
    public void eat() {
        System.out.println(getFullName() + " đang ăn ...");
    }

    public void sleep() {
        System.out.println(getFullName() + " đang ngủ ...");
    }

    public void talk() {
        System.out.println(getFullName() + " đang nói chuyện với bạn ...");
    }

    public void relax() {
        System.out.println(getFullName() + " đang giải trí ...");
    }

    //abstract doWork
    protected abstract void doWork();

    class FullName {
        private String last;    //tên họ
        private String mid; //tên đệm
        private String first;   //tên thật


        public FullName() {
            last = "";
            mid = "";
            first = "";
        }

        public FullName(String last, String mid, String first) {
            this.last = last;
            this.mid = mid;
            this.first = first;
        }

        public final String getLast() {
            return last;
        }

        public final void setLast(String last) {
            this.last = last;
        }

        public final String getMid() {
            return mid;
        }

        public final void setMid(String mid) {
            this.mid = mid;
        }

        public final String getFirst() {
            return first;
        }

        public final void setFirst(String first) {
            this.first = first;
        }
    }
}
