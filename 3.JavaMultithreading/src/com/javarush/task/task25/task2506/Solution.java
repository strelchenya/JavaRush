package com.javarush.task.task25.task2506;

/* 
Мониторинг состояния нити
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); //NEW
        System.out.println(loggingStateThread.getState());
        Thread.sleep(100);
        target.start();  //RUNNABLE
        System.out.println(loggingStateThread.getState());
        Thread.sleep(100);
        System.out.println(loggingStateThread.getState());
        //TERMINATED
    }
}
