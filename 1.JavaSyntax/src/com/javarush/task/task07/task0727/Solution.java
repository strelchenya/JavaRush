package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();
        while (true) {
            String string = reader.readLine();
            if (string == null || string.isEmpty()) break;
            strings.add(string);
        }

        ArrayList<String> resultStrings = new ArrayList<String>();
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() % 2 == 0) {
                for (int j = 0; j < 2; j++) {
                    resultStrings.add(strings.get(i));

                }

            }

            if (strings.get(i).length() % 2 != 0) {
                for (int j = 0; j < 3; j++) {
                    resultStrings.add(strings.get(i));
                }

            }

        }

        /*ArrayList<String> resultStrings = new ArrayList<String>();
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            resultStrings.add(string.toUpperCase());
        }*/

        for (int i = 0; i < resultStrings.size(); i++) {
            if (resultStrings.get(i).length() % 2 == 0){
                System.out.print(resultStrings.get(i) + " ");
                System.out.println(resultStrings.get(i+1));
                i++;
            }
            if (resultStrings.get(i).length() % 2 != 0){
                System.out.print(resultStrings.get(i) + " ");
                System.out.print(resultStrings.get(i+1) + " ");
                System.out.println(resultStrings.get(i+2));
                i++;
                i++;
            }



        }
    }
}
