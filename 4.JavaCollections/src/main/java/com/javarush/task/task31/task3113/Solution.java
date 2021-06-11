package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirName = reader.readLine();

        Path directory = Paths.get(dirName);

        if (!Files.isDirectory(directory)) {
            System.out.println(directory.toString() + " - не папка.");
        } else {
            AtomicInteger folderCounter = new AtomicInteger();
            AtomicInteger fileCounter = new AtomicInteger();
            AtomicLong sizeCounter = new AtomicLong();

            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (!dir.equals(directory)) folderCounter.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCounter.incrementAndGet();
                    sizeCounter.addAndGet(attrs.size());
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Параметры папки " + directory.toString() + ":");
            System.out.println("Всего папок - " + folderCounter.get());
            System.out.println("Всего файлов - " + fileCounter.get());
            System.out.println("Общий размер - " + sizeCounter.get() + " байт");
        }
    }
}



/* -------------------------Первый вариант------------------------
public class Solution extends SimpleFileVisitor<Path>{

public static int countFile = 0;
public static int countPath = 0;
public static double heightFile = 0;

    public static void main(String[] args) throws IOException {

        String path = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path = reader.readLine();
            //если введённая с клавиатуры информация НЕ является директорией
            if (!Files.isDirectory(Paths.get(path))) {
                System.out.println(path + " - не папка");
            }
        }

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(path),  options, Integer.MAX_VALUE, new Solution());

        //отнимаем корневую директорию, которая пришла с ввода на клавиатуре
        countPath--;

        System.out.println("Всего папок - " + countPath);
        System.out.println("Всего файлов - " + countFile);
        System.out.println("Общий размер - " + heightFile);
    }

    //соверщает действия над директориями
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        //считает количество директорий
        countPath++;

        return FileVisitResult.CONTINUE;
    }

    //метод совершает действие над файлами
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        //считает количество файлов
        countFile++;
        //суммирую каждый файл в директориях, вес файла attrs.size()
        heightFile += attrs.size();
        return FileVisitResult.CONTINUE;
    }
}*/
