package org.database.proj.config;

public class EmployeeQueries {

    public static String CREATE_TABLE = "CREATE TABLE employee (\n" +
            "  employee_id varchar(36) PRIMARY KEY,\n" +
            "  full_name varchar(200), \n" +
            "  salary float \n" +
            ");";

    public static String INSERT_INTO = "INSERT INTO employee values (?, ?, ?);";

    public static String SELECT_ALL = "SELECT a.employee_id, a.full_name, a.salary, b.department_title,  b.department_id, b.department_manager " +
            "FROM employee a INNER JOIN department b ON a.employee_id = b.department_manager;";

    public static String DROP_TABLE = "DROP TABLE if exists employee";

    public static String UPDATE_SET = "UPDATE employee SET full_name = ?, salary = ?, department = ? WHERE employee_id = ?;";

    public static String DELETE = "DELETE FROM employee WHERE employee_id = ?;";
}
