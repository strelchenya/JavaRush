package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> setGetIds = new HashSet<>();
        for (String s: strings) {
          setGetIds.add(shortener.getId(s));
        }
        return setGetIds;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> setGetString = new HashSet<>();
        for (Long id: keys) {
            setGetString.add(shortener.getString(id));
        }
        return setGetString;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){

    }
}
