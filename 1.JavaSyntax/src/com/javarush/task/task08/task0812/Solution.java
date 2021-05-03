package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //ArrayList<Integer> list = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int count = 1;
        int countN = 1;

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));

                if (i > 0 && list.get(i).equals(list.get(i - 1)))
                    count++;
                else count = 1;

                if (count > countN) {
                    countN = count;

                }

            }

        System.out.println(countN);

    }
}
