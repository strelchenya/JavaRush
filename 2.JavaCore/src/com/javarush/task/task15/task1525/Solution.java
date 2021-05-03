package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {

    public static List<String> lines = new ArrayList<String>();

    static {
        /*try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Statics.FILE_NAME = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        BufferedReader reader1 = null;
        String line;
        try {
            reader1 = new BufferedReader(new FileReader(Statics.FILE_NAME));
            while ((line = reader1.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
