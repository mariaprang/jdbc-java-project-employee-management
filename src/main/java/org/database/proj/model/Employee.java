package org.database.proj.model;

public class Employee {

    private String employeeId;

    private String fullName;

    private double salary;

    private Department department;


    public Employee(String employeeId, String fullName, double salary, Department department) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + '\'' +
                ", name ='" + fullName + '\'' +
                ", salary=" + salary +
                " \n\t\t DEPARTMENT: \n\t\t\t" + department + '\'' +
                '}';
    }
}
