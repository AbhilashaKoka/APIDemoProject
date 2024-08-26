package org.example.MySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
    public static void main(String[] args) {

        String deleteSQL="DELETE FROM products WHERE name='Laptop'";

        try(
                Connection connection=DBReader.getConnection();
                Statement statement=connection.createStatement())
        {
            int rowDeleted=statement.executeUpdate(deleteSQL);
            System.out.println(rowDeleted+"row(s) deleted!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
