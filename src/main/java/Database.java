import java.sql.*;

public class Database {  // Singleton class
    private static Database instance = null;

    private Database() {
        try {
            Class.forName("org.sqlite.JDBC");  // Load JDBC driver
            Connection c = DriverManager.getConnection("jdbc:sqlite:requests.db");  // Connect to requests.db
            Statement stmt = c.createStatement();  // Create statement

            String sql = "CREATE TABLE IF NOT EXISTS requests " +
                    "(url TEXT NOT NULL, ip TEXT NOT NULL)";  // Create table with columns url and ip
            stmt.executeUpdate(sql);  // Execute query

            stmt.close(); // Close statement
            c.close(); // Close connection
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public void addRequest(String url, String ip) {
        try {
            Class.forName("org.sqlite.JDBC");  // Load JDBC driver
            Connection c = DriverManager.getConnection("jdbc:sqlite:requests.db");  // Connect to requests.db
            Statement stmt = c.createStatement();  // Create statement

            String sql = "INSERT INTO requests (url, ip) VALUES ('" + url + "', '" + ip + "')";  // Insert url and ip into table
            stmt.executeUpdate(sql);  // Execute query

            stmt.close();  // Close statement
            c.close();  // Close connection
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
