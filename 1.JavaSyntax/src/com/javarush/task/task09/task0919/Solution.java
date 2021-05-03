package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try {
            divideByZero();
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
            System.out.println(exception);
        }
    }

    public static void divideByZero() {

        int x = 1;

        int out = x / 0;
        System.out.println(out);

    }
}
