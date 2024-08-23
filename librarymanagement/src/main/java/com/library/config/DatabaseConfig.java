// DatabaseConfig.java
package com.library.config;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfig {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
                Properties prop = new Properties();
                prop.load(input);
                String url = prop.getProperty("db.url");
                String username = prop.getProperty("db.username");
                String password = prop.getProperty("db.password");

                connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
                throw new SQLException("Unable to connect to database");
            }
        }
        return connection;
    }
}
