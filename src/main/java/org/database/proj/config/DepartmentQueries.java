package org.database.proj.config;

public class DepartmentQueries {

    public static String CREATE_TABLE = "CREATE TABLE department (\n" +
            "  department_id varchar(36) PRIMARY KEY NOT NULL,\n" +
            "  department_title varchar(200), \n" +
            "  department_manager varchar(36),\n" +
            "  CONSTRAINT department_manager FOREIGN KEY (department_manager) REFERENCES employee (employee_id) ON UPDATE CASCADE ON DELETE CASCADE \n" +
            ");";

    public static String UPDATE_DEPARTMENT_SET_DEP_MANAGER = "UPDATE department SET department_manager = ? where department_id = ?;";

    public static String INSERT_INTO = "INSERT INTO department values (?, ?, ?);";

    public static String SELECT_ALL = "SELECT * FROM department";

    public static String DROP_TABLE = "DROP TABLE if exists department";

    public static String UPDATE_SET = "UPDATE department SET department_title = ?, department_manager = ? WHERE department_id =?;";

    public static String DELETE = "DELETE FROM department WHERE department_id = ?;";
}
