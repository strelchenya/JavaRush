package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
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
        String result = outputStream.toString().replaceAll("[^\\d]", "");
        // из подмененного нами PrintStream, в котором на данный момент валяется без дела строка
        // "it's a text for testing" из printSomething() в виде массива байтов
        System.setOut(consoleStream);// возвращаем переменной setOut исходное значение
        System.out.println(result);// в итоге строка выводится в upperCase, согласно нашей обертке
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
