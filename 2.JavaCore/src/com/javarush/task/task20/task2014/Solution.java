package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution savedObject = new Solution(2);

        FileOutputStream fileOutputStream = new FileOutputStream("c:\\Users\\Strelchenya\\Desktop\\Test.txt");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("c:\\Users\\Strelchenya\\Desktop\\Test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution loadedObject = (Solution) objectInputStream.readObject();
        if (savedObject.string.equals(loadedObject.string)){
            System.out.println(true);
        }
//        System.out.println(new Solution(4));

        System.out.println(savedObject.string);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(loadedObject.string);
        objectInputStream.close();
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
