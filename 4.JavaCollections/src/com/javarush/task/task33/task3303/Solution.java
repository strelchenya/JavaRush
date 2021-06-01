package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {

        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);

        ObjectMapper mapper = new ObjectMapper();
        T t = mapper.readValue(fileReader, clazz);
        return t;
    }

    public static void main(String[] args) {

    }
}
