package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        even = 0;
        odd = 0;

        if (number > 0) {

           for (int i = getCountsOfDigits (number);  0 < i; i--) {
               int d = (int) Math.pow(10, (i - 1));

                if ((number / d)%2 == 0) {

                    number =  number -  (number / d) * d;
                    even++;
                }
                else {
                    number =  number - (number / d) * d;
                    odd++;
                }
            }
           int a = even;
           int b = odd;
            System.out.println("Even: " + a + " Odd: " + b);
        }

    }

    public static int getCountsOfDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
}


