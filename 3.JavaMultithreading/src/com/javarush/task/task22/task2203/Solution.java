package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
//            return null;
        }
        String line = string;
        int count = 0;
        while (line.contains("\t")) {
            count++;
            line = line.substring(line.indexOf("\t") + 1);
        }
        if (count < 2 || string == null) throw new TooShortStringException();
        return string.split("\t")[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
