package Lesson.Lesson75SQL.Example;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class Example {
    private final static String USER = "hainguyen";
    private final static String PASSWORD = "0207";
    private final static String DB_NAME = "student_management";
    private final static String SEVER_NAME = "DESKTOP-CPFJBV6\\SQLEXPRESS";
    private final static int PORT_NUMBER = 1433;

    public static void main(String[] args) {
        LinkedList<Student> students = readStudentUsingStatement();
        System.out.println("====> Danh sách sinh viên đọc từ Statement <=====");
        showStudents(students);
        students.clear();
        students.addAll(readStudentUsingPrepareStatement());
        System.out.println("===> Danh sách đọc sinh viên từ PrepareStatement <=====");
        showStudents(students);
    }

    /**
     * phương thức đọc dữ liệu từ bảng trong csdl
     * sử dụng PrepareStatement
     *
     * @return
     */
    private static Collection<? extends Student> readStudentUsingPrepareStatement() {
        LinkedList<Student> students = new LinkedList<>();
        SQLServerDataSource dataSource = dataSource();
        try (var conn = dataSource.getConnection()) {
            var sql = "SELECT * FROM dbo.student";
            var preparedStatement = conn.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                var id = resultSet.getString(1); // đọc ra mã sv
                var name = resultSet.getString(2); // đọc tên sv
                var address = resultSet.getString(3); // đọc địa chỉ
                var email = resultSet.getString(4); // đọc email
                var major = resultSet.getString(5); // chuyên nghành
                var avgGrade = resultSet.getFloat(6); // đọc điểm tb
                // tạo mới đối tượng sinh viên
                Student student = new Student(id, name, address, email, major, avgGrade);
                students.add(student); // thêm vào danh sách studens
            }
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
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
    private static void showStudents(LinkedList<Student> students) {
        System.out.printf("%-20s%-25s%-25s%-25s%-25s%-15s\n", "Mã SV",
                "Họ và tên", "Địa chỉ", "Email", "Chuyên ngành", "Điểm TB");
        for (var student : students) {
            System.out.printf("%-20s%-25s%-25s%-25s%-25s%-15.2f\n", student.getId(),
                    student.getName(), student.getAddress(), student.getEmail(),
                    student.getMajor(), student.getAvgGrade());
        }
    }

    /**
     * phương thức đọc dữ liệu từ bảng cơ sở dữ liệu
     * sử dụng Statement
     *
     * @return
     */
    private static LinkedList<Student> readStudentUsingStatement() {
        LinkedList<Student> students = new LinkedList<>();
        SQLServerDataSource dataSource = dataSource();
        try (var conn = dataSource.getConnection()) {
            var sql = "SELECT * FROM dbo.student";   //câu truy vấn SQL
            var statement = conn.createStatement();
            var resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                var id = resultSet.getString(1); // đọc ra mã sv
                var name = resultSet.getString(2); // đọc tên sv
                var address = resultSet.getString(3); // đọc địa chỉ
                var email = resultSet.getString(4); // đọc email
                var major = resultSet.getString(5); // chuyên nghành
                var avgGrade = resultSet.getFloat(6); // đọc điểm tb
                // tạo mới đối tượng sinh viên
                Student student = new Student(id, name, address, email, major, avgGrade);
                students.add(student); // thêm vào danh sách studens
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    /**
     * Phương thức kết nối với SQL SEVER
     *
     * @return
     */
    private static SQLServerDataSource dataSource() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        dataSource.setDatabaseName(DB_NAME);
        dataSource.setServerName(SEVER_NAME);
        dataSource.setPortNumber(PORT_NUMBER);
        return dataSource;
    }

}
