package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 1) {
            args = new String[2];
            args[0] = "C:\\Users\\Strelchenya\\Desktop\\Test";
            args[1] = "C:\\Users\\Strelchenya\\Desktop\\Test.txt";
        }
        Path directoryPath = Paths.get(args[0]);
//        Path resultFileAbsolutePath = Paths.get(args[1]);
        File resultFile = new File(args[1]);

        Set<File> result = new TreeSet<>();

        String newNameFile = "allFilesContent.txt";
        File newFile = new File(newNameFile);
        if (FileUtils.isExist(resultFile)) FileUtils.renameFile(resultFile, newFile);
        Path newFilePath = Paths.get(newFile.getAbsolutePath());

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(directoryPath, options, 100, new MyFileVisitor(result));
        System.out.println(result);
    }

}

class MyFileVisitor extends SimpleFileVisitor<Path> {
    private Set<File> result;

    public MyFileVisitor(Set<File> result) {
        this.result = result;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        String s = file.toAbsolutePath().toString();
        result.add(s);

        return FileVisitResult.CONTINUE;
    }
}