package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
static {
    map.put(0, "ноль");
    map.put(1, "один");
    map.put(2, "два");
    map.put(3, "три");
    map.put(4, "четыре");
    map.put(5, "пять");
    map.put(6, "шесть");
    map.put(7, "семь");
    map.put(8, "восемь");
    map.put(9, "девять");
    map.put(10, "десять");
    map.put(11, "одиннадцать");
    map.put(12, "двенадцать");
}
    public static void main(String[] args) throws IOException {
        /*if (args.length == 0) {
            args = new String[]{"C:\\Users\\Strelchenya\\Desktop\\Test.txt"};
        }*/
        String fileName = "";
        BufferedReader readerConsol = new BufferedReader(new InputStreamReader(System.in));
        fileName = readerConsol.readLine();
        readerConsol.close();
        String line = "";
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                while ((line = reader.readLine()) != null){
                    text.append(line);
                }
        } catch (IOException e) {
        }
        String result = text.toString();
        for (int i = 12; i >= 0 ; i--) {
            result = result.replaceAll("\\b("+i+")\\b",map.get(i));
        }

        System.out.println(result);
    }
}
