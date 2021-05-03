package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
         if (args.length == 0) {
            args = new String[]{"C:\\Users\\Strelchenya\\Desktop\\Test.txt", "C:\\Users\\Strelchenya\\Desktop\\Test1.txt"};
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            String s = "";
            StringBuilder listRead = new StringBuilder();
            while ((s = reader.readLine()) != null) {
                listRead.append(s.replaceAll("\\p{Punct}|\\d+", " ")); //|.*[0-9]+.*
            }
            List<String> wordsWrite = new ArrayList<>();
                String[] words = listRead.toString().split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6) wordsWrite.add(words[i] + ",");
            }
            String lastWord = wordsWrite.get(wordsWrite.size() - 1);//lastWord.substring(0, lastWord.length() - 1)
            lastWord = lastWord.substring(0, lastWord.length() - 1);
            wordsWrite.set(wordsWrite.size() - 1, lastWord);
            for (int i = 0; i < wordsWrite.size(); i++) {
                writer.write(wordsWrite.get(i));
            }
        }
    }
}


        /*try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            String s = "";
            List<String> listRead = new ArrayList<>();
            while ((s = reader.readLine()) != null) {
                String[] line = s.split(" ");
                for (String word : line) {
                    if (word.length() > 6) listRead.add(word + ",");
                }
            }
            String lastWord = listRead.get(listRead.size() - 1);
            listRead.add(lastWord.substring(0, lastWord.length() - 1));
            for (int i = 0; i < listRead.size(); i++) {
                writer.write(listRead.get(i));
            }
        }
    }
}*/
       /* String fileName1 = args[0];
        String fileName2 = args[1];
        String input;

        ArrayList<String> fileContent = new ArrayList<String>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
            while ((input = fileReader.readLine()) != null)
                fileContent.add(input);
        } catch (IOException ignore) {
            *//* NOP *//*
        }

        StringBuffer sbLine = new StringBuffer();
        for (String line : fileContent) {
            String[] splitedLine = line.split(" ");
            for (String word : splitedLine) {
                if (word.length() > 6)

                    sbLine.append(word).append(" ");
            }
        }

        String resultLine = sbLine.toString().trim().replaceAll(" ", ",");
        try (FileWriter fileWriter = new FileWriter(fileName2)) {
            fileWriter.write(resultLine);
        } catch (IOException ignore) {
            *//* NOP *//*
        }
    }
}*/