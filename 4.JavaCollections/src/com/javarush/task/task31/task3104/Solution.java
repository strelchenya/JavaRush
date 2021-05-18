package com.javarush.task.task31.task3104;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Поиск скрытых файлов
*/

public class Solution extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get("D:/"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }

    //метод во время обхода дерева при посещении файла,
    // в случае, если он является zip или rar архивом, добавляет его адрес(path) в виде строки к списку архивных файлов;
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toAbsolutePath().toString().endsWith(".rar") || file.toAbsolutePath().toString().endsWith(".zip"))
            archived.add(file.toAbsolutePath().toString());
        //CONTINUE — продолжать проходить дирркторию
        return FileVisitResult.CONTINUE;
    }

    //В случае неудачной попытки доступа к path,
    //данный путь в виде строки добавляется в лист failed ему подобных,
    // и программа продолжает обход, не посещая его поддиректории;
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(file.toAbsolutePath().toString());
        //SKIP_SUBTREE — продолжает обход, без захода в данную директорию;
        return FileVisitResult.SKIP_SUBTREE;
    }
}
