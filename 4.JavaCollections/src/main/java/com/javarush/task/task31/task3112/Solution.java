package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

//        Path tempFile = Files.createTempFile("temp-",".tmp");
        Path tempFile = Paths.get(Files.createTempFile("name-[", "]").toString().split(".+\\\\", 2)[1]);
        Files.copy(inputStream, tempFile);

        if (Files.notExists(downloadDirectory)) Files.createDirectories(downloadDirectory);
        //достаём имя файла из URL
        Path fileName = Paths.get(url.getFile()).getFileName();
        Path absolutelyFileName = downloadDirectory.resolve(fileName);

        inputStream.close();

        //удалять при переносе временный файл StandardCopyOption.REPLACE_EXISTING
        return Files.move(tempFile, absolutelyFileName, StandardCopyOption.REPLACE_EXISTING);
    }
}
