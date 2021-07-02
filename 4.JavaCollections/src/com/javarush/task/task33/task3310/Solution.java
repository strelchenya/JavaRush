package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 10000);

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> setGetIds = new HashSet<>();
        for (String s : strings) {
            setGetIds.add(shortener.getId(s));
        }
        return setGetIds;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> setGetString = new HashSet<>();
        for (Long id : keys) {
            setGetString.add(shortener.getString(id));
        }
        return setGetString;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());

        Set<String> strings = new HashSet<>();
        Set<Long> keys = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
            keys.add((long) i);
        }

        Shortener shortener = new Shortener(strategy);

        Date dateGetIds1 = new Date();
        Set<Long> getKey = getIds(shortener, strings);
        Date dateGetIds2 = new Date();
        System.out.println(dateGetIds2.getTime() - dateGetIds1.getTime());

        Date dateGetStrings1 = new Date();
        Set<String> getString = getStrings(shortener, keys);
        Date dateGetStrings2 = new Date();
        System.out.println(dateGetStrings2.getTime() - dateGetStrings1.getTime());

        if (getString.size() == strings.size()) {
            System.out.println("Тест пройден.");
        }else {
            System.out.println("Тест не пройден.");
        }

    }
}
