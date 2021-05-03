package com.javarush.task.task18.task1816;

/*
Английские буквы
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

        private final static Character[] ENGLISH_CHARACTERS_ARRAY = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'
                , 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'
                , 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        private final static Set<Character> ENGLISH_CHARACTERS = new HashSet<>(Arrays.asList(ENGLISH_CHARACTERS_ARRAY));

        public static void main(String[] args) throws IOException {
            int countOfEnglishChars = 0;
            try (FileReader fileReader = new FileReader(args[0])) {
                while (fileReader.ready()) {
                    char readChar = (char) fileReader.read();
                    if (ENGLISH_CHARACTERS.contains(readChar)) countOfEnglishChars++;
                }
            }
            System.out.println(countOfEnglishChars);

       /* try (FileInputStream inputStream = new FileInputStream(args[0])) {
            int count = 0;
            while (inputStream.available() > 0) {
                int dec = inputStream.read();
                if (dec > 64 && dec < 91) count++;
                else if (dec > 96 && dec < 123) count++;
            }
            System.out.println(count);
        }*/

    }
}
