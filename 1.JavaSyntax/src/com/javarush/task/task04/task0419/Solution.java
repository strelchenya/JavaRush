package com.javarush.task.task04.task0419;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Максимум четырех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());
        int number4 = Integer.parseInt(reader.readLine());


        int n1;
        if (number1 >= number2){
            n1 = number1;
        }
        else n1 = number2;
        if (n1 <= number3){
            n1 = number3;
        }
        if (n1 <= number4){
            n1 = number4;
        }
        System.out.println(n1);
    }
}
