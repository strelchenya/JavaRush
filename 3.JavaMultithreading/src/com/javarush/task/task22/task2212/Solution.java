package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        /*if (telNumber == null || telNumber.isEmpty()) return false;
        int digitsNumberPhone = telNumber.replaceAll("\\D", "").length();
        if (digitsNumberPhone == 10 && telNumber.charAt(0) != '+' ||
                (digitsNumberPhone == 12 && telNumber.charAt(0) == '+')) {
            return telNumber.matches("(\\+\\d+)?\\d*(\\(\\d{3}\\))?\\d+(-?\\d+){0,2}");
        } else return false;*/
        return telNumber != null && telNumber.matches
                ("^(\\+(?=(\\D?\\d){12}$)|(?=(\\D?\\d){10}$))\\d*(\\(\\d{3}\\))?(\\d+-){0,2}\\d+$");

    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("(050)123456"));


    }
}
