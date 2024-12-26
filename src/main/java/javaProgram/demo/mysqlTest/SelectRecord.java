package javaProgram.demo.mysqlTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRecord {
    public static void main(String[] args) {
        String selectSQL = "SELECT * FROM products";

        try (
                Connection connection = JDBCExample.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                System.out.println("ID:" + id + ",Name:" + name + ",Description:" + description + ",Price:" + price);
            }

            } catch(SQLException e)
        {
        e.printStackTrace();
    }
  }
}

