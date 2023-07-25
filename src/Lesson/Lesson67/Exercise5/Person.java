package Lesson.Lesson67.Exercise5;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person implements Comparable<Person> {
    private String numberId;    //số cmnd ,cccd
    private FullName fullName;  //họ tên
    private String address; //địa chỉ
    private Date birthDay;  //ngày sinh
    private String email;   //email
    private String numberPhone; //số điện thoại

    protected Person() {
        numberId = "";
        fullName = new FullName();
        address = "";
        birthDay = new Date();
        email = "";
        numberPhone = "";
    }

    public Person(String numberId, String fullName, String address, Date birthDay,
                  String email, String numberPhone) throws InValidFullNameException,
            InValidNumberPhoneException, InValidEmailException {
        this.fullName = new FullName();
        this.numberId = numberId;
        this.setFullName(fullName);
        this.address = address;
        this.setBirthDay(birthDay);
        this.setEmail(email);
        this.setNumberPhone(numberPhone);
    }

    public final String getNumberId() {
        return numberId;
    }

    public final void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    //trả về họ tên kiểu string
    public final String getFullNameString() {

        return fullName.last.toUpperCase(Locale.ROOT) + " " +
                fullName.mid.toUpperCase(Locale.ROOT) +
                fullName.first.toUpperCase(Locale.ROOT);
    }

    public final FullName getFullName() {
        return fullName;
    }

    //phương thức lấy tên
    public final String getFullNameFrist() {
        return fullName.first;
    }
    //phương thức lấy năm sinh
    public int yearOfBirth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDay);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * phương thức kiểm tra định dạng của họ tên
     * họ tên bắt đầu từ chữ cái ,tối thiếu 2 kí tự
     * chấp nhận tiếng anh vs tiếng việt
     * không chứa kí tự đặc biệt hay số
     *
     * @param fullName họ tên cần kiểm tra định dạng
     * @throws InValidFullNameException xử lý ngoại lệ
     */
    public final void setFullName(String fullName) throws InValidFullNameException {
        var regex = "^([a-zA-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒ" +
                "ÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ]+\\s?){2,30}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE
                | Pattern.CANON_EQ | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(fullName);
        if (matcher.matches()) {
            var words = fullName.split("\\s+");
            this.fullName.last = words[0];
            this.fullName.first = words[words.length - 1];
            this.fullName.mid = "";
            for (int i = 1; i < words.length - 1; i++) {
                this.fullName.mid += words[i] + " ";
            }
        } else {
            var msg = "Họ tên : " + fullName + " không hợp lệ ! Vui lòng xem lại ";
            throw new InValidFullNameException(msg, null);
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

    /**
     * phương thức kiểm tra định dạng email
     * bắt đầu chữ cái ,sau đó có thể chứa chữ cái
     * và số  kí tự ._
     *
     * @param email kiểm tra định dạng
     * @throws InValidEmailException xử lý ngoại lệ
     */
    public final void setEmail(String email) throws InValidEmailException {
        var regex = "^[a-z]+[a-z0-9._]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            var msg = "Email : " + email + " không hợp lệ ! Vui lòng xem lại !";
            throw new InValidEmailException(msg, null);
        }
    }

    public final String getNumberPhone() {
        return numberPhone;
    }

    /**
     * phương thức kiểm tra định dạng của số điện thoại
     * chỉ chứa số ,đầu 08 09 có 9 số ,đầu 03 04 07 có 10 số
     *
     * @param numberPhone kiểm tra định dạng
     * @throws InValidNumberPhoneException xử lý ngoại lệ
     */
    public final void setNumberPhone(String numberPhone) throws InValidNumberPhoneException {
        var regex1 = "^(08 |09)\\d{7}$";
        var regex2 = "^(03|04|07)\\d{8}$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(numberPhone);

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(numberPhone);
        if (matcher1.matches() || matcher2.matches()) {
            this.numberPhone = numberPhone;
        } else {
            var msg = "Số điện thoại :" + numberPhone + " không hợp lệ ! Vui lòng xem lại ";
            throw new InValidNumberPhoneException(msg, null);
        }
    }

    //abstract
    public final void eat() {
        System.out.println(getFullNameString() + " đang ăn trưa..");
    }

    public void sleep() {
        System.out.println(getFullNameString() + " đang ngủ....");
    }

    public void talk() {
        System.out.println(getFullNameString() + " đang nói chuyện với bạn...");
    }

    public void doWork() {
        System.out.println(getFullNameString() + " đang làm việc ");
    }


    class FullName {
        private String last;   //tên họ
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

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }
    }
}
