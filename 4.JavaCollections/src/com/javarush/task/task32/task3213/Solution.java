package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null){
            return "";
        }

        BufferedReader br = new BufferedReader(reader);
        byte [] byteLine = br.readLine().getBytes(StandardCharsets.UTF_8);
        br.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteLine.length; i++) {
            sb.append((char) (byteLine[i] + key));
        }

        return sb.toString();
    }
}
