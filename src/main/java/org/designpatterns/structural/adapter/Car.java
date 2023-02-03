package org.designpatterns.structural.adapter;

public class Car implements Movable{
    @Override
    public String move() {
        return "Car moving...";
    }
}
