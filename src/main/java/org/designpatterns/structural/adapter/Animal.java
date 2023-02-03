package org.designpatterns.structural.adapter;

public class Animal implements Movable {

    @Override
    public String move() {
        return "Animal moving...";
    }
}
