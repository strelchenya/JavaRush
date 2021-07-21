package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/


public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("letter", "letter"));
        System.out.println(isOneEditAway("leTTer", "letter"));
        System.out.println(isOneEditAway("leter", "letter"));
        System.out.println(isOneEditAway("letterA", "letterB"));
        System.out.println(isOneEditAway("letterA", "letter"));
        System.out.println(isOneEditAway("letter", "letterB"));
        System.out.println(isOneEditAway("letter", "letterBB"));
        System.out.println(isOneEditAway("leTter", "letterB"));
        System.out.println(isOneEditAway("A", "B"));
        System.out.println(isOneEditAway("A", ""));
        System.out.println(isOneEditAway("", ""));
    }

    public static boolean isOneEditAway(String first, String second) {
        int lengthDifference = first.length() - second.length();

        if (lengthDifference == 0) {
            return checkReplacement(first, second);
        } else if (lengthDifference == 1) {
            return checkInsertion(first, second);
        } else if (lengthDifference == -1) {
            return checkInsertion(second, first);
        } else {
            return false;
        }
    }

    private static boolean checkReplacement(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                } else {
                    foundDifference = true;
                }
            }
        }
        return true;
    }

    private static boolean checkInsertion(String first, String second) {
        int i = 0;
        int j = 0;

        while (j < second.length() && i < first.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                if (i != j) {
                    return false;
                }
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;

    }
}
