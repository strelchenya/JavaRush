package com.javarush.task.task18.task1820;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName1));
             PrintWriter printWriter = new PrintWriter(new FileWriter(fileName2))) {

            while (bufferedFileReader.ready()) {
                String[] splittedLine = bufferedFileReader.readLine().split(" ");
                for (String numberInString : splittedLine) {
                    double number = Double.parseDouble(numberInString);
                    long roundedNumber = Math.round(number);
                    printWriter.print(roundedNumber + " ");
                }
            }
        }
       /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();
        BufferedReader readerFile = new BufferedReader(new FileReader(nameFile1));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(nameFile2));
        String file = "";
        while ((file = readerFile.readLine()) != null) {
            String[] words = file.split(" ");
            for (String word : words) {
                int number = (int) Math.round(Double.parseDouble(word));
                writerFile.write(number + " ");
            }
        }
        reader.close();
        readerFile.close();
        writerFile.close();*/
    }
}
