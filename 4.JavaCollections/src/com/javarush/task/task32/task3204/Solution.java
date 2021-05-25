package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] base = new byte[10 + 26 + 26];
        int count = 0;
        for (byte i = 48; i <= 122; i++) {
            if (i >= 48 && i <= 57) {
                base[count++] = i;
            } else if (i >= 65 && i <= 90) {
                base[count++] = i;
            } else if (i >= 97 && i <= 122) {
                base[count++] = i;
            }
        }

        byte[] passwordRandom = getRandom(base);

        System.out.println(new String(passwordRandom));
        baos.write(passwordRandom);

        return baos;
    }


    public static byte[] getRandom (byte[] arrayBase){
        byte[] passwordRandom = new byte[8];

        for (int i = 0; i < passwordRandom.length; i++) {
            int minRandom = 0;
            int maxRandom = arrayBase.length;
            maxRandom -= minRandom;
            int randomNamber = (int) (Math.random() * ++maxRandom) + minRandom;
            passwordRandom[i] = arrayBase[randomNamber];
        }

        //проверить на содержание одной цифры, на букву маленькую и большую

        return passwordRandom;

    }
}
