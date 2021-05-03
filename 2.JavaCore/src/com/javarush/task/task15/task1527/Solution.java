package com.javarush.task.task15.task1527;

/*
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*String URL = new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("^(.*?\\?)", "");
        for (String s : URL.split("&")) System.out.print(s.replaceAll("=.*$", "") + " ");
        System.out.println();
        for (String s : URL.split("&")) {
            if (s.replaceAll("=.*$", "").equals("obj")) {
                try {
                    alert(Double.parseDouble(s = s.replaceAll("^[^=]*=", "")));
                } catch (NumberFormatException e) {
                    alert(s);
                }
            }
        }
    }*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String paramsSubString = url.substring(url.lastIndexOf("?") + 1);
        String[] splitParams = paramsSubString.split("&");
        String objValue = null;

        StringBuilder resultBuilder = new StringBuilder();
        for (String splitParam : splitParams) {
            String[] paramAndValue = splitParam.split("=");
            resultBuilder.append(paramAndValue[0]);
            resultBuilder.append(" ");

            if (paramAndValue[0].equals("obj")) {
                objValue = paramAndValue[1];
            }
        }

        System.out.println(resultBuilder.toString().trim());

        if (objValue != null) {
            try {
                alert(Double.parseDouble(objValue));
            } catch (NumberFormatException nfe) {
                alert(objValue);
            }
        }
    }
   /* public static void main(String[] args) {

        String line = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

            int indexQuestion = line.indexOf('?');
            String newLine = line.substring(indexQuestion + 1);
            StringBuffer strBuffer = new StringBuffer();
            String obj = "obj";
            double d = 0.0d;
            // если есть obj

            // если =->&
            while (!(newLine.equals(""))) {
                if (newLine.indexOf('=') != -1 && newLine.indexOf('&') != -1 && newLine.indexOf('=') < newLine.indexOf('&')) {
                    int equally = newLine.indexOf('=');
                    int ampersand = newLine.indexOf('&');
                    strBuffer.append(newLine.substring(0, equally)).append(" ");
                    newLine = newLine.substring(ampersand + 1);
                }
                // если &->&->=
                else if (newLine.indexOf('=') != -1 && newLine.indexOf('&') != -1 && newLine.indexOf('=') > newLine.indexOf('&')) {
                    int ampersand = newLine.indexOf('&');
                    strBuffer.append(newLine.substring(0, ampersand)).append(" ");
                    newLine = newLine.substring(ampersand + 1);
                }
                // если &->&
                else if (newLine.indexOf('=') == -1 && newLine.indexOf('&') != -1) {
                    int ampersand = newLine.indexOf('&');
                    strBuffer.append(newLine.substring(0, ampersand)).append(" ");
                    newLine = newLine.substring(ampersand + 1);
                }
                // если =
                else if (newLine.indexOf('&') == -1 && newLine.indexOf('=') != -1 *//*&& line.indexOf('=') > line.indexOf('&')*//*) {
                    int equally = newLine.indexOf('=');
                    strBuffer.append(newLine.substring(0, equally));
                    newLine = newLine.substring(newLine.length());
                }
                else newLine = newLine.substring(newLine.length());
            }
        System.out.println(strBuffer.toString().trim());


        if (line.contains(obj)) {
            int equally = line.indexOf('=');
            int ampersand = line.indexOf('&');

                try {
                    d = Double.parseDouble(line.substring(equally + 1, ampersand));
//                    System.out.println(d);
//                    alert(strBuffer.toString().trim());
                    *//*if (d != 0.0d)*//*
                    alert(d);
                } catch (NumberFormatException e) {
                    *//*e.printStackTrace();*//*
                    alert(line.substring(equally + 1, ampersand));
                }

        }


    }*/

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
