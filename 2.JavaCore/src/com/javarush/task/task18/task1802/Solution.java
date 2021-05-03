package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int min = 255;
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (min > data) min = data;
        }
        reader.close();
        fileInputStream.close();
        System.out.println(min);
    }
}
