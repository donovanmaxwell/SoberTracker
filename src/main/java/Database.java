import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static void createNewDatabase() {

        String url = "jdbc:sqlite:tracker.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("The tracker database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection connect() {

        String url = "jdbc:sqlite:tracker.db";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to database...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createDateTable() {

    }

}
