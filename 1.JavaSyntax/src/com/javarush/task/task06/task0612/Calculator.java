package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        int c = a + b;
        return c;
    }

    public static int minus(int a, int b) {
        int d = a - b;
        return d;
    }

    public static int multiply(int a, int b) {
        int e = a * b;
        return e;
    }

    public static double division(int a, int b) {
        double d = (double) a / b;
        return d;
    }

    public static double percent(int a, int b) {
        double i = (double) a;
        double k = (double) b;
        double f = i * (k / 100);
        return f;
    }

    public static void main(String[] args) {

    }
}