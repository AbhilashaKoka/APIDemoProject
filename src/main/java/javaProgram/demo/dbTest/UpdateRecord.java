package javaProgram.demo.dbTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {
    public static void main(String[] args) {
        String updateSQL="UPDATE products SET price =80000.00 WHERE name= 'Laptop'";
        try( Connection connection= JDBCExample.getConnection();
             Statement statement=connection.createStatement())
        {
            int RowUpdated=statement.executeUpdate(updateSQL);
             System.out.println(RowUpdated+"row(s) updated");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
