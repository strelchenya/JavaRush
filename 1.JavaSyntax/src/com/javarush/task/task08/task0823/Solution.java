package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    /*public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String string = reader.readLine();
        char[] array = string.toCharArray();

        String strings = "";
        for (int i = 0; i < array.length; i++) {
           // if (i == 0 && array[i] != 32) array[i] -= 32;
            //else if(i != 0 && array[i] == 32) array[i + 1] -= 32;
            char character = (i == 0 || array[i - 1] == ' ') ? Character.toUpperCase(array[i]) : array[i];
            strings += character;

        }


        System.out.print(strings);
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        char[] chs = str.toCharArray();

        chs[0] = Character.toUpperCase(chs[0]);
        for (int i = 0; i < chs.length - 1; i++) {
            if (chs[i] == ' '){
                chs[i + 1] = Character.toUpperCase(chs[i + 1]);
            }
        }


      /*  //вывод посимвольно
        for (int i = 0; i < chs.length; i++) {
            System.out.print(chs[i]);
        }*/

        //вывод целой строки
        String result = "";
        for (int i = 0; i < chs.length; i++) {
            result += chs[i];
        }
        System.out.println(result);

    }

}
