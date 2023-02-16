package org.designpatterns.creational.lazy_initialization;

public class SquareOfNumber {
    private boolean squared;

    private double num;

    public SquareOfNumber() {
        squared = false;
    }

    public SquareOfNumber(final double num) {
        squared = false;
        this.num = num;
    }


    public void setNum(final double num) {
        this.squared = false;
        this.num = num;
    }

    public double getSquareOfNum() {
        if (!squared) {
            num = Math.pow(num, 2);
            squared = true;
        }

        return num;
    }
}
