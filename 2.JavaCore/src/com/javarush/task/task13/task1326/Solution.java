package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> numbers = new ArrayList<>();

        String s = null;
        try (BufferedReader inputStreamReader =
                     new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {

            while ((s = inputStreamReader.readLine()) != null) {
             int i = Integer.parseInt(s);
             if (i % 2 == 0) numbers.add(i);
            }

        } catch (RuntimeException e)  {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        Collections.sort(numbers);
        for (Integer i: numbers) System.out.println(i);
    }
}
