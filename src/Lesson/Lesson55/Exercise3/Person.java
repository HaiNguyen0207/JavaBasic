package Lesson.Lesson55.Exercise3;

import java.util.Date;

public abstract class Person implements Comparable<Person> {
    private String id;  //số cmnd/cccd
    private FullName fullName;  //họ tên
    private String address; //địa chỉ
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

    public Person(String fullName, Date birthDay) {
        this.fullName = new FullName();
        setFullName(fullName);
        this.birthDay = birthDay;
    }

    public Person(String id, String fullName) {
        this.fullName = new FullName();
        this.id = id;
        setFullName(fullName);
    }

    public Person(String id, String fullName, String address,
                  Date birthDay, String email, String number) {
        this.fullName = new FullName();
        this.id = id;
        setFullName(fullName);
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

    public final FullName getFullName() {
        return fullName;
    }

    /**
     * phương thức trả về họ tên đầy đủ
     *
     * @return
     */
    public final String getFullNameString() {
        return fullName.last + " " + fullName.mid + fullName.first;
    }

    public final String getFirstName() {
        return fullName.first;
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

    @Override
    public int compareTo(Person other) { //sắp xếp tên a-z
        return getFullNameString().compareTo(other.getFullNameString());
    }

    //abstract
    protected abstract void eat();  //ăn

    protected abstract void sleep();    //ngủ

    protected abstract void talk(); //nói chuyện

    protected abstract void entertainment();   //giải trí

    protected abstract void work();    //làm việc

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
