package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 1)
            throw new RuntimeException();
        if (!(args[0].equals("-e") || args[0].equals("-d"))) return;
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        int[] buffer = new int[fileInputStream.available()];
        switch (args[0]) {
            case "-e":
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = fileInputStream.read() + 1;
                    fileOutputStream.write(buffer[i]);
                }
                fileInputStream.close();
                fileOutputStream.close();
                break;
            case "-d":
                for (int j = 0; j < buffer.length; j++) {
                    buffer[j] = fileInputStream.read() - 1;
                    fileOutputStream.write(buffer[j]);
                }
                fileInputStream.close();
                fileOutputStream.close();
                break;
        }

    }

}
