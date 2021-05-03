package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("С1", 500);
        map.put("С2", 200);
        map.put("С3", 1400);
        map.put("С4", 300);
        map.put("С5", 2200);
        map.put("С6", 2300);
        map.put("С7", 500);
        map.put("С8", 600);
        map.put("С9", 5100);
        map.put("С10", 10);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>(map);
        int x;
        for (Map.Entry<String, Integer> number: copy.entrySet()
             ) {
            x = number.getValue();
            if(x < 500) map.remove(number.getKey());
        }

        // map.values().removeIf(v -> v < 500);
    }

    public static void main(String[] args) {

    }
}