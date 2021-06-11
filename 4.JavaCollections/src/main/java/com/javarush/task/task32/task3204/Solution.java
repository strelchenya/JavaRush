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



        byte[] base = new byte[10 + 26 + 26];
        int count = 0;
        for (byte i = 48; i <= 122; i++) {
            //диапазон в цифр
            if (i >= 48 && i <= 57) {
                base[count++] = i;
                //диапазон A-Z
            } else if (i >= 65 && i <= 90) {
                base[count++] = i;
                //диапазон a-z
            } else if (i >= 97 && i <= 122) {
                base[count++] = i;
            }
        }

        String passString = "";
        byte[] passwordRandom;

        do {
            passwordRandom = new byte[8];

            for (int i = 0; i < passwordRandom.length; i++) {
                int minRandom = 0;
                int maxRandom = base.length - 1;
                maxRandom -= minRandom;
                int randomNumber = (int) (Math.random() * ++maxRandom) + minRandom;
                passwordRandom[i] = base[randomNumber];
            }

            passString = new String(passwordRandom);
        }
        //проверки на наличие символов
        while (!passString.matches(".*[A-Z].*") ||
                !passString.matches(".*[a-z].*") ||
                !passString.matches(".*\\d.*"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(passwordRandom);

        return baos;
    }
}

/*
    public static byte[] getRandom (byte[] arrayBase){
        byte[] pass = arrayBase;

        byte[] passwordRandom = new byte[8];

        for (int i = 0; i < passwordRandom.length; i++) {
            int minRandom = 0;
            int maxRandom = arrayBase.length;
            maxRandom -= minRandom;
            int randomNumber = (int) (Math.random() * ++maxRandom) + minRandom;
            passwordRandom[i] = arrayBase[randomNumber];
        }

        String passString = new String(passwordRandom);

        if (!passString.matches(".*[A-Z].*")) return getRandom(pass);

        if (!passString.matches(".*[a-z].*")) return getRandom(pass);

        if (!passString.matches(".*\\d.*")) return getRandom(pass);

        return passwordRandom;

    }*/

