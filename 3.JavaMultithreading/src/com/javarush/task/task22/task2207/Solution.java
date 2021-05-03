package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        List<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
//        BufferedReader fileReader = new BufferedReader(new FileReader("c:\\Users\\Strelchenya\\Desktop\\Test.txt"));
        bufferedReader.close();
        while (fileReader.ready()) {
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); ) {
                if (i >= words.size()) {
                    break;
                }
                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
                    Pair pair = new Pair();
                    pair.first = words.get(j);
                    pair.second = words.get(i);
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    j = 0;
                } else
                    j++;
            }
        }
//        System.out.println(result);
    }
/*        StringBuilder stringBuilder = new StringBuilder();
        String name = "c:\\Users\\Strelchenya\\Desktop\\Test.txt";
//        String name = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader readerFile = new BufferedReader(new FileReader(name))) {
            while (readerFile.ready()) {
                stringBuilder.append(readerFile.readLine())
                        .append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(stringBuilder); //заполнение списка

        String line = stringBuilder.toString();
        String[] words = stringBuilder.toString().split(" ");
        for (int i = 0; i < words.length-1; i++) {
            String wordRevers = "";
            for (int j = 0; j < words[i].length(); j++) {
                wordRevers = words[i].charAt(j) + wordRevers;

            }
//            System.out.println("revers - " + wordRevers);
            if (line.contains(wordRevers) && !wordRevers.equals("")) {
//                System.out.println(words[i] + " и " + wordRevers);
                result.add(new Pair(words[i], wordRevers));
                line = line.replaceFirst(words[i], "");
                line = line.replaceFirst(wordRevers, "");
//                System.out.println(result.size());
//                System.out.println(line);
                for (int j = 0; j < words.length; j++) {
                    words[i] = "";
                    if (words[j].equals(wordRevers)) {
                        words[j] = "";
                        break;
                    }
                }
            } else {
//                System.out.println(words[i]);
                line = line.replaceFirst(words[i], "");
//                System.out.println("else " + result.size());
//                System.out.println("else " + line);
            }

//            System.out.println(wordRevers);
        }
        System.out.println(result);
    }*/

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
