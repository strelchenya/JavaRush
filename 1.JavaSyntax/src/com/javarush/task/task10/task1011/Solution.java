package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String text = "Я не хочу изучать Java, я хочу большую зарплату";

        for (int i = 0; i < 40; i++) {
            System.out.println(text);
            text = text.substring(1);
        }


        /*StringBuilder stringBuilder = new StringBuilder(text);
        System.out.println(stringBuilder);
        for (int i = 0; i < 39; i++) {
            System.out.println(stringBuilder.delete(0, 1));
        }*/

    }

}

