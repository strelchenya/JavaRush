package com.javarush.task.task13.task1318;

/*
Чтение файла
*/

//public class Solution {
//    public static void main(String[] args) throws Exception {  // незабываем ставить исключение
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// считываем с клавы
//        String sourceFileName = reader.readLine(); // записываем в переменную считаное с клавы
//
//        FileInputStream fileInputStream = new FileInputStream(sourceFileName); //считываем файл по введёному пути
//
//        Scanner scanner = new Scanner(fileInputStream);//читает построчно
//        StringBuilder builder = new StringBuilder();// создаём объект стрингбилдер
//
//        while (scanner.hasNextLine()) {
//            builder.append(scanner.nextLine()).append("\n"); // цикл построчного чтения файла вроде бы как
//        }
//
//        System.out.print(builder.toString()); // вывод
//
//        scanner.close(); // закрытие входящего потока от чтения файла
//        reader.close();  // закрытие входящего потока от чтения с клавиатуры
//    }
//}

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException { // незабываем ставить исключение


        try { // или обвернуть в трай-кэтч
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // считываем с клавы
            String nameFile = reader.readLine();  // записываем в переменную считаное с клавы

            InputStream inStream = new FileInputStream(nameFile); //считываем файл по введёному пути
            BufferedReader bif = new BufferedReader(new InputStreamReader(inStream)); //читает построчно с файла

            while (bif.ready()) { System.out.println(bif.readLine());} // цикл построчного чтения файла вроде бы как

            inStream.close(); // закрытие входящего потока от чтения с клавиатуры
            bif.close();// закрытие входящего потока от чтения файла
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}