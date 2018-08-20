package Database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String MYSQL_DB = "jdbc:mysql://localhost:3306/mydb";
    static java.sql.Connection databaseConnection = null;

   public Connection(){
        createConnection();

    }
    public java.sql.Connection createConnection() {
        if(databaseConnection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                databaseConnection = DriverManager.getConnection(MYSQL_DB,"root","1234");

            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return databaseConnection;
        }else
            return databaseConnection;
    }

    public static java.sql.Connection getDatabaseConnection() {
        return databaseConnection;
    }
}
