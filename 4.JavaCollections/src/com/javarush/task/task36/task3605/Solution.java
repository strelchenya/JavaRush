package com.javarush.task.task36.task3605;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) {

        TreeSet<String> treeSetCharacter = new TreeSet<>();

        try (FileInputStream fis = new FileInputStream(args[0])) {

            int current;
            while (fis.available() > 0) {
                current = fis.read();
                if ((current >= 65 && current <= 90) || (current >= 97 && current <= 122)) {
                    char symbol = (char) current;
                    treeSetCharacter.add(String.valueOf(symbol).toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int size = 5;
        if (treeSetCharacter.size() < 5) {
            size = treeSetCharacter.size();
        }

        for (int i = 0; i < size; i++) {
            System.out.print(treeSetCharacter.pollFirst());

        }
    }
}
