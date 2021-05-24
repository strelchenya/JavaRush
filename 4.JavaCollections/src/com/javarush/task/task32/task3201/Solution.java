package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        byte[] text = args[2].getBytes(StandardCharsets.UTF_8);

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        long length = raf.length();
        if ((length - number) < text.length) {
            raf.seek(length);
            raf.write(text);
            raf.close();
        }
        raf.seek(number);
        raf.write(text);
        raf.close();
    }
}
