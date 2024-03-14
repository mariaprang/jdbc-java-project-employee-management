package org.database.proj.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static Connection connection;

    private static DatabaseConnector INSTANCE = new DatabaseConnector();

    private DatabaseConnector(){
        try {
            this.connection = DriverManager.getConnection(DatabaseConfig.getURL(), DatabaseConfig.getUSER(), DatabaseConfig.getPASS());
        } catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }


    public static Connection getCONNECTION() {
        return INSTANCE.connection;
    }
}
