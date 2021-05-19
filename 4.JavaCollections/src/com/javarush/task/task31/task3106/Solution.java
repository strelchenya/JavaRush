package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //создаём упорядочный список директорий импортируя их из массима args с 1-ой позиции по последнюю
        Set<String> sources = new TreeSet<>(Arrays.asList(args).subList(1, args.length));
        //создаём список InputStream в векторе
        Vector<InputStream> list = new Vector<>();
        for (String s : sources) {
            //добавляем InputStream в вектор по пути из Set'ов
            list.addElement(Files.newInputStream(Paths.get(s)));
        }
        //создали импутстрим с входящего аргумента из параметров main - args
        try (FileOutputStream fos = new FileOutputStream(args[0]);
             //создали ZipInputStream который по одному подаёт импутстрим из вектора
             ZipInputStream zis = new ZipInputStream(new SequenceInputStream(list.elements()))) {

            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[4096];
                int read = 0;
                while ((read = zis.read(buffer)) != -1){
                    fos.write(buffer, 0, read);
                }
            }
        }
    }
}
