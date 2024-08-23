package org.example.MySQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) throws SQLException {

        String createTableSQL = "CREATE TABLE products (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100)," +
                "description VARCHAR(250), " +
                "price DECIMAL(10, 2)" +
                ")";

        try(
                Connection connection=DBReader.getConnection();
                Statement statement=connection.createStatement())
                {
                    statement.execute(createTableSQL);
                    System.out.println("Table created Successfully!!!");

                 }
        catch(SQLException e){
            e.printStackTrace();
        }


        }





    }

