package com.javarush.task.task35.task3509;

import java.util.*;
import java.util.stream.Stream;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
        HashMap<Object, Number> maps = newHashMap(newArrayList("first", "second"), newArrayList(1,2));
        System.out.println(maps.toString());

    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList <T> arrayList = new ArrayList<>(Arrays.asList(elements));
        return arrayList;
    }

    public static <T> HashSet <T> newHashSet(T... elements) {
        HashSet <T> hashSet = new HashSet<>(Arrays.asList(elements));
        return hashSet;
    }

    public static <K, V> HashMap <K, V> newHashMap(List <? extends K> keys, List <? extends V> values) {
        if (keys.size() != values.size()){
            throw new IllegalArgumentException();
        }
        HashMap<K,V>  hashMap = new HashMap<>(values.size());
        for (int i = 0; i < keys.size(); i++) {
            hashMap.put(keys.get(i), values.get(i));
        }
        return hashMap;
    }
}
