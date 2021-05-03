package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик", 1, 2, 3);
        Cat zver = new Cat("Зверь", 2, 5, 10);
        Cat n9shka = new Cat("Няшка", 3, 1, 1);
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}