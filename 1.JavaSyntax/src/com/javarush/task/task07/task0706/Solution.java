package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] array15 = new int[15];
        int countEvent = 0;
        int countUnEvent = 0;

        for (int i = 0; i < array15.length; i++) {
            array15 [i] = Integer.parseInt(reader.readLine());
            if (i == 0)
                countEvent = countEvent + array15 [i];
            else if (i % 2 == 0)
                countEvent = countEvent + array15 [i];
            else if (i % 2 != 0) countUnEvent = countUnEvent + array15[i];
        }

        if (countEvent > countUnEvent) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");


    }
}
