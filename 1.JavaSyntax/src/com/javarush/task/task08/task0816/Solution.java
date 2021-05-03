package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов0", dateFormat.parse("MAY 1 2012"));
        map.put("Смирнов1", dateFormat.parse("MAY 1 2011"));
        map.put("Смирнов2", dateFormat.parse("MAY 4 2010"));
        map.put("Смирнов3", dateFormat.parse("MAY 1 2009"));
        map.put("Смирнов4", dateFormat.parse("MAY 5 2008"));
        map.put("Смирнов5", dateFormat.parse("JUNE 1 2007"));
        map.put("Смирнов6", dateFormat.parse("MAY 4 2010"));
        map.put("Смирнов7", dateFormat.parse("JULY 1 2011"));
        map.put("Смирнов8", dateFormat.parse("MAY 3 2000"));
        map.put("Смирнов9", dateFormat.parse("MAY 2 2013"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Map<String, Date> copy = new HashMap<>(map);
        for (String key : copy.keySet()) {
            Date date = copy.get(key);
            int month = date.getMonth() + 1;
            if (month == 6 || month == 7 || month == 8) {
                map.remove(key);
            }
        }
        //map.values().removeIf(v -> v.getMonth() > 4 && v.getMonth() < 8);
    }

    public static void main(String[] args){

    }
}
