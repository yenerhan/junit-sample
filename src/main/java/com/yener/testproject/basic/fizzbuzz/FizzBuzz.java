package com.yener.testproject.basic.fizzbuzz;

public class FizzBuzz {

    public String getStringFor(int sayi) {

        if (sayi > 100 || sayi < 1) {
            throw new IllegalArgumentException();
        }

        if (sayi % 15 == 0) {
            return "FizzBuzz";
        } else if (sayi % 3 == 0) {
            return "Fizz";
        } else if (sayi % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(sayi);
    }
}
