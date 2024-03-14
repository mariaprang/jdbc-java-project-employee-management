package org.database.proj.service.impl;


import org.database.proj.model.Department;

import java.util.List;

public interface DepartmentFunctions {

    public void createDepartmentTableIfNotExists();

    public void addDepartment(String departmentId, String departmentTitle, String departmentManager);

    public List<Department> getAllDepartments();

    public void updateDepartment(String departmentId, String departmentTitle, String departmentManager);

    public void deleteDepartment(String departmentId);

    public void dropDepartmentTableIfExists();
}
