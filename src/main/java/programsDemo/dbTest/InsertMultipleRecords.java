package programsDemo.dbTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecords {
    public static void main(String[] args) {

        String insert1="INSERT INTO products(name, description, price) VALUES ('Laptop','Dell Inspiron',75000.0)";
        String insert2="INSERT INTO products(name, description, price) VALUES ('Smartphone','Samsung Galaxy',30000.0)";
        String insert3="INSERT INTO products(name, description, price) VALUES ('Tablet','Apple iPad',50000.0)";


        try(
                Connection connection= JDBCExample.getConnection();
                Statement statement=connection.createStatement())
               {
                statement.executeUpdate(insert1);
                statement.executeUpdate(insert2);
                statement.executeUpdate(insert3);
                System.out.println("Records inserted successfully!");
              }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }

    }
}
