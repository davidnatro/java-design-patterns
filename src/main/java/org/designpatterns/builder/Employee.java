package org.designpatterns.builder;

public class Employee {
    private int id;
    private String fullName;
    private Position position;
    private String personalData;

    // Employee(int id, String fullName, Position position) { }

    // Employee(int id, String fullName, Position position, String personalData) { }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPosition(Position position) {
        this.position = position;
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