package org.database.proj.service.impl;

import org.database.proj.model.Employee;

import java.util.List;

public interface EmployeeFunctions {

    public void createEmployeeTableIfNotExists();

    public void addEmployee(String employeeId, String fullName, float salary);

    public List<Employee> getAllEmployees();

    public void updateEmployee(String employeeId, String fullName, float salary);

    public void deleteEmployee(String employeeId);

    public void dropEmployeeTableIfExists();

}
