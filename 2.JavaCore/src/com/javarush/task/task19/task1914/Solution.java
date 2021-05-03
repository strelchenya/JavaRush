package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;//запоминаем настоящий PrintStream в специальную переменную,
        // дабы потом вернуть его в изначальном виде.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();//создаем ссылку на поток в виде динамического массив байтов
        PrintStream myStream = new PrintStream(outputStream);//создаем адаптер к классу PrintStream - ссылку
        // на свой поток из ранне объявленного динамического массива байтов
        System.setOut(myStream);//Устанавливаем свой поток/адаптер как текущее значение System.out
        testString.printSomething();//Вызываем функцию, которая по умолчанию выводит  в консоль сиречь PrintStream текст "it's a text for testing", но!
        // PrintStream подменен нами на этом этапе выполнения программы на свой адаптер - массив байтов.
        String result = outputStream.toString();
        String [] words = result.split( " ");
        int firstNumber = Integer.parseInt(words[0]);
        int lastNumber = Integer.parseInt(words[2]);
        int resultInt = 0;
        if (words[1].equals("+")) resultInt = firstNumber + lastNumber;
        else if (words[1].equals("-")) resultInt = firstNumber - lastNumber;
        else if (words[1].equals("*")) resultInt = firstNumber * lastNumber;
        result = words[0] + " " + words[1] + " " + words[2] + " " + words[3] + " " + resultInt;
        System.setOut(consoleStream);// возвращаем переменной setOut исходное значение
        System.out.println(result);// в итоге строка выводится в upperCase, согласно нашей обертке
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

