package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            c = DriverManager.getConnection("jdbc:mysql://localhost:3307/duancuoiki", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c) {
        try {
            if(c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
