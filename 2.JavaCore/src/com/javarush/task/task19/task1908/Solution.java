package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String nameFile1;
        String nameFile2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            nameFile1 = reader.readLine();
            nameFile2 = reader.readLine();
        }
        String s = "";
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(nameFile1))) {
            while ((s = reader.readLine()) != null) {
                line += s;
            }
        }

        String[] words = line.split(" ");  //  "[\\W|_]"
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile2))) {
            for (String word : words) {
                Pattern pattern = Pattern.compile("^\\d+\\.\\d+$|^\\d+$");
                Matcher matcher = pattern.matcher(word);
                if (matcher.find()) bufferedWriter.write(word + " ");
            }
        }
    }
}
