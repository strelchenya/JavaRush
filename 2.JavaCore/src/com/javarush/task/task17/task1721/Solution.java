package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();

        BufferedReader readerAllLines = new BufferedReader(new FileReader(nameFile1));
        String s = "";
        while (!((s = readerAllLines.readLine()) == null)) {
            allLines.add(s);
        }
        BufferedReader readerForRemoveLines = new BufferedReader(new FileReader(nameFile2));
        String d = "";
        while (!((d = readerForRemoveLines.readLine()) == null)) {
            forRemoveLines.add(d);
        }
        reader.close();
        readerAllLines.close();
        readerForRemoveLines.close();
        Solution solution = new Solution();
        solution.joinData();

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
/*
        int count = 0;
        for (int i = 0; i < forRemoveLines.size(); i++) {
            for (int j = 0; j < allLines.size(); j++) {
                if (allLines.get(j).compareTo(forRemoveLines.get(i)) == 0) count++;
            }
        }
        if (count == forRemoveLines.size()) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }*/
    }
}
