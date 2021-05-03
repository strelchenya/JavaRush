package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<Byte> list = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() != 0) {
            byte b = (byte) fis.read();

            if (!list.contains(b)) {
                list.add(b);
            }
        }
        fis.close();

        Collections.sort(list);

        for (byte b : list) {
            System.out.print(b + " ");
        }


    }
       /*
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        boolean[] isRead = new boolean[256];
        while (inputStream.available() > 0) {
            isRead[inputStream.read()] = true;
        }
        inputStream.close();
        for (int i = 0; i < 256; i++) { //Без сортировки, просто выводим по возрастанию.
            if (isRead[i]) { //выводим только те байты, которые считывались.
                System.out.print(i + " ");
            }
        }
    }*/


        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

            ArrayList <Integer> list = new ArrayList<>();
            while (fileInputStream.available() > 0) {
                list.add(fileInputStream.read());
            }
            Collections.sort(list);
            Set<Integer> setList = new LinkedHashSet<>(list);
            for (int i: setList) {
                System.out.print(i + " ");
            }
        } finally {
            reader.close();
        }
    }*/
}
