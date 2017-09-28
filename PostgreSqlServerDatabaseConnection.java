import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Davorin on 6/25/2017.
 */
public class PostgreSqlServerDatabaseConnection {
    private static Connection connection = null;
    //1.jdbc driver name
    private static String POSTGRESQL_JDBC_DRIVER = "jdbc:postgresql:database";
    // 2. Database URL, V_UDAY\FRAMEWORK is ServerName and JSF is DataBase name
    private static String URL = "jdbc:sqlserver://davorinserver.database.windows.net;";

    //3.Database credentials
    private static String USERNAME = "postgres";//UserName
    private static String PASSWORD = "postgres!";//Password



    public static void main(String[] args) {
        getLocalConnection();
    }

    public static Connection getLocalConnection() {
        try {
            Class.forName(POSTGRESQL_JDBC_DRIVER);// Register jdbc driver


            System.out.println("****Connect to Database****");

            //4. open a connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("DataBase connect to: "+ connection.getMetaData().getDriverName());
            System.out.println("URL: "+ connection.getMetaData().getURL());

            setConnectionClose();
            System.out.println("Database Connection Closed");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Exception in getLocalConeection() "+e.getMessage());
        }
        return connection;
    }

    public static void setConnectionClose() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
