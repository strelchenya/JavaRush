package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {




        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        try (BufferedReader readerFile = new BufferedReader(new FileReader(nameFile))) {
            String line = null;
//            int id = Integer.parseInt(args[0]);
            String id = args[0];
            while ((line = readerFile.readLine()) != null){
                if(line.startsWith(id + " ")) {
//                if(line.indexOf(id) == 0) {
                    System.out.println(line);
                    break;
                }
            }
        }
        reader.close();
    }
}
