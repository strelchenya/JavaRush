package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int i = number / 100;
        int j = (number % 100) / 10;
        int k = (number % 100) % 10;

        return i + j + k;
    }
}