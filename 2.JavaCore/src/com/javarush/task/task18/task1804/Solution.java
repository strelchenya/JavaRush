package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

            int[] byteArray = new int[256];
            while (fileInputStream.available() > 0) {
                byteArray[fileInputStream.read()]++;
            }

            int minValue = 255;
            for (int i = 1; i < byteArray.length; i++) {
                if (minValue > byteArray[i] && byteArray[i] >= 1) minValue = byteArray[i];
            }

            for (int i = 0; i < byteArray.length; i++) {
                if (minValue == byteArray[i]) System.out.print(i + " ");
            }

        } finally {
            reader.close();
        }
    }
}
