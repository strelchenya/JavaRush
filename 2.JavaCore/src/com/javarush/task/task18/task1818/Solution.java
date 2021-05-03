package com.javarush.task.task18.task1818;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        String nameFile3 = reader.readLine();

        try(FileOutputStream writer = new FileOutputStream(nameFile1);
            FileInputStream reader1 = new FileInputStream(nameFile2);
            FileInputStream reader2 = new FileInputStream(nameFile3)) {
            while (reader1.available() > 0){
                int buffer = reader1.read();
                writer.write(buffer);
            }
            while (reader2.available() > 0){
                int buffer = reader2.read();
                writer.write(buffer);
            }
        }
        reader.close();
    }
}
