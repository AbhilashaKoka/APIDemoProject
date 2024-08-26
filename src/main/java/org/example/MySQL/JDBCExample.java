package org.example.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample
{
    private static final String URL="jdbc:mysql://localhost:3306/jdbc_example";
    private static final String USER="root";
    private static final String PASSWORD="system";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {

        try(Connection connection=getConnection()){
            if(connection !=null){
                System.out.println("Connected to the database!!!!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }

