package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int maxLength = 0;
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars.size() > maxLength) {
                maxLength = chars.size();
            }
            chars.clear();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!chars.contains(c)) {
                    chars.add(c);
                } else {
                    break;
                }
            }
        }
        return chars.size() > maxLength ? chars.size() : maxLength;
    }

    /*public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        int countNext = 0;
        int start = 0;
        int end = 0;

        char[] array = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (characters.size() == 0) {
                characters.add(array[i]);
                start = i;
                continue;
            }
            if (characters.contains(array[i])) {
                end = i;
                countNext = end - start;
                if (countNext > count){
                    count = countNext;
                }
                characters.clear();
                if (end - start < 2){
                    i = s.indexOf(array[i], start + 1);
                    continue;
                }
                i = s.indexOf(array[i]);
                continue;
            }
            characters.add(array[i]);
            countNext = characters.size();
            if (countNext > count){
                count = countNext;
            }
        }

        return count;
    }*/
}
