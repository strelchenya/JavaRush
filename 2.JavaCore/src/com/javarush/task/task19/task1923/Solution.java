package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        /*if (args.length == 0) {
            args = new String[]{"C:\\Users\\Strelchenya\\Desktop\\Test.txt", "C:\\Users\\Strelchenya\\Desktop\\Test1.txt"};
        }*/
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            String s = "";
            while ((s = reader.readLine()) != null){
                String [] words = s.split(" ");
                for (String word: words) {
                    if (word.matches(".*[0-9]+.*")) { //".+[0-9].+" регекс от Вали и он не всегжа работает
                        writer.write(word + " ");
//                        System.out.println(word + " ");
                    }
                }
            }
        }
    }
}
