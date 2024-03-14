package org.database.proj.service;

import org.database.proj.config.DatabaseConnector;
import org.database.proj.config.DepartmentQueries;
import org.database.proj.model.Department;
import org.database.proj.service.impl.DepartmentFunctions;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements DepartmentFunctions {

    private Connection connection;

    public DepartmentService() {
        this.connection = DatabaseConnector.getCONNECTION();
    }

    @Override
    public void createDepartmentTableIfNotExists() {
        try {
            if (connection != null && !connection.isClosed()) {
                Statement statement = connection.createStatement();
                statement.execute(DepartmentQueries.CREATE_TABLE);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    @Override
    public void addDepartment(String departmentId, String departmentTitle, String departmentManager) {
        try {
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(DepartmentQueries.INSERT_INTO);
                statement.setString(1, departmentId);
                statement.setString(2, departmentTitle);
                statement.setString(3, departmentManager);
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        try {
            if (connection != null && !connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery(DepartmentQueries.SELECT_ALL);
                while (set.next()) {
                    String departmentId = set.getString("department_id");
                    String departmentTitle = set.getString("department_title");
                    String departmentManager = set.getString("department_manager");
                    Department department = new Department(departmentId, departmentTitle, departmentManager);
                    list.add(department);
                }
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return list;
    }

    @Override
    public void updateDepartment(String departmentId, String departmentTitle, String departmentManager) {
        try {
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(DepartmentQueries.UPDATE_SET);
                statement.setString(1, departmentId);
                statement.setString(2, departmentTitle);
                statement.setString(3, departmentManager);
                statement.execute();
            }
        } catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());

        }
    }


    public void updateDepartmentForeignKey(String departmentManager, String departmentId) {
        try {
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(DepartmentQueries.UPDATE_DEPARTMENT_SET_DEP_MANAGER);
                statement.setString(1, departmentManager);
                statement.setString(2, departmentId);
                statement.execute();
            }
        } catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @Override
    public void deleteDepartment(String departmentId) {
        try {
            if (connection != null && !connection.isClosed()) {
                PreparedStatement statement = connection.prepareStatement(DepartmentQueries.DELETE);
                statement.setString(1, departmentId);
                statement.execute();
            }

        } catch (SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @Override
    public void dropDepartmentTableIfExists() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(DepartmentQueries.DROP_TABLE);
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
