package org.database.proj.service;

import org.database.proj.config.DatabaseConnector;
import org.database.proj.model.Department;
import org.database.proj.model.Employee;
import org.database.proj.config.DatabaseConfig;
import org.database.proj.config.EmployeeQueries;
import org.database.proj.service.impl.EmployeeFunctions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements EmployeeFunctions {

    private Connection connection;

    public EmployeeService() {
        this.connection = DatabaseConnector.getCONNECTION();
    }


    @Override
    public void createEmployeeTableIfNotExists() {
        try {
            if (connection != null && !connection.isClosed()) {
                Statement statement = connection.createStatement();
                statement.execute(EmployeeQueries.CREATE_TABLE);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void addEmployee(String employeeId, String fullName, float salary) {
        try {
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(EmployeeQueries.INSERT_INTO);
                statement.setString(1, employeeId);
                statement.setString(2, fullName);
                statement.setFloat(3, salary);
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try {
            if (connection != null && !connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery(EmployeeQueries.SELECT_ALL);
                while (set.next()) {
                    // one row
                    String employeeId = set.getString("employee_id");
                    String fullName = set.getString("full_name");
                    float salary = set.getFloat("salary");
                    String departmentTitle = set.getString("department_title");
                    String departmentId = set.getString("department_id");
                    String depManagerId = set.getString("department_manager");
                    Department department = new Department(departmentTitle);
                    department.setDepartmentTitle(departmentTitle);
                    department.setDepartmentId(departmentId);
                    department.setDepartmentManager(depManagerId);
                    Employee employee = new Employee(employeeId, fullName, salary, department);
                    list.add(employee);
                }
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return list;

    }

    @Override
    public void updateEmployee(String employeeID, String fullName, float salary) {
        try{
            if(connection != null && !connection.isClosed()){
                PreparedStatement statement = connection.prepareStatement(EmployeeQueries.UPDATE_SET);
                statement.setString(1,fullName);
                statement.setFloat(2, salary);
                statement.setString(3, employeeID);
                statement.execute();
            }
        }catch(SQLException exception){
            System.out.println("Error: " + exception.getMessage());

        }

    }

    @Override
    public void deleteEmployee(String employeeId) {
        try{
            if(connection != null && !connection.isClosed()){
                PreparedStatement statement = connection.prepareStatement(EmployeeQueries.DELETE);
                statement.setString(1,employeeId);
                statement.execute();
            }

        }catch(SQLException exception){
            System.out.println("Error: " + exception.getMessage());
        }

    }

    @Override
    public void dropEmployeeTableIfExists() {
        try{
            Statement statement = connection.createStatement();
            statement.execute(EmployeeQueries.DROP_TABLE);
        }
        catch(Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
    }


}
