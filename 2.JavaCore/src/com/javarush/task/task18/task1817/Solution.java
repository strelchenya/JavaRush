package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        int total = 0;
        int spaces = 0;
        try (FileReader fileReader = new FileReader(args[0])) {
            while (fileReader.ready()) {
                int readedChar = fileReader.read();
                total++;
                if (readedChar == (int) ' ') spaces++;
            }
        }
        if (total != 0) {
            double result = (double) spaces / total * 100;
            System.out.printf("%.2f", result);
        }


        /*try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            int countSpace = 0;
            int countLetter = 0;
            while (fileInputStream.available() > 0){
                int dec = fileInputStream.read();
                if (dec == 32) countSpace++;
                else if (dec != 32) countLetter++;
            }
            countLetter += countSpace;
            double percentSpace = (double) countSpace/countLetter * 100;
            String result = String.format("%.2f", percentSpace);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
