package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!((s = reader.readLine()).equals("exit"))) {
            try {
                int i = Integer.parseInt(s);
                if (i > 0 && i < 128) {
                    print((short) i);
                } else print(i);
            } catch (NumberFormatException e) {
                try {
                    print(Double.parseDouble(s));
                } catch (NumberFormatException ee) {
                    print(s);
                }
            }
        }


        /*String s;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (!(s = reader.readLine()).equals("exit")){
                if (s.indexOf('.') != -1) print(Double.parseDouble(s));
                else if ((Integer.parseInt(s)) > 0 && (Integer.parseInt(s)) < 128)
                    print(*//*(short)*//* (Short.parseShort(s)));
                else if ((Integer.parseInt(s)) <= 0 | (Integer.parseInt(s)) > 128)
                    print(Integer.parseInt(s));
                else print(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
    public static void print (Double value){
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print (String value){
        System.out.println("Это тип String, значение " + value);
    }

    public static void print ( short value){
        System.out.println("Это тип short, значение " + value);
    }

    public static void print (Integer value){
        System.out.println("Это тип Integer, значение " + value);
    }
}