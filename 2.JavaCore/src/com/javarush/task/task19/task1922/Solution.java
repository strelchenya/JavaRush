package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        String nameFile = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            nameFile = reader.readLine();
        }
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
            String s = "";
            while ((s = reader.readLine()) != null) {

                String[] word = s.split(" ");
                for (int i = 0; i < words.size(); i++) {
                    for (int j = 0; j < word.length; j++) {
                        if(words.get(i).equals(word[j])) count++;
                        if (count > 2) break;
                    }
                }

                /*String buffer = s;
                for (int i = 0; i < words.size(); i++) {
                    while (s.contains(words.get(i))) {
                        count++;
                        s = s.substring(words.get(i).length() + s.indexOf(words.get(i)));

                    }
                }*/
                if (count == 2) {
                    System.out.println(s);
                    count = 0;
                } else count = 0;
            }
        }
    }
}
