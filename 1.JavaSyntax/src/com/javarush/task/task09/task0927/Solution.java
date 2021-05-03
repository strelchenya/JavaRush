package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {

        HashMap<String, Cat> map = new HashMap<String, Cat>();
        for (int i = 0; i < 10; i++) {
            String Catty = "Cat" + i;
            map.put(Catty, new Cat(Catty));
        }
        return map;

        /*Map<String, Cat> map = new HashMap<>();
        map.put("Барсик", new Cat("Барсик"));
        map.put("Иванович", new Cat("Иванович"));
        map.put("Михайлович", new Cat("Михайлович"));
        map.put("Пуся", new Cat("Пуся"));
        map.put("Муся", new Cat("Муся"));
        map.put("Пушок", new Cat("Пушок"));
        map.put("Снежинка", new Cat("Снежинка"));
        map.put("Валенок", new Cat("Валенок"));
        map.put("Нервяша", new Cat("Нервяша"));
        map.put("Неадеквяша", new Cat("Неадеквяша"));
        return map;*/
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
