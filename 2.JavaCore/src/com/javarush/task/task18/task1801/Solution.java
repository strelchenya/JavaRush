package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/*
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())){
            int maxByte = 0;
            int value = 0;
            if (fileInputStream.available() > 0) maxByte = fileInputStream.read();
            while (fileInputStream.available() > 0) {
                if ((value = fileInputStream.read()) > maxByte) maxByte = value;
            }
            System.out.println(maxByte);
        }finally {
            reader.close();
        }
    }
}
