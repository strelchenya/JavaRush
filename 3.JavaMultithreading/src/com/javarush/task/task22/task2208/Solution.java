package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(map);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
//            Map<String, String> mapLink = new LinkedHashMap<>();
        StringBuilder st = new StringBuilder();
        for (Map.Entry<String, String> map : params.entrySet()) {
            if (map.getValue() != null) {
                st.append(map.getKey() + " = '" + map.getValue() + "' and ");
            }
        }
        String map = "";
        if (st.length() != 0){
            map = st.substring(0, st.lastIndexOf(" and "));
        }

        return map;
    }
}
