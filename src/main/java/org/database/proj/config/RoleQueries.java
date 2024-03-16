package org.database.proj.config;

public class RoleQueries {
    public static String CREATE_TABLE = "CREATE TABLE roles (\n" +
            "  role_id varchar(36) PRIMARY KEY,\n" +
            "  role_title varchar(200), \n" +
            ");";


    public static String INSERT_INTO = "INSERT INTO roles values (?, ?);";

    public static String SELECT_ALL = "SELECT * from roles;";

    public static String UPDATE_SET = "UPDATE roles SET role_title = ? WHERE role_id = ?;";

    public static String DELETE = "DELETE FROM roles WHERE role_id = ?;";

}
