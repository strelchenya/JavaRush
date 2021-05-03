package com.javarush.task.task08.task0817;

import sun.font.CreatedFontTracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String,String> map = new HashMap<>();
        map.put("Петров0", "Петр0");
        map.put("Петров1", "Петр1");
        map.put("Петров2", "Петр2");
        map.put("Петров3", "Петр3");
        map.put("Петров4", "Петр4");
        map.put("Петров5", "Петр1");
        map.put("Петров6", "Петр6");
        map.put("Петров7", "Петр7");
        map.put("Петров8", "Петр8");
        map.put("Петров9", "Петр9");
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        int count = 0;
        Map<String, String> copy = new HashMap<>(map);
        for (String pair : copy.values()) {
            count = 0;
            for (String list: copy.values()) {
                if (list.equals(pair)) {
                    count++;
                }
            }
            if (count >= 2) removeItemFromMapByValue(map, pair);


        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
