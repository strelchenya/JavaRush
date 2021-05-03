package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();


        for (int i = 0; i < 20; i++) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(Integer.parseInt(s));

            Integer x = list.get(i);

            if (x % 3 == 0 && x % 2 != 0) list3.add(x);
            else if (x % 3 != 0 && x % 2 == 0) list2.add(x);
            else if (x % 3 == 0 && x % 2 == 0) {
                list2.add(x);
                list3.add(x);
            }
            else list1.add(x);
        }

        printList(list3);
        printList(list2);
        printList(list1);
    }

    public static void printList(ArrayList<Integer> list) {

        list.forEach(System.out::println);
    }
}
