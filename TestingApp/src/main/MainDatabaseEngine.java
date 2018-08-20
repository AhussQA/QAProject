import Database.Connection;
import Database.DatabaseFunctions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class MainDatabaseEngine {
    public static void main(String[] args) {
        Connection connection = new Connection();
        java.sql.Connection databaseConnection = connection.getDatabaseConnection();
        Statement statement; 
        
        String sqlQuery = "";
       

        try {
            statement = databaseConnection.createStatement();
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().toUpperCase();
            
          
            
            ResultSet rs = statement.executeQuery(DatabaseFunctions.listItems());

            while (rs.next())
                System.out.println("Name: " + rs.getString(1) + " Type: " + rs.getString(2) + " Price: " + rs.getString(3) + " Quantity: " + rs.getString(4));

            rs = statement.executeQuery(DatabaseFunctions.listItems("Chocolate Flapjack"));
            while (rs.next())
                System.out.println("Name: " + rs.getString(1) + " Type: " + rs.getString(2) + " Price: " + rs.getString(3) + " Quantity: " + rs.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
