package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection==null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql:///heavyDb", "root", "");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
