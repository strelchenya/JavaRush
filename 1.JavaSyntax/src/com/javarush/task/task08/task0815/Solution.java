package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("f1", "L1");
        map.put("f2", "L2");
        map.put("f3", "L3");
        map.put("f4", "L4");
        map.put("f5", "L5");
        map.put("f6", "L6");
        map.put("f7", "L1");
        map.put("f8", "L8");
        map.put("f9", "L1");
        map.put("f10", "L10");
        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for (String fistName: map.values()){
            if (fistName.equals(name)) count++;
        }
            return count;


    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        for (String lastNameN: map.keySet()){
            if (lastNameN.equals(lastName)) count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
