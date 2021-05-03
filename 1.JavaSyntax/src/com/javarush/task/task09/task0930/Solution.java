package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String line = reader.readLine();
        while (!line.isEmpty()) {
            list.add(line);
            line = reader.readLine();
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (isNumber(array[i]) && isNumber(array[j])) {
                    if (Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {
                        String temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                } else if (!isNumber(array[i]) && !isNumber(array[j])) {
                    if (isGreaterThan(array[i], array[j])) {
                        String temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }
       /* List<String> strings = new ArrayList<>(); // отсортировали по строкам и числам
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numbers.add(Integer.parseInt(array[i]));
            } else {
                strings.add(array[i]);
            }
        }

        String[] arrayString = strings.toArray(new String[strings.size()]); //перевел в массив строк
        //Integer[] arrayNumbers = numbers.toArray(new Integer[numbers.size()]);
        int[] arrayNumbers = new int[numbers.size()]; // перевёл в массив чисел
        for (int i = 0; i < numbers.size(); i++) {
            arrayNumbers[i] = numbers.get(i) * -1; // и сразу добавил минус, чтобы сортировка шла с конца
        }

        //Arrays.sort(arrayString);
        for (int i = arrayString.length - 1; i > 0; i--) {      //отсортировал строки а-я
            for (int j = 0; j < i; j++) {
                if (isGreaterThan(arrayString[j], arrayString[j + 1])) {
                    String tmp = arrayString[j];
                    arrayString[j] = arrayString[j + 1];
                    arrayString[j + 1] = tmp;
                }
            }
        }


        for (int i = arrayNumbers.length - 1; i > 0; i--) { // отсортировал по возрастанию
            for (int j = 0; j < i; j++) {
                if (arrayNumbers[j] > arrayNumbers[j + 1]) {
                    int tmp = arrayNumbers[j];
                    arrayNumbers[j] = arrayNumbers[j + 1];
                    arrayNumbers[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < arrayNumbers.length; i++) {  // убрал отрицательные символы
            arrayNumbers[i] *= -1;
        }


       int num_indx = 0;
       int word_indx = 0;

       for(int i = 0; i < array.length; i++){
           if(isNumber(array[i])){
               array [i] = String.valueOf(arrayNumbers[num_indx]);
               num_indx++;
           }
           else {
               array [i] = arrayString[word_indx];
               word_indx++;
           }
       }




    }*/

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            // есть '-' внутри строки
            if (i != 0 && character == '-') {
                return false;
            }

            // не цифра и не начинается с '-'
            if (!Character.isDigit(character) && character != '-') {
                return false;
            }

            // одиночный '-'
            if (chars.length == 1 && character == '-') {
                return false;
            }
        }

        return true;
    }
}
