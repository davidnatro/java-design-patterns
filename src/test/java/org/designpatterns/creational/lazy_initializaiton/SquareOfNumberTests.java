package org.designpatterns.creational.lazy_initializaiton;

import org.designpatterns.creational.lazy_initialization.SquareOfNumber;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SquareOfNumberTests {
    @Test
    public void setterLazySquareOfNumberTest() {
        SquareOfNumber lazySquareOfNumber = new SquareOfNumber();

        int number = 5;
        int pow = 2;
        lazySquareOfNumber.setNum(number);
        double expectedResult = Math.pow(number, pow);

        Assertions.assertEquals(expectedResult, lazySquareOfNumber.getSquareOfNum());

        number = 7;
        expectedResult = Math.pow(number, pow);
        lazySquareOfNumber.setNum(number);

        Assertions.assertEquals(expectedResult, lazySquareOfNumber.getSquareOfNum());
    }

    @Test
    public void constructorLazySquareOfNumberTest() {
        final int number = 5;
        final int pow = 2;

        SquareOfNumber lazySquareOfNumber = new SquareOfNumber(number);

        final double expectedResult = Math.pow(number, pow);

        Assertions.assertEquals(expectedResult, lazySquareOfNumber.getSquareOfNum());
    }
}
