package org.database.proj.util;

import org.database.proj.service.DepartmentService;
import org.database.proj.service.EmployeeService;

public class TestDataUtility {

    public static void runTestData(){
        DepartmentService departmentService = new DepartmentService();
        EmployeeService employeeService = new EmployeeService();

        UtilMethods.dropTables(departmentService, employeeService);
        UtilMethods.createTables(departmentService, employeeService);

        String departmentID = UtilMethods.insertIntoDepartment(departmentService);
        String employeeID = UtilMethods.insertIntoEmployee(employeeService);

        UtilMethods.updateDepartmentTable(departmentService, employeeID, departmentID);

        UtilMethods.getData(departmentService, employeeService);
    }
}
