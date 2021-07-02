package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {

        try {
            path = Files.createTempFile(Integer.toHexString(hashCode()), ".tmp");
            path.toFile().deleteOnExit();

            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getFileSize() {
        long fileSize = 0;
        try {
            fileSize = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileSize;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(entry);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Entry getEntry(){
        if (getFileSize() == 0) {
            return null;
        }
        Entry entry = null;
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
           entry = (Entry) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
