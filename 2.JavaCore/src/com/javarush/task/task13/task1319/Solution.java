package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writter = null;
//        InputStream inStream = null;
//        BufferedReader readFile = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in)); // считывание с клавы
            String nameFile = reader.readLine(); //ввод имени-пути файла
            writter = new BufferedWriter(new FileWriter(nameFile));// открытие потока на запись в файл
            StringBuilder builder = new StringBuilder();
            String s = "";
            while (!s.equals("exit")) {
                s = reader.readLine();//запись в файл до ввода exit
                builder.append(s).append("\n");
            }
            writter.write(builder.toString()); //запись в файл
            writter.flush(); //передать данные из буфера во Writer. финализирует выходное состояние, очищая все буферы вывода


//-------------------------------------ЧТЕНИЕ ИЗ ФАЙЛА--------------------------------------------------------------
//            inStream = new FileInputStream(nameFile);    //   чтение из файла
//            readFile = new BufferedReader(new InputStreamReader(inStream));
//            while (readFile.ready()) {//может ли поток читать
//                System.out.println(readFile.readLine());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            writter.close();
//            inStream.close();
//            readFile.close();
        }
  /*
        BufferedReader reader = null;
        FileWriter writer = null;
        InputStream inStream = null;
        BufferedReader readFile = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in)); // считывание с клавы
            String nameFile = reader.readLine(); //ввод имени-пути файла
            writer = new FileWriter(nameFile); // открытие потока на запись в файл
            String s;
            while (!(s = reader.readLine()).equals("exit")) {        //запись в файл до ввода exit
                writer.write(s + "\n"); //запись в файл
                writer.flush(); //финализирует выходное состояние, очищая все буферы вывода
            }
//-------------------------------------ЧТЕНИЕ ИЗ ФАЙЛА--------------------------------------------------------------
            inStream = new FileInputStream(nameFile);    //   чтение из файла
            readFile = new BufferedReader(new InputStreamReader(inStream));
            while (readFile.ready()) {//может ли поток читать
                System.out.println(readFile.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
            writer.close();
            inStream.close();
            readFile.close();
        }*/
    }
}
