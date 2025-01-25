package programsDemo.dbTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchInsert {
    public static void main(String[] args)
    {
        String[] insertSQLs={
//         "INSERT INTO products(name, description, price) VALUES ('Laptop','Dell Inspiron',75000.0)",
//         "INSERT INTO products(name, description, price) VALUES ('Smartphone','Samsung Galaxy',30000.0)",
//         "INSERT INTO products(name, description, price) VALUES ('Tablet','Apple iPad',50000.0)",
        "INSERT INTO products(name, description, price) VALUES ('Smartwatch','Apple Watch',20000.0)",
        "INSERT INTO products(name, description, price) VALUES ('HeadPhones','Bose QuietComfort',15000.0)",
        };

        try(
                Connection connection= JDBCExample.getConnection();
                Statement statement=connection.createStatement())
        {
            for(String sql:insertSQLs){
                statement.addBatch(sql);
            }
            int[] result=statement.executeBatch();
            System.out.println("Inserted"+result.length+"records successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
