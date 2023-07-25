package Lesson.Lesson51.Exercise5;

import java.util.Date;

public abstract class Person {
    private String id;  // CCCD/CMND
    private FullName fullName;  //họ tên
    private String address; //địa chỉ
    private Date bitrhDay;  //ngày sinh
    private String email;   //email
    private String number;  //số điện thoại

    protected Person() {
        id = "";
        fullName = new FullName();
        address = "";
        bitrhDay = new Date();
        email = "";
        number = "";
    }

    public Person(String id, String fullName, String address, Date bitrhDay, String email, String number) {
        this.fullName = new FullName();
        this.id = id;
        this.setFullName(fullName);
        this.address = address;
        this.bitrhDay = bitrhDay;
        this.email = email;
        this.number = number;
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    public final FullName getAFullName() {
        return fullName;
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

    public final Date getBitrhDay() {
        return bitrhDay;
    }

    public final void setBitrhDay(Date bitrhDay) {
        this.bitrhDay = bitrhDay;
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

    //abstract
    protected abstract void doWord();   //làm việc

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

    class FullName {
        private String last;    //tên họ
        private String mid; //tên đệm
        private String first;   //tên thật

        protected FullName() {
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
