package Lesson.Lesson76SQL.Example;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.SQLException;

public class Example {
    private final static String USER = "hainguyen";
    private final static String PASSWORD = "0207";
    private final static String SEVER_NAME = "DESKTOP-CPFJBV6\\SQLEXPRESS";
    private final static String DB_NAME = "student_management";
    private final static int PORT_NUMBER = 1433;

    public static void main(String[] args) {
//        var result = insertDataUsingStatement();
        Student student = new Student("B25DCQT201", "Nguyễn Văn An", "Hà Nội",
                "hai@gmail.com", "An toàn thông tin", 3.03);
        var result = insertDataUsingPrepareStatement(student);
        if (result > 0) {
            System.out.println("Thực hiện thành công lệnh truy vấn. " +
                    result + " hàng đã được thêm vào trong bảng CSDL.");
        } else {
            System.out.println("Thực hiện câu lệnh truy vấn thất bại!");
        }
    }

    /**
     * phương thức ghi dữ liệu vào dảng csdl
     * sử dụng prepareStatement
     *
     * @param student
     * @return
     */
    private static int insertDataUsingPrepareStatement(Student student) {
        SQLServerDataSource dataSource = dataSource();
        try (var connect = dataSource.getConnection()) {
            var sql = "INSERT INTO dbo.student(id, name, address, " +
                    "email, average_grade, major) VALUES(?, ?, ?, ?, ?, ?)";
            var prepareStatemet = connect.prepareStatement(sql);
            prepareStatemet.setString(1, student.getId());
            prepareStatemet.setString(2, student.getName());
            prepareStatemet.setString(3, student.getAddress());
            prepareStatemet.setString(4, student.getEmail());
            prepareStatemet.setDouble(5, student.getAvgGrade());
            prepareStatemet.setString(6, student.getMajor());
            return prepareStatemet.executeUpdate();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    /**
     * phương thức  chèn dữ liệu vào bảng cơ sở dữ liệu
     * sử dụng Statement
     *
     * @return
     */
    private static int insertDataUsingStatement() {
        SQLServerDataSource dataSource = dataSource();
        try (var connect = dataSource.getConnection()) {
            var sql = "INSERT INTO dbo.student(name, id, email) " +
                    "VALUES(N'Ngô Bảo An', 'B25DCCN112', 'anb@gmail.com')";
            var statement = connect.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
            return -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    /**
     * phương thức kết nối cổng SQL
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
