package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int array[] = new int [5];


        for (int j = 0; j < array.length; j++){
            int number = Integer.parseInt(reader.readLine());
            array [j] = number;
        }
        //System.out.println(array[0] + " " + array[1] + " " + array[2] + " " + array[3] + " " + array[4]);






        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array [i]);
        }

    }
}
