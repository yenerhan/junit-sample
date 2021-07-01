package com.yener.testproject.basic.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FizzBuzzTest {

    private static FizzBuzz fizzBuzz;

    @BeforeAll
    static void setUp(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void returnFizzWhenTheNumberIsDividedByThree() {
        assertEquals("Fizz", fizzBuzz.getStringFor(3));
    }

    @Test
    public void returnBuzzWhenTheNumberIsDividedByFive() {
        assertEquals("Buzz", fizzBuzz.getStringFor(5));
    }

    @Test
    public void returnFizzBuzzWhenTheNumberIsDividedBothOfThreeAndFive() {
        assertEquals("FizzBuzz", fizzBuzz.getStringFor(15));
    }

    @Test
    public void returnFizzBuzzWhenTheNumberIsNotDividedAnyThreeAndFive() {
        assertEquals("7", fizzBuzz.getStringFor(7));
    }

    @Test
    public void throwsIllegalArgumentExceptionWhenTheNumberIsLessThanOneOrGreaterThanHundred() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> fizzBuzz.getStringFor(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> fizzBuzz.getStringFor(101));
    }
}
