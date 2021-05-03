package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameFile;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            nameFile = reader.readLine();
        }
        int count = 0;
        String line = "";
        try (FileReader fileReader = new FileReader(nameFile)) {
            while (fileReader.ready()) {
                line += (char) fileReader.read();
            }
            String replacedString = line.replaceAll("\\p{P}", " ").replaceAll("\\s", " ");
            String[] words = replacedString.split(" ");
            for (String word : words) {
                if (word.equals("world")) count++;
            }
            System.out.println(count);
        }
    }
}
