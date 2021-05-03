package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameFile = ""; //String nameFile = "C:\\Users\\Strelchenya\\Desktop\\Test.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            nameFile = reader.readLine();
            }

        try (BufferedReader readerFile = new BufferedReader(new FileReader(nameFile))) {
            String line = "";
            while ((line = readerFile.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder(line);
                System.out.println(stringBuilder.reverse());
            }
        }
    }
}
