package com.javarush.task.task18.task1803;

/*
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

            int[] byteArray = new int[256];
            while (fileInputStream.available() > 0) {
                byteArray[fileInputStream.read()]++;
            }

            int maxValue = byteArray[0];
            for (int i = 1; i < byteArray.length; i++) {
                    if (byteArray[i] > maxValue) maxValue = byteArray[i];
            }
            for (int i = 0; i < byteArray.length; i++) {
                if (maxValue == byteArray[i]) System.out.print(i + " ");
            }
//            System.out.println(Arrays.toString(byteArray));
        } finally {
            reader.close();
        }

    }
}
