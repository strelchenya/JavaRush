package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array20 = new int[20];
        int[] array1 = new int[10];
        int[] array2 = new int[10];

        for (int i = 0; i < array20.length; i++) {
            array20 [i] = Integer.parseInt(reader.readLine());
        }
        array1 = Arrays.copyOfRange(array20, 0, 10);
        array2 = Arrays.copyOfRange(array20, 10, 20);
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2 [i]);

        }


    }
}
