package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        int max = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (max < strings.get(i).length()){
                max = strings.get(i).length();
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            if (max == strings.get(i).length()) {
                System.out.println(strings.get(i));
            }
        }





        /*for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                if (strings.get(i).length() < strings.get(j).length()){
                    String k = strings.get(i);
                    strings.set(i, strings.get(j));
                    strings.set(j, k);
                }
            }

        }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(0).length() == strings.get(i).length()){
                System.out.println(strings.get(i));
            }
        }*/
    }
}
