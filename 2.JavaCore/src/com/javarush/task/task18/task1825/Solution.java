package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;
/*
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nameFile = "";
        String wayFile = "";
        String index = "";
        Set<String> lines = new TreeSet<String>();
        while (!(nameFile = reader.readLine()).equals("end")) {
            wayFile = nameFile.split(".part")[0];
            index = nameFile.split(".part")[1];
            lines.add(index);
        }
        for (String i : lines) {
            FileInputStream fileInputStream = new FileInputStream(wayFile + ".part" + i);
            byte[] buffer = new byte[fileInputStream.available()];
            FileOutputStream fileOutputStream = new FileOutputStream(wayFile, true);
            fileInputStream.read(buffer, 0, buffer.length);
            fileOutputStream.write(buffer, 0, buffer.length);
            fileInputStream.close();
            fileOutputStream.close();
        }
        reader.close();

    }
    /*class Movie {
        private String nameFile;
        private int[] data;
        public Movie(String nameFile, int[] data){
            this.nameFile = nameFile;
            this.data = data;
        }

        public String getNameFile() {
            return nameFile;
        }

        public void setNameFile(String nameFile) {
            this.nameFile = nameFile;
        }

        public int[] getData() {
            return data;
        }

        public void setData(int[] data) {
            this.data = data;
        }

    }*/
}
