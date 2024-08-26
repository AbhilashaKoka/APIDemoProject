package org.example.MySQL;
import java.sql.Connection;
import java.sql.SQLException;

public class CloseConnection {
    public static void main(String[] args) {
        try(Connection connection=DBReader.getConnection()){
            if(connection !=null){
                System.out.println("Connected to the database!!!!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }

