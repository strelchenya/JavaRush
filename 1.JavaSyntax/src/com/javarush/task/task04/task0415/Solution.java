package com.javarush.task.task04.task0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Правило треугольника
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int triangle1 = Integer.parseInt(reader.readLine());
        int triangle2 = Integer.parseInt(reader.readLine());
        int triangle3 = Integer.parseInt(reader.readLine());
        if ((triangle1 + triangle2) > triangle3 & (triangle2 + triangle3) > triangle1 &
                (triangle3 + triangle1) > triangle2) System.out.println("Треугольник существует.");
        else System.out.println("Треугольник не существует.");


    }
}