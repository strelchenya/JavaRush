package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String s = "";
            Map<String, Double> doubleMap = new TreeMap<>();
            while ((s = reader.readLine()) != null) {
             /*   doubleMap.putIfAbsent(s.split(" ")[0], Double.parseDouble(s.split(" ")[1]));
                doubleMap.computeIfPresent(s.split(" ")[0],
                        Double.parseDouble(doubleMap.get(s.split(" ")[0])) + Double.parseDouble(s.split(" ")[1]));*/
                if (doubleMap.containsKey(s.split(" ")[0])) {
                    doubleMap.put(s.split(" ")[0], doubleMap.get(s.split(" ")[0]) +
                            Double.parseDouble(s.split(" ")[1]));
                } else doubleMap.put(s.split(" ")[0], Double.parseDouble(s.split(" ")[1]));
            }
            double max = 0;
            for (Map.Entry<String, Double> item : doubleMap.entrySet()) {
                if (item.getValue() > max) {
                    max = item.getValue();
                }
            }
            for (Map.Entry<String, Double> item : doubleMap.entrySet()) {
                if (item.getValue().equals(max)) {
                    System.out.println(item.getKey());
                }
            }
        }
    }
}
