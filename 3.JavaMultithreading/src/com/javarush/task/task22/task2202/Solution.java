package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
//        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java. Амиго и Диего лучшие друзья!"));
//        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
//        System.out.println(getPartOfString("Амиго друзья!"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.length() < 2 || !string.contains(" ")) throw new TooShortStringException();
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = string.split(" ");
        if (words.length < 5) throw new TooShortStringException();
        if (words.length > 5) {
            for (int i = 1; i < 5; i++) {
                stringBuilder.append(words[i])
                        .append(" ");
            }
        } else if (words.length < 6){
            for (int i = 1; i < words.length; i++) {
                stringBuilder.append(words[i])
                        .append(" ");
            }
        }

//            return string.substring(string.indexOf(" "));
        return stringBuilder.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
