package org.designpatterns.creational.builder;

public interface EmployeeBuilder {
    EmployeeBuilder setId(int id);

    EmployeeBuilder setFullName(String fullName);

    EmployeeBuilder setPosition(Position position);

    EmployeeBuilder setPersonalData(String personalData);

    Employee buildEmployee();
}
