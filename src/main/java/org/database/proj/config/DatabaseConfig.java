package org.database.proj.config;

public class DatabaseConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_schema";
    private static final String USER = "root";
    private static final String PASS = "pass";

    public static String getURL() {
        return DB_URL;
    }

    public static String getUSER(){
        return USER;
    }

    public static String getPASS(){
        return PASS;
    }
}
