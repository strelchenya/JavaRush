package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как-то средненько
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());

        int max = Math.max((Math.max(number1, number2)), number3);
        int min = Math.min((Math.min(number1, number2)), number3);
        int mid = (number1 + number2 + number3) - (max + min);
        System.out.println(mid);

    }
}
