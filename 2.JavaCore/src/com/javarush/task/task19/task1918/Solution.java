package com.javarush.task.task19.task1918;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = null;

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        } catch (IOException ignore) {
            /*NOP*/
        }

        StringBuilder readFileContent = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                readFileContent = readFileContent.append(fileReader.readLine());
            }
        } catch (IOException ignore) {
            /*NOP*/
        }

        String fileContent = readFileContent.toString().replaceAll("\r\n", "");

        String openTag = "<" + args[0];
        String closingTag = "</" + args[0];
        int tagLength = args[0].length();
        int startTagIndex = 0;
        int endTagIndex = 0;

        ArrayList<String> tags = new ArrayList<>();

        while ((startTagIndex != -1) && (startTagIndex < fileContent.length())) {
            startTagIndex = fileContent.indexOf(openTag, startTagIndex);
            endTagIndex = fileContent.indexOf(closingTag, startTagIndex + tagLength);

            int indexInTag = startTagIndex + tagLength;
            if (endTagIndex != -1) {
                while (fileContent.substring(indexInTag, endTagIndex).contains(openTag)) {
                    indexInTag = endTagIndex + tagLength;
                    endTagIndex = fileContent.indexOf(closingTag, indexInTag);
                }
            }
            if (startTagIndex != -1 && endTagIndex != -1) {
                tags.add(fileContent.substring(startTagIndex, endTagIndex + tagLength + 3));
                startTagIndex += tagLength;
            }
        }

        for (String tag : tags) {
            System.out.println(tag);
        }
    }
}
        /*String nameFile = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            nameFile = reader.readLine();
        }

        try (BufferedReader readerFile = new BufferedReader(new FileReader(nameFile))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = readerFile.readLine()) != null){
                stringBuilder.append(line);
            }

            Document document = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
            Elements elem = document.select(args[0]);
            for (Element elements : elem){
                System.out.println(elements);
            }
        }
    }
}*/
