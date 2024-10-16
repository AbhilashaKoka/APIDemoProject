package org.example.javaDemo.MySQL;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class GetEmployeeByIdExample {
    public static void main(String[] args) {
        String getEmployeeByIdSQL="{CALL getEmployeeById(?,?,?,?)}";

             try(Connection connection=JDBCExample.getConnection();
              CallableStatement callableStatement=connection.prepareCall(getEmployeeByIdSQL)){

                 callableStatement.setInt(1,1);
                 callableStatement.registerOutParameter(2, Types.VARCHAR);
                 callableStatement.registerOutParameter(3, Types.VARCHAR);
                 callableStatement.registerOutParameter(4, Types.VARCHAR);

                 callableStatement.execute();
                 String name=callableStatement.getString(2);
                 String department=callableStatement.getString(3);
                 BigDecimal salary=callableStatement.getBigDecimal(4);

                 System.out.println("Employee Details-ID:1, Name:"+name+",Department:"+department+",Salary:"+salary);
               }
             catch(SQLException e){
                 e.printStackTrace();
             }
    }
}
