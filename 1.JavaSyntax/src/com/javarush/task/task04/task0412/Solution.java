package com.javarush.task.task04.task0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительное и отрицательное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberS = reader.readLine();
        int number = Integer.parseInt(numberS);
        if (number > 0) System.out.println(number * 2);
        else if (number < 0) System.out.println(number + 1);
        else System.out.println(number);

    }

}