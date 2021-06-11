package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //создали имя файла
        String newFileName = Paths.get(args[0]).getFileName().toString();
        //создали новую директорию в архиве
        String newPathInArchive = "new/" + newFileName;
        ZipEntry entry;

        Map<String, ByteArrayOutputStream> filesInArchive = new HashMap<>();
        //поток считывания с архива
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]));
        while ((entry = zipIn.getNextEntry()) != null) {
            //если в архиве нет файла с таким именем newFileName
            if (!entry.getName().endsWith(newFileName)) {
                //В качестве параметров конструкторы используют массив байтов ByteArrayOutputStream,
                // из которого производится считывание
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int length = 0;
                byte[] buffer = new byte[1024];
                //считывать с архива файл entry через ZipInputStream, пока не закончатся байты
                while ((length = zipIn.read(buffer)) != -1) {
                    //записываем весь файл через буфер в поток ByteArrayOutputStream
                    // т.к. ByteArrayOutputStream хранит в себе массив байтов
                    baos.write(buffer, 0, length);
                }
                //сохраняем в карту имя ZipEntry и поток массива байтов ByteArrayOutputStream
                filesInArchive.put(entry.getName(), baos);
            }
        }
        zipIn.close();

        //записываем новый архив в тот же место
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]));
        //добавляем файл который нужно было записать в директорию "new"
        zipOut.putNextEntry(new ZipEntry(newPathInArchive));
        //создаём поток записи в архив, для записи файла с новым именем "new/" + newFileName
        Files.copy(Paths.get(args[0]), zipOut);
        //перебираем карту
        for (Map.Entry<String, ByteArrayOutputStream> pair : filesInArchive.entrySet()) {
            //добавляем файлы ZipEntry с именами которые сохранили в карте под ключами
            zipOut.putNextEntry(new ZipEntry(pair.getKey()));
            //записываем ZipEntry с значений карты сохранённые в ByteArrayOutputStream
            pair.getValue().writeTo(zipOut);
        }
        zipOut.close();
    }
}