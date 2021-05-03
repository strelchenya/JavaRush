package com.javarush.task.task18.task1808;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String outputFile1 = reader.readLine();
        String outputFile2 = reader.readLine();

        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
             FileOutputStream fileOutputStream1 = new FileOutputStream(outputFile1);
             FileOutputStream fileOutputStream2 = new FileOutputStream(outputFile2)) {
            int available = fileInputStream.available();
            int b1 = (available / 2) + (available % 2);
            int b2 = available - b1;
            byte[] buffer1 = new byte[b1];
            byte[] buffer2 = new byte[b2];
            int count1 = fileInputStream.read(buffer1);
            int count2 = fileInputStream.read(buffer2);
            fileOutputStream1.write(buffer1, 0 , count1);
            fileOutputStream2.write(buffer2, 0, count2);


        }
    }
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String outputFile1 = reader.readLine();
        String outputFile2 = reader.readLine();

        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
             FileOutputStream fileOutputStream1 = new FileOutputStream(outputFile1);
             FileOutputStream fileOutputStream2 = new FileOutputStream(outputFile2)) {

            int halfOfFile = (fileInputStream.available() + 1) / 2;
            int numberOfByte = 0;
            while (fileInputStream.available() > 0) {
                if (numberOfByte < halfOfFile) {
                    fileOutputStream1.write(fileInputStream.read());
                    numberOfByte++;
                } else fileOutputStream2.write(fileInputStream.read());
            }
        }
    }*/

        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
        byte [] buffer1;
        byte [] buffer2;
        if (fileInputStream.available() % 2 != 0) {
            buffer1 = new byte[(fileInputStream.available()- 1)/2 + 1];
            buffer2 = new byte[fileInputStream.available() - buffer1.length];
        }
        else {
            buffer1 = new byte[fileInputStream.available()/2];
            buffer2 = new byte[buffer1.length];
        }
        if (fileInputStream.available() > 0){
            int count1 = fileInputStream.read(buffer1);
            int count2 = fileInputStream.read(buffer2);
            fileOutputStream1.write(buffer1, 0 , count1);
            fileOutputStream2.write(buffer2, 0, count2);
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }*/
}
