package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbconnection {
    private static Dbconnection instance;
    private Connection conn;

    private Dbconnection() {
        try {
            // Thay đổi chuỗi kết nối dưới đây theo cơ sở dữ liệu của bạn
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLCOFFEE;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password = "12345";
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Dbconnection getInstance() {
        if (instance == null) {
            instance = new Dbconnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
