package org.designpatterns.creational.builder;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BuilderTests {
    @Test
    public void builderTest() {
        EmployeeBuilder employeeBuilder = new CustomEmployeeBuilder();

        final int id = 1;
        final String fullName = "Name";
        final Position position = Position.Programmer;
        final String personalData = "Data";

        Employee constructorBuiltEmployee = new Employee(id, fullName, position, personalData);

        Employee builderBuiltEmployee = employeeBuilder
                .setId(id)
                .setFullName(fullName)
                .setPosition(position)
                .setPersonalData(personalData)
                .buildEmployee();

        Employee nullEmployee = employeeBuilder.setId(id).buildEmployee();

        Assertions.assertEquals(constructorBuiltEmployee, builderBuiltEmployee);
        Assertions.assertNotSame(constructorBuiltEmployee, builderBuiltEmployee);
        Assertions.assertNull(nullEmployee);
    }
}