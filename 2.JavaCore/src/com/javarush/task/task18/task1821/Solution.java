package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {


            String fileName = args[0];
            int[] array = new int[256];
//            String fileName = "C:\\Test.txt";

            FileInputStream fis = new FileInputStream(fileName);
            while (true){
                int byteFromFile =  fis.read();
                if (byteFromFile == -1){
                    //конец файла
                    break;
                }
                array[byteFromFile]++;
            }
            fis.close();

            for (int i = 0; i < 255; i++) {
                if (array[i] != 0){
                    System.out.println((char)i + " " + array[i]);
                }
            }
        }
    }
/*
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] counts = new int[256];
        while (fileInputStream.available() >0){
        int number = fileInputStream.read();
        counts[number]++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) System.out.println((char)i + " " + counts[i]);

        }
        fileInputStream.close();
    }
}*/
