package org.database.proj.model;

public class Department {
    private String departmentId;
    private String departmentTitle;
    private String departmentManager;

    public Department(String departmentId, String departmentTitle, String departmentManager) {
        this.departmentId = departmentId;
        this.departmentTitle = departmentTitle;
        this.departmentManager = departmentManager;
    }

    public Department(String departmentTitle){
        this.departmentTitle = departmentTitle;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager;
    }

    @Override
    public String toString() {
        return "ID: " + departmentId + '\'' +
                ", department: " + departmentTitle + '\'' +
                ", employeeId: " + departmentManager;
    }
}
