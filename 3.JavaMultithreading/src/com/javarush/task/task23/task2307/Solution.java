package com.javarush.task.task23.task2307;

/* 
Как выбрать нужное?
*/

public class Solution {
    public static final String TEST = "test";
    static Object obj;



    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }
    public static void main(String[] args) {

        obj = new TEST();

        System.out.println(obj);
    }
}
