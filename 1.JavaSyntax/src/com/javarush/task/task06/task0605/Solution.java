package com.javarush.task.task06.task0605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateMassIndex(weight, height);
    }

    public static class Body {
        public static void calculateMassIndex(double weight, double height) {
            double i = weight / (height * height);
            if (i < 18.5) System.out.println("Недовес: меньше чем 18.5");
            else if (i > 18.5 && i < 25) System.out.println("Нормальный: между 18.5 и 25");
            else if (i > 25 && i < 30) System.out.println("Избыточный вес: между 25 и 30");
            else System.out.println("Ожирение: 30 или больше");
        }
    }
}
