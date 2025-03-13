package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ClientDao class provides CRUD operations for the Client model.
 * 
 * @author Duvan Yesid Vivaas Bermudez 1002280067
 */

public class DatabaseConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/veterinaria";
    public static final String USER = "root";
    public static final String PASSWORD = "admin";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }
}
