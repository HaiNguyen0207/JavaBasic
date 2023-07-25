package ConnectionSQL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser("sa");//user
        dataSource.setPassword("0207");//password
        dataSource.setServerName("DESKTOP-CPFJBV6\\SQLEXPRESS");//sever name
        dataSource.setPortNumber(1433);//port tcp/ip
        dataSource.setDatabaseName("test");//db name

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connection success");
            System.out.println(connection.getCatalog());
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
