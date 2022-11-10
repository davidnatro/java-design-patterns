package org.designpatterns.builder;

public class EmployeeDirector {
    private final EmployeeBuilder employeeBuilder;

    private Employee employee;

    public EmployeeDirector(EmployeeBuilder employeeBuilder) {
        this.employeeBuilder = employeeBuilder;
    }

    public void build() {
        employee = employeeBuilder.build();
    }

    public Employee getEmployee() {
        return employee;
    }
}
