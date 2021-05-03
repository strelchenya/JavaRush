package com.javarush.task.task03.task0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Предсказание на будущее
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String numberS = reader.readLine();
        String numberS2 = reader.readLine();
        int number1 = Integer.parseInt(numberS);
        int number2 = Integer.parseInt(numberS2);
        System.out.println(name + " получает " + number1 + " через " + number2 + " лет.");


    }
}
