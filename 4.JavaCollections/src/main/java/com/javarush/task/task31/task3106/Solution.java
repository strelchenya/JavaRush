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

/*public class Solution {
    public static void main(String[] args) throws IOException {

        //путь файла в который нужно записать части zip-архива
        String resultFileName = args[0];

        //сортируем пути файлов которые пришли в мэйн
        Set<String> fileNameZip = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            fileNameZip.add(args[i]);
        }

        //сохраняем лист FileInputStream'ов по порядку названий имён
        List<FileInputStream> fisList = new ArrayList<>();
        for (String s:fileNameZip) {
            fisList.add(new FileInputStream(s));
        }

        //создаём SequenceInputStream, который через метод Collections.enumeration
        //будет подавать следующий fisList с FileInputStream
        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));

        //Для чтения архивов применяется класс ZipInputStream
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        //поток записи в файл resultFileName, который пришёл первым аргументом в main
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);

        //создаём буффер байтов для записи/чтения
        byte[] buf = new byte[1024 * 1024];

        //Для считывания файлов из архива ZipInputStream использует метод getNextEntry(),
        //который возвращает объект ZipEntry.
        //берём файл zip в цикле
        while (zipInStream.getNextEntry() != null) {
            int count;
            //читаем буффер байтов с файла zip, пока не зачончатся байты (-1)
            while ((count = zipInStream.read(buf)) != -1) {
                //записываем через ZipInputStream считанные байты в буффер
                // и записываем через FileOutputStream считанные байты из буффера
                fileOutStream.write(buf, 0, count);
            }
        }
        //закрытие всех потоков
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}*/


//-------------------Второй вариант--------------------------------------
public class Solution {
    public static void main(String[] args) throws IOException {
        //создаём упорядочный список директорий импортируя их из массива args с 1-ой позиции по последнюю
        Set<String> sources = new TreeSet<>(Arrays.asList(args).subList(1, args.length));
        //создаём список InputStream в векторе
        Vector<InputStream> list = new Vector<>();
        for (String s : sources) {
            //добавляем InputStream в вектор по пути из Set'ов
            list.addElement(Files.newInputStream(Paths.get(s)));
        }
        //создали FileOutputStream с входящего аргумента из параметров main - args
        try (FileOutputStream fos = new FileOutputStream(args[0]);
             //создали ZipInputStream который по одному подаёт импутстрим из вектора
             ZipInputStream zis = new ZipInputStream(new SequenceInputStream(list.elements()))) {

            //создаём объект ZipEntry, потому что ZipInputStream, это просто поток, сам "файл в архиве" и есть ZipEntry
            ZipEntry entry;

            //берём следующий файл из архифа, если он есть
            while ((entry = zis.getNextEntry()) != null) {
                //создаём буффер
                byte[] buffer = new byte[1024 * 1024];
                int read = 0;
                //читаем буффер байтов с файла zip, пока не зачончатся байты (-1)
                while ((read = zis.read(buffer)) != -1) {
                    //записываем через ZipInputStream считанные байты в буффер
                    // и записываем через FileOutputStream считанные байты из буффера
                    fos.write(buffer, 0, read);
                }
            }
        }
    }
}
