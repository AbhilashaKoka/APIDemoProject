package org.example.javaDemo.MySQL;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertEmployeeExample {

    public static void main(String[] args){
        String insertEmployeeSQL="{CALL insertEmployee(?,?,?)}";


        try(Connection connection=JDBCExample.getConnection();
            CallableStatement callableStatement=connection.prepareCall(insertEmployeeSQL)){

            callableStatement.setString(1,"Alice Brown");
            callableStatement.setString(2,"Sales");
            callableStatement.setBigDecimal(3,new BigDecimal("5500.00"));
            callableStatement.execute();
            System.out.println("Employee inserted successfully!!!");

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
