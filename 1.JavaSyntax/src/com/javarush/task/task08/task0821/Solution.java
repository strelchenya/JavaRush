package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("f1", "i1");
        map.put("f2", "i2");
        map.put("f3", "i3");
        map.put("f4", "i4");
        map.put("f5", "i5");
        map.put("f6", "i2");
        map.put("f7", "i7");
        map.put("f8", "i8");
        map.put("f10", "i9");
        map.put("f10", "i10");

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
