package Lesson.Lesson75SQL.Example;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Example1 {
    private static final String USER = "hainguyen";
    private static final String PASSWORD = "0207";
    private static final String SEVER_NAME = "DESKTOP-CPFJBV6\\SQLEXPRESS";
    private static final String DB_NAME = "student_management";
    private static final int PORT_NUMBER = 1433;

    public static void main(String[] args) {
        List<Student> students = readStudentUsingStatement();
        System.out.println("===> Danh sách sinh viên sử dụng Statement <====");
        showStudents(students);
        students.clear();
        System.out.println("===> Danh sách sinh viên sử dụng PapareStatement <===");
        students.addAll(readStudentUsingPrepareStatement());
        showStudents(students);
    }

    /**
     * phương thức  đọc dữ liệu từ bảng cơ sở dữ liệu
     * chuyển thành trường dữ liệu của sinh viên
     * sử dụng prepareStatement
     *
     * @return
     */
    private static Collection<? extends Student> readStudentUsingPrepareStatement() {
        LinkedList<Student> students = new LinkedList<>();
        SQLServerDataSource dataSource = dataSource();
        try (var connect = dataSource.getConnection()) {
            var sql = "SELECT * FROM dbo.student";
            var prepareStatement = connect.prepareStatement(sql);
            var resultSet = prepareStatement.executeQuery();
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
     * phương thức hiển thị sinh viên
     *
     * @param students danh sách sinh viên cần hiển thị
     */
    private static void showStudents(List<Student> students) {
        System.out.printf("%-20s%-20s%-20s%-20s%-25s%-15s\n", "Mã SV", "Họ Tên"
                , "Địa Chỉ", "Email", "Chuyên ngành", "Điểm TB");
        for (var e : students) {
            System.out.printf("%-20s%-20s%-20s%-20s%-25s%-15.2f\n", e.getId(),
                    e.getName(), e.getAddress(), e.getEmail(), e.getMajor(), e.getAvgGrade());
        }
    }

    /**
     * phương thức đọc dữ liệu từ bảng cơ sở dữ liệu
     * chuyển thành trường dữ liệu của sinh viên
     * sử dụng Statement
     *
     * @return
     */
    private static List<Student> readStudentUsingStatement() {
        List<Student> students = new LinkedList<>();
        SQLServerDataSource dataSource = dataSource();
        try (var connect = dataSource.getConnection();) {
            var sql = "SELECT * FROM dbo.student";
            var statement = connect.createStatement();
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
     * phương thức kết nối với SQL
     *
     * @return
     */
    private static SQLServerDataSource dataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setServerName(SEVER_NAME);
        dataSource.setDatabaseName(DB_NAME);
        dataSource.setPortNumber(PORT_NUMBER);
        return dataSource;
    }
}
