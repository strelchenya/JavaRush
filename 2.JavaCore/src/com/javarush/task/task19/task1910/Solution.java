package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Пунктуация
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
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile2))) {

                Pattern pattern = Pattern.compile("\\p{Punct}"); //[-.?!)(,:]   "\\n|\\W"
                Matcher matcher = pattern.matcher(line);
                String newLine = matcher.replaceAll("");
                bufferedWriter.write(newLine);
            }
        }
    }
}
