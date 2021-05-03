package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();


        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        try {// 1. арифметическая ошибка (например, деление на ноль);
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        try {//2. индекс за пределами массива;
            int[] a = new int[2];
            a[3] = 1;

        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {//3. присваивание элементу массива объекта несовместимого типа;
            Object x[] = new String[3];
            x[0] = new Integer(0);

        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        try {//4. неправильное приведение типов;
            Object i = Integer.valueOf(42);
            String s = (String) i;

        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        File file1 = new File("path1");//5. отсутствует файл
        File file2 = new File("path2");
        try {

            FileInputStream fis = new FileInputStream(file1);
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try { //6. Это исключение самое простое, его легко понять, найти его причину и исправить.
            // Оно случается когда JVM пытается передать методу неподходящий аргумент или аргумент неправильного типа.
            int num = -3;
            if (num < 0) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }

        Stack<String> variable = null;//7.Возникает при попытке извлечения объекта из пустого стека.
        try {
            variable = new Stack<String>();
            String eval = "3423562";
            String alphabet = "abcdefghjiklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < eval.length(); i++) {
                eval = eval.substring(i, i);
                if (eval.equals(alphabet.substring(0, 52))) {
                    variable.push(eval);
                }
                System.out.println(variable.pop());
            }
        } catch (EmptyStackException e) {
            exceptions.add(e);
        }

        try {//8.Предпринята попытка создания массива с размером, значение которого задано отрицательным числом.
            String [] s = new String[-10];
        }catch (NegativeArraySizeException e){
            exceptions.add(e);
        }

        try {//9.Строка, которая, как предполагалось должна содержать представление числа,
            // не отвечает этому требованию. Исключение выбрасывается такими методами, как, например, Integer.parseInt.
            Integer.parseInt("surprise");
        }catch (NumberFormatException e){
            exceptions.add(e);
        }

        try {//10.Предпринята попытка выполнения операции над объектом, который ее не поддерживает
            // (например, модификация объекта, обозначенного признаком «только для чтения»).
            // используется также классами коллекций из состава пакета java.util как реакция
            // на вызов методов производного класса, реализация которых не обязательна.
            List<Integer> list1 = Arrays.asList(10,20,60,30,22,70,89);
            List<Integer> list2 = Arrays.asList(1,2,45,23,89,66,87,33,19,39);
            list1.addAll(list2);
        }catch (UnsupportedOperationException e){
            exceptions.add(e);
        }

    }

}
