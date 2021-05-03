package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/* 
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
        } catch (IOException ignored) {
        }

        List<String> resultList = new ArrayList<>();
        for (String line : list) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                resultList.add(tokenizer.nextToken());
            }
        }

        StringBuilder result = getLine(getWords(resultList));
        System.out.println(result.toString());
    }

    private static String[] getWords(List<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private static boolean isTheSameChars(String firstWord, String secondWord) {
        if (firstWord.endsWith(" ")) {
            firstWord = firstWord.substring(0, firstWord.length() - 1);
        }
        return firstWord.isEmpty() || (secondWord != null &&
                Character.toUpperCase(firstWord.charAt(firstWord.length() - 1)) == Character.toUpperCase(secondWord.charAt(0)));
    }

    private static <T> T getLastElement(List<? extends T> list) {
        return list.get(list.size() - 1);
    }


    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(i);
            if (findSolutions(list, words)) {
                for (Integer integer : list) {
                    builder.append(words[integer]);
                    builder.append(" ");
                }
                return builder;
            }
            list.remove(Integer.valueOf(i));
        }

        return builder;
    }

    private static boolean findSolutions(List<Integer> list, String... words) {
        if (list.size() == words.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (isValid(list, words[i], words)) {
                list.add(i);
                if (findSolutions(list, words)) {
                    return true;
                }
                list.remove(Integer.valueOf(i));
            }
        }
        return false;
    }

    private static boolean isValid(List<Integer> list, String word, String... words) {
        for (Integer integer : list) {
            if (words[integer].equals(word)) {
                return false;
            }
        }
        return isTheSameChars(words[getLastElement(list)], word);
    }

}
/*
public class Solution {
    public static void main(String[] args) {
        StringBuilder st = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader readerFile = new BufferedReader(new FileReader(reader.readLine()*/
/*"c:\\Users\\Strelchenya\\Desktop\\Test.txt"*//*
))
        ) {
            String s = "";
            while ((s = readerFile.readLine()) != null) {
                st.append(s)
                        .append(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] getLine = st.toString().trim().split(" ");
        StringBuilder result = getLine(getLine);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0 || words == null) return new StringBuilder("");
        List<String> arrayList = new ArrayList(Arrays.asList(words));
        String line = "";
        for (String s :
                arrayList) {
            line += s + " ";
        }
        StringTokenizer str = new StringTokenizer(line.trim());
        StringBuilder finalCity = new StringBuilder();
        */
/*finalCity.append(str.nextToken())
                .append(" ");*//*

        finalCity.append(arrayList.get(0)).append(" ");
        arrayList.add(arrayList.get(0));
        arrayList.remove(0);

        while (*/
/*str.hasMoreElements()*//*
 arrayList.size() != 0) {
            if (!finalCity.toString().contains(arrayList.get(0))) {
                String charFinal = String.valueOf(finalCity.charAt(finalCity.length() - 2)).toUpperCase(Locale.ROOT);
                String charWord = String.valueOf(arrayList.get(0).charAt(0));
                if (charFinal.equals(charWord)) {
                    finalCity.append(arrayList.get(0)).append(" ");
                    arrayList.remove(0);
                } else {
                    arrayList.add(arrayList.get(0));
                    arrayList.remove(0);
                }

            } else {
                arrayList.add(arrayList.get(0));
                arrayList.remove(0);
            }
        }
        finalCity.deleteCharAt(finalCity.length()-1);
        return finalCity;
    }
}
//c:\Users\Strelchenya\Desktop\Test.txt*/
