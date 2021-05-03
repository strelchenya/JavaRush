package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
       private String name;
        private int age;
        private boolean sex;
        private int weight;  //масса
        private int height;     //высота
        private int iq;

        public Human(String name, int age, boolean sex, int weight, int height, int iq) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
            this.iq = iq;
        }

        public Human(String name, int age, boolean sex, int weight, int height) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        public Human(String name, int age, boolean sex, int weight) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(int age, boolean sex, int weight, int height, int iq) {

            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.height = height;
            this.iq = iq;
        }

        public Human(boolean sex, int weight, int height, int iq) {
            this.sex = sex;
            this.weight = weight;
            this.height = height;
            this.iq = iq;
        }

        public Human(int weight, int height, int iq) {
            this.weight = weight;
            this.height = height;
            this.iq = iq;
        }

        public Human(int height, int iq) {
            this.height = height;
            this.iq = iq;
        }

    }
}
