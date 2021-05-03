package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList <String> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(reader.readLine());
        }

        int max = 0;
        int min = arrayList.get(0).length();
        int countMax = 0;
        int countMin = 0;


        for (int i = 1; i < arrayList.size(); i++) {
            if (min > arrayList.get(i).length()) {
                min = arrayList.get(i).length();
            }
        }


        for (int i = 0; i < arrayList.size(); i++) {
            if (max < arrayList.get(i).length()){
                max = arrayList.get(i).length();
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (max != arrayList.get(i).length()) {
                countMax++;

            }
            else {
                //countMax++;
                break;
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (min != arrayList.get(i).length()) {
                countMin++;

            }
            else {
                //countMin++;
                break;
            }
        }
        if (countMax < countMin){
            System.out.println(arrayList.get(countMax));
        }
        else System.out.println(arrayList.get(countMin));


    }
}
