package utilityDemoTest.dateTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SysdateExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "yourusername";
        String password = "yourpassword";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SYSDATE FROM dual");

            if (resultSet.next()) {
                System.out.println("Current Date and Time: " + resultSet.getString(1));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
