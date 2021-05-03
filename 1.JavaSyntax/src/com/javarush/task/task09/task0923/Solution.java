package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        /* ---------------МОЁ РЕШЕНИЕ----------------------
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
         */
        /*char[] array = s.toCharArray();
        ArrayList<Character> arrayVowels = new ArrayList<>();
        ArrayList<Character> arrayConsonant = new ArrayList<>();

        for (char next : array) {

            if (isVowel(next)) {
                arrayVowels.add(next);
                arrayVowels.add(' ');
            } else {

                if (next != ' ') {
                    arrayConsonant.add(next);
                    arrayConsonant.add(' ');
                } //else arrayConsonant.add(next);
            }
        }
        for (char input : arrayVowels) {
            System.out.print(input);
        }
        System.out.println();
        for (char input : arrayConsonant) {
            System.out.print(input);
        }
        ------------------------------------------------*/

        /*---------------РЕШЕНИЕ ВАЛИДАТОРА_______________
        String string = reader.readLine();

        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        for (char character : string.toCharArray()) {
            if (isVowel(character)) {
                buffer1.append(character).append(" ");
            } else if (character != ' ') {
                buffer2.append(character).append(" ");
            }
        }

        System.out.println(buffer1);
        System.out.println(buffer2);
}
        __________________________________________________ */

        String s = new BufferedReader(new InputStreamReader(System.in)).readLine().replace(" ", "");
        String a = "", b = "";

        for (Character ch : s.toCharArray()) {
            if (isVowel(ch)) {
                a += ch + " ";//напишите тут ваш код
            } else {
                b += ch + " ";
            }
        }
        System.out.println(a);
        System.out.println(b);
    }




    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}