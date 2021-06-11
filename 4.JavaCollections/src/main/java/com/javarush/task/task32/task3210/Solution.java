package com.javarush.task.task32.task3210;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        byte[] text = args[2].getBytes(StandardCharsets.UTF_8);

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        raf.seek(number);

        byte[] buffer = new byte[text.length];
        raf.read(buffer, 0, text.length);

        String checkText = "true";

        for (int i = 0; i < text.length; i++) {
            if (text[i] != buffer[i]){
                checkText = "false";
                break;
            }
        }

        byte[] writeCheck = checkText.getBytes(StandardCharsets.UTF_8);
        raf.seek(raf.length());
        raf.write(writeCheck);
        raf.close();
    }
}
