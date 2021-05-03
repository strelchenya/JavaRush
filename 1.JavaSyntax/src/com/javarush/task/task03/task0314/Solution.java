package com.javarush.task.task03.task0314;

/* 
Таблица умножения Ӏ Java Syntax: 3 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
       /*int i = 1;//напишите тут ваш код
       while (i <=10){
           int j = 1;
           while (j <=10){
               System.out.print(i * j + " ");
               j++;
           }
           System.out.println();
           i++;
       }*/
        for (int i = 1; i <=10 ; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}
