package utilityDemoTest.dbTest;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdate {


    private static final String UPDATE_PRODUCT_SQL =
            "UPDATE products SET price =? WHERE name=? ";

    public static void main(String[] args) {
        try(
                Connection connection= JDBCExample.getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_PRODUCT_SQL))
        {
            Object[][] productUpdates={
                    { new BigDecimal("800000"),"Laptop" },
                    { new BigDecimal("35000"), "Smartphone"},
                    { new BigDecimal("55000"),"Tablet"},
                    { new BigDecimal("22000"),"Smartwatch"},
                    { new BigDecimal("1700"), "HeadPhones"},

            };

            for (Object[] productUpdate:productUpdates){
                preparedStatement.setBigDecimal(1,(BigDecimal) productUpdate[0]);
                preparedStatement.setString(2,(String)productUpdate[1]);
                preparedStatement.addBatch();
            }
            int[] result=preparedStatement.executeBatch();
            System.out.println("Updated"+result.length+"records successfully!");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
