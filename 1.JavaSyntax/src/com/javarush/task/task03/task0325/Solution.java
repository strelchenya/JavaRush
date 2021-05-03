package com.javarush.task.task03.task0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        int nN = Integer.parseInt(n);
        System.out.println("Я буду зарабатывать $" + nN + " в час");


    }
}
