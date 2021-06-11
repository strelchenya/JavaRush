package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        /*if (args == null || args.length < 1) {
            args = new String[2];
            args[0] = "C:\\Users\\Strelchenya\\Desktop\\Test";
            args[1] = "C:\\Users\\Strelchenya\\Desktop\\Test.txt";
        }*/


        Path directoryPath = Paths.get(args[0]);
        File resultFile = new File(args[1]);

        Map<String, File> result = new TreeMap<>();

        String newNameFile = "allFilesContent.txt";
        File newFile = new File(resultFile.getParent() + "/" + newNameFile);
        //если
        if (FileUtils.isExist(resultFile)) FileUtils.deleteFile(resultFile);
            FileUtils.renameFile(resultFile, newFile);
//        Path newFilePath = Paths.get(newFile.getAbsolutePath());

        //список ссылок приходящий от метода visitFile через Files.walkFileTree возращает,
        //чтобы проходил ещё директории FileVisitResult.CONTINUE
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(directoryPath, options, 100, new MyFileVisitor(result));
//        System.out.println(result);
//        getFile(result, newFilePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            for (Map.Entry<String, File> file : result.entrySet()) {
                byte[] bytes = Files.readAllBytes(Paths.get(String.valueOf(file.getValue().getAbsoluteFile())));
                fileOutputStream.write(bytes);
                fileOutputStream.write('\n');
            }
        }catch (IOException ignored) {
        }
    }

    /*public static void getFile(Map<String, File> mapFile, Path path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path.toString())) {
        for (Map.Entry<String, File> file : mapFile.entrySet()) {
                byte[] bytes = Files.readAllBytes(Paths.get(String.valueOf(file.getValue().getAbsoluteFile())));
                fileOutputStream.write(bytes);
                fileOutputStream.write('\n');
            }
        }
    }*/
}


//класс для сортировки дерева файлов
class MyFileVisitor extends SimpleFileVisitor<Path> {
    private Map<String, File> result;


    public MyFileVisitor(Map<String, File> result) {
        this.result = result;
    }

    //переопределённый метод SimpleFileVisitor для метода Files.walkFileTree
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File files = new File(String.valueOf(file));
        //проверка на то что пришёл именно файл
        if (files.isFile()) {
            // чтобы файл был не более 50 байт
            if (files.length() <= 50) {
                //добавлять в мапу-список только файлы с расширением .txt
                if (files.getName().endsWith(".txt")) {
                    result.put(files.getName(), files);
                }
            }
        }
        //повторять для всех вложенных дирректориях
        return FileVisitResult.CONTINUE;
    }
}

/*

-------------------------Решение от Вали-----------------------------------
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;


Проход по дереву файлов


public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        try {
            File resultFile = new File(resultFileAbsolutePath);
            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
            if (FileUtils.isExist(dest)) {
                FileUtils.deleteFile(dest);
            }
            FileUtils.renameFile(resultFile, dest);

            Map<String, byte[]> fileTree = getFileTree(path);
            try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
                for (byte[] bytes : fileTree.values()) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.write("\n".getBytes());
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private Map<String, byte[]> result;

        public GetFiles(Map<String, byte[]> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile();
            if (file.isFile()) {
                if (file.length() <= 50) {
                    result.put(path.getFileName().toString(), Files.readAllBytes(path));
                }
            }
            return super.visitFile(path, basicFileAttributes);
        }
    }
}
 */