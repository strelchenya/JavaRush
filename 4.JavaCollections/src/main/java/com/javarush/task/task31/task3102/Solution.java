package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        //создал двухсвязанную очередь
        LinkedList<File> fileQueue = new LinkedList<>();
        //созал файл
        File file = new File(root);
        //создал список в который будем сохранять имена всех файлов
        List<String> listFile = new ArrayList<>();
        //если файл - это дирректория, то добавить её в список
        if (file.isDirectory()) fileQueue.add(file);
        //цикл до тех пор пока не закончится очередь
        while (!fileQueue.isEmpty()){
            //цикл: берём и удаляем файл с очереди, переводя его в список файлов в директории
            for (File f: fileQueue.poll().listFiles()) {
                //если новый файл из директории тоже дирректория, то добавляем его в список
                if (f.isDirectory())fileQueue.addLast(f);
                //если новый файл является файлом, то добавляем его имя в список имён
                else if (f.isFile()) {
                    listFile.add(f.getAbsolutePath());
                }
            }
        }

        return listFile;

    }


    public static void main(String[] args) {

        try {
            List<String> arrayFile = getFileTree("c:\\Users\\Strelchenya\\Desktop\\");
            for (String s: arrayFile) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private List<String> result;

        public GetFiles(List<String> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            String s = path.toAbsolutePath().toString();
            result.add(s);
            return FileVisitResult.CONTINUE;
        }
    }*/
}
