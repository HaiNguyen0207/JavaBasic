package Lesson.Lesson67.Example;



import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exmployee {
    private String id;  //họ tên
    private String fullName; //họ tên
    private String email;   //emaill

    protected Exmployee() {
        id = "";
        fullName = "";
        email = "";
    }

    public Exmployee(String id, String fullName, String email)
            throws InValidEmpIdException {
        this.setId(id);
        this.fullName = fullName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InValidEmpIdException {
        var regex = "^(NV|EMP){1}\\d{6}[a-z]{2,5}$";
        Pattern pattern=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher= pattern.matcher(id);
       if(matcher.matches()) {
           this.id=id.toUpperCase(Locale.ROOT);
       }else {
           var msg="Mã nhân viên "+id+" không hợp lệ !";
           this.id=null;
           throw new InValidEmpIdException(msg,id);
       }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
