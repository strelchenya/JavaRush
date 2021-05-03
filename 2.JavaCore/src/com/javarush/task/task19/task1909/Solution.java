package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена знаков
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

                Pattern pattern = Pattern.compile("\\."); //"\\.\\s|.\\.$"
                Matcher matcher = pattern.matcher(line);
                String newLine = matcher.replaceAll("!");
                bufferedWriter.write(newLine);
            }
        }
    }
}
