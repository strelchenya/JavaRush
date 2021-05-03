package com.javarush.task.task16.task1632;

/*
Клубок
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
//        Thread thread1 = new Thread(new Thread1());
        threads.add(new Thread1());
//        Thread thread2 = new Thread(new Thread2());
        threads.add(new Thread2());
//        Thread thread3 = new Thread(new Thread3());
        threads.add(new Thread3());
//        Thread thread4 = new Thread(new Thread4());
        threads.add(new Thread4());
//        Thread thread5 = new Thread(new Thread5());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }


    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }


    public static class Thread3 extends Thread{

        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class Thread4 extends Thread implements Message {

        @Override
        public void run() {
            while (!this.isInterrupted()) {
            }
        }
        @Override
        public void showWarning() {
            this.interrupt();
        }
    }


    public static class Thread5 extends Thread{
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String s;
                int i;
                int count = 0;
                while (!(s = reader.readLine()).equals("N")) {
                    i = Integer.parseInt(s);
                    count = count + i;
                }
                System.out.println(count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
