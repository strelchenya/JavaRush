package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
       ArrayList<String> [] aS = new ArrayList[3];
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list1.add("omg1" + i);
        }
        for (int i = 0; i < 4; i++) {
            list2.add("omg2" + i);
        }
        for (int i = 0; i < 4; i++) {
            list3.add("omg3" + i);
        }
        aS [0] = list1;
        aS [1] = list1;
        aS [2] = list1;
        return aS;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String string : list) {
                System.out.println(string);
            }
        }
    }
}