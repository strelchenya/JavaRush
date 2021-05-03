package com.javarush.task.task18.task1819;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream fileInputStream1 = new FileInputStream(fileName1);
             FileInputStream fileInputStream2 = new FileInputStream(fileName2)) {

            while (fileInputStream2.available() > 0) {
                byteArrayOutputStream.write(fileInputStream2.read());
            }
            while (fileInputStream1.available() > 0) {
                byteArrayOutputStream.write(fileInputStream1.read());
            }
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1)) {
            byteArrayOutputStream.writeTo(fileOutputStream);
        }
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(nameFile1);
        byte[] buffer = new byte[fileInputStream.available()];
        while (fileInputStream.available() > 0){
            fileInputStream.read(buffer);
        }
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(nameFile1);
        FileInputStream fileInputStream2 = new FileInputStream(nameFile2);
        while (fileInputStream2.available() > 0){
            fileOutputStream.write(fileInputStream2.read());
        }
        for (int i = 0; i < buffer.length; i++) {
            fileOutputStream.write(buffer[i]);
        }
        fileOutputStream.close();
        fileInputStream2.close();*/
    }
}
