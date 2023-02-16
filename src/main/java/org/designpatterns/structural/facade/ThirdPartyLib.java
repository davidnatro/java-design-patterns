package org.designpatterns.structural.facade;

public class ThirdPartyLib {
    private final static int maxValue = 99;
    private final static int minValue = 0;

    private static int generateRandomNumber() {
        return (int) ((Math.random() * (maxValue - minValue)) + minValue);
    }

    public void method1() {
        System.out.println("method 1");
    }

    public int method2() {
        System.out.println("method 2");
        return generateRandomNumber();
    }

    public String method3() {
        return "method 3";
    }
}
