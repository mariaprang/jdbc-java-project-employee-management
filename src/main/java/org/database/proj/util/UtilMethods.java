package org.database.proj.util;

import org.database.proj.service.DepartmentService;
import org.database.proj.service.EmployeeService;

import java.util.UUID;

public class UtilMethods {

    public static void dropTables(DepartmentService depService, EmployeeService empService) {
        depService.dropDepartmentTableIfExists();
        empService.dropEmployeeTableIfExists();
    }

    public static void createTables(DepartmentService depService, EmployeeService empService) {
        empService.createEmployeeTableIfNotExists();
        depService.createDepartmentTableIfNotExists();
    }

    public static String insertIntoDepartment(DepartmentService service) {
        UUID departmentID = UUID.randomUUID();
        service.addDepartment(departmentID.toString(), "Marketing", null);
        return departmentID.toString();
    }

    public static String insertIntoEmployee(EmployeeService service) {
        UUID employeeID = UUID.randomUUID();
        service.addEmployee(employeeID.toString(), "John Doe", 170000);
        return employeeID.toString();
    }

    public static void updateDepartmentTable(DepartmentService service, String managerId, String departmentId) {
        service.updateDepartmentForeignKey(managerId, departmentId);
    }

    public static void getData(DepartmentService depService, EmployeeService empService) {
        System.out.println("--- DEPARTMENTS ---");
        System.out.println(depService.getAllDepartments());
        System.out.println("---");
        System.out.println("--- EMPLOYEES ---");
        System.out.println(empService.getAllEmployees());
        System.out.println("---");
    }
}
