package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String pathZipFile = reader.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(pathZipFile));

            String pathFile = reader.readLine();
            zipFileManager.createZip(Paths.get(pathFile));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
