package org.designpatterns.builder;

import java.util.Objects;

public class CustomEmployeeBuilder implements EmployeeBuilder {
    private int id = 0;
    private String fullName;
    private Position position;
    private String personalData;

    @Override
    public EmployeeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public EmployeeBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public EmployeeBuilder setPosition(Position position) {
        this.position = position;
        return this;
    }

    @Override
    public EmployeeBuilder setPersonalData(String personalData) {
        this.personalData = personalData;
        return this;
    }

    @Override
    public Employee build() {
        if (id == 0 || fullName == null || position == null) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId(id);
        employee.setFullName(fullName);
        employee.setPosition(position);
        employee.setPersonalData(Objects.requireNonNullElse(personalData, "No data"));

        return employee;
    }
}
