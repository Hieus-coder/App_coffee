
package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    private Connection conn;

    public Dbconnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLCOFFEE;encrypt=true;trustServerCertificate=true;";
            conn = DriverManager.getConnection(connectionUrl, "sa", "12345");
            System.out.println("Connected.");
        } catch (ClassNotFoundException e) {
            System.out.println("Don't find driver JDBC: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Er: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnect() {
        return conn;
    }
}
