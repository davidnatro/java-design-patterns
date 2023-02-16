package org.designpatterns.creational.builder;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Employee {
    private int id;
    private String fullName;
    private Position position;
    private String personalData;

    public Employee() { }

    public Employee(final int id, final String fullName, final Position position, final String personalData) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.personalData = personalData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", position=" + position +
                ", personalData='" + personalData + '\'' +
                '}';
    }
}