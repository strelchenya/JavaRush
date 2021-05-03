package com.javarush.task.task18.task1824;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = null;
        boolean closeReader = true;

        while ((nameFile = reader.readLine()) != null && closeReader) {
            try (BufferedReader readerFile = new BufferedReader(new FileReader(nameFile))) {

            } catch (FileNotFoundException e) {
                System.out.println(nameFile);
                closeReader = false;
            }
        }
    }
}
