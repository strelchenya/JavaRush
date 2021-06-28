package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.util.Collections;


/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class clazz : Collections.class.getDeclaredClasses()) {
            System.out.println(clazz.getSimpleName());
            if (clazz.getSimpleName().equals("EmptyList")) {
                return clazz;
            }
        }
        return null;
    }
}
