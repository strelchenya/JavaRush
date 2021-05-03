package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

                int[] buffer = new int[256];
                while (fileInputStream.available() > 0) {
                    buffer[fileInputStream.read()]++;
                }
                int max = buffer[0];
                int index = 0;
                for (int i = 1; i < buffer.length; i++) {
                    if (buffer[i] > max) {
                        max = buffer[i];
                        index = i;
                    }
                }
                resultMap.put(fileName, index);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
