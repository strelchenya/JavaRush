package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayList.add(reader.readLine());
        }

        int min = arrayList.get(0).length();
        for (int i = 1; i < arrayList.size(); i++) {
            if (min > arrayList.get(i).length()){
                min = arrayList.get(i).length();
            }


        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (min == arrayList.get(i).length()){
                System.out.println(arrayList.get(i));
            }
        }
    }
}
