package org.designpatterns.creational.builder;

public class EmployeeDirector {
    private final EmployeeBuilder employeeBuilder;

    private Employee employee;

    public EmployeeDirector(EmployeeBuilder employeeBuilder) {
        this.employeeBuilder = employeeBuilder;
    }

    public void build() {
        employee = employeeBuilder.buildEmployee();
    }

    public Employee getEmployee() {
        return employee;
    }
}
