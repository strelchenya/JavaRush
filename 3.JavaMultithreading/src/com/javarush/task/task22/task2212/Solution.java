package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) return false;
            Pattern pattern = Pattern.compile("^(\\+|\\d)\\d{1,2}(\\(\\d{3}\\)|\\d{3}|((-|\\d)?))(-|\\d){7}($|\\d\\d)?");
            Matcher matcher = pattern.matcher(telNumber);
        return matcher.find();
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("eggeherh3"));

    }
}
