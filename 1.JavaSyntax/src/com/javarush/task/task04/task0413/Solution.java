package com.javarush.task.task04.task0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
День недели
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberS = reader.readLine();
        int number = Integer.parseInt(numberS);
        if (number == 1) System.out.println("понедельник");
        else if (number == 2) System.out.println("вторник");
        else if (number == 3) System.out.println("среда");
        else if (number == 4) System.out.println("четверг");
        else if (number == 5) System.out.println("пятница");
        else if (number == 6) System.out.println("суббота");
        else if (number == 7) System.out.println("воскресенье");
        else if (number > 7 | number < 1) System.out.println("такого дня недели не существует");

    }
}