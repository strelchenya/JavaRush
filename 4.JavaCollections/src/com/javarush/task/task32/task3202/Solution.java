package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is == null) {
            return new StringWriter();
        }

        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch = is.read()) != -1){
            sb.append((char)ch);
        }

        String line = sb.toString();
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(line);
        return stringWriter;
    }
}
