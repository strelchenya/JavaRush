package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        /*for (Map.Entry<String,String> entry: runtimeStorage.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }*/
//            PrintStream printStream = new PrintStream(outputStream);
        properties.store(outputStream, "Javarush");
//        properties.list(printStream);
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        properties.forEach( (k, v) -> runtimeStorage.put( (String)k, (String)v) );
       /* for (String key: properties.stringPropertyNames()) {
            runtimeStorage.put(key, properties.getProperty(key));
        }*/

    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);
//        runtimeStorage.put("123", "qwe");
//        runtimeStorage.put("456", "ghd");
//        runtimeStorage.put("789", "zxc");
//        runtimeStorage.put("012", "asd");
//        FileOutputStream fileOutputStream = new FileOutputStream("c:\\Users\\Strelchenya\\Desktop\\1.properties");
//            save(fileOutputStream);
    }
}
