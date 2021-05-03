package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{

        public GenerateThread(){
            super(String.valueOf(++createdThreadCount));
//            createdThreadCount++;
            start();
        }

        @Override
        public void run() {
//            super.run();
            if (createdThreadCount < count){
                System.out.println(new GenerateThread());

            }
        }

        public String toString() {
            return getName() + " created";
//            return (Integer.parseInt(getName()) + 1) + " created";
        }

    }
}
