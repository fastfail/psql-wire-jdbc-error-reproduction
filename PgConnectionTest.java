import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PgConnectionTest {

    public static void main(String[] args) {
        System.out.println("1. Start");

        String url = "jdbc:postgresql://127.0.0.1:5432/test";
        String user = "postgres";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            System.out.println("2. Try to load driver");
            Class.forName("org.postgresql.Driver");

            System.out.println("3. Try to connect");
            conn = DriverManager.getConnection(url, user, password);
            
            System.out.println("4. Connected");
        } catch (Exception e) {
            System.out.println("Failed to connect db");
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
