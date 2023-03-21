package jm.task.core.jdbc.util;
import org.jboss.logging.Logger;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String URL = "jdbc:mysql://localhost:3306/user";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "DOi9123be23";
    public static final String DRIVER = "org.h2.driver";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение установленно");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Соединение не установленно");
        }
        return connection;
    }
}
