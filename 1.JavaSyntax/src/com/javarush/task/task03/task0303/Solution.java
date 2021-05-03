package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(100, 1.5));
        System.out.println(convertEurToUsd(200, 0.5));

        //напишите тут ваш код

    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
        double x = eur * exchangeRate;

        return x;
        //напишите тут ваш код

    }
}
