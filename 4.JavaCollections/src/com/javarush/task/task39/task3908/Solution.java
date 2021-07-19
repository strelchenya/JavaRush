package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("123321"));

    }


    /*public static boolean isPalindromePermutation(String s) {
        boolean foundOdd = false;
        int[] tableCount = new int[256];

        for (char c : s.toLowerCase().toCharArray()) {
            tableCount[c] += 1;
        }

        for (int count : tableCount) {
            if (count % 2 != 0) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }*/

    public static boolean isPalindromePermutation(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
