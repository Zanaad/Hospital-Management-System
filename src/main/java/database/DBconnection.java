package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {

    private static String URL = "jdbc:mysql://localhost:3306/projektiknk";
    private static String USER = "root";
    private static String PASSWORD = "Mathem12$";
    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(
                        URL, USER, PASSWORD
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
