package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(reader.readLine());
        }
        for (int i = 1; i <= 13; i++) {

            arrayList.add(0, arrayList.get(4));
            arrayList.remove(5);

        }
        for (int i = 0; i < arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
