package Lesson.Lesson75SQL.Example;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Test {
    private final static String USER = "hainguyen";
    private final static String PASSWORD = "0207";
    private final static String DB_NAME = "student_management";
    private final static String SEVER_NAME = "DESKTOP-CPFJBV6\\SQLEXPRESS";
    private final static int PORT_NUMBER = 1433;

    public static void main(String[] args) {
        List<Student> students = readStudentUsingStatement();
        System.out.println("==> Đọc dữ liệu từ CSDL sử dụng Statement <==");
        showStudents(students);
        students.clear();
        students.addAll(readStudentUsingPrepareStatement());
        System.out.println("==> Đọc dữ liệu từ CSDL sử dụng PrepareStatement <==");
        showStudents(students);
    }

    /**
     * phương thức này đọc dữ liệu từ bảng csdl sau đó chuyển dữ liệu
     * trên từng hàng chuyển thành từng trường dữ liệu của nhân viên
     * sử dụng PrepareStatement
     *
     * @return danh sách đối tượng đã đọc
     */
    private static Collection<? extends Student> readStudentUsingPrepareStatement() {
        List<Student> students = new LinkedList<>();
        SQLServerDataSource dataSource = dataSource();
        try (var conn = dataSource.getConnection()) {
            var sql = "SELECT * FROM dbo.student";  //câu  truy vấn sql
            var preparedStatement = conn.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getString(1);
                var name = resultSet.getString(2);
                var address = resultSet.getString(3);
                var email = resultSet.getString(4);
                var major = resultSet.getString(5);
                var avgGrade = resultSet.getFloat(6);
                students.add(new Student(id, name, address, email, major, avgGrade));
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;

    }

    /**
     * phương thức hiển thị danh sách sinh viên
     *
     * @param students danh sách sinh viên cần hiển thị
     */
    private static void showStudents(List<Student> students) {
        System.out.printf("%-20s%-25s%-25s%-25s%-25s%-15s\n", "Mã SV",
                "Họ và tên", "Địa chỉ", "Email", "Chuyên ngành", "Điểm TB");
        for (var student : students) {
            System.out.printf("%-20s%-25s%-25s%-25s%-25s%-15.2f\n", student.getId(),
                    student.getName(), student.getAddress(), student.getEmail(),
                    student.getMajor(), student.getAvgGrade());
        }
    }

    /**
     * phương thức này đọc dữ liệu từ bảng cơ sở dữ liệu sau đó chuyển dữ liệu
     * trên từng hàng thành các trường dữ liệu của đối tượng sinh viên
     * sử dụng Statement
     *
     * @return
     */
    private static List<Student> readStudentUsingStatement() {
        List<Student> students = new LinkedList<>();
        SQLServerDataSource dataSource = dataSource();
        try (var conn = dataSource.getConnection()) {
            var sql = "SELECT * FROM dbo.student";  //câu  truy vấn sql
            var statement = conn.createStatement();
            var resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                var id = resultSet.getString(1);
                var name = resultSet.getString(2);
                var address = resultSet.getString(3);
                var email = resultSet.getString(4);
                var major = resultSet.getString(5);
                var avgGrade = resultSet.getFloat(6);
                students.add(new Student(id, name, address, email, major, avgGrade));
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    /**
     * helper method makes connection with configuration object manager
     *
     * @return object after configured
     */
    private static SQLServerDataSource dataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setPortNumber(PORT_NUMBER);
        dataSource.setServerName(SEVER_NAME);
        dataSource.setDatabaseName(DB_NAME);
        return dataSource;
    }

}
