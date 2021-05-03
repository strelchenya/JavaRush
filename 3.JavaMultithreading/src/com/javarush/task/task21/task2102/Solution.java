package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/

public class Solution {
    public static void main(String[] args) {
        /*Class <Solution> c = Solution.class;
        int classModifiers = c.getModifiers();*/
        int classModifiers = Solution.class.getModifiers();
//        System.out.printf("classModifier = %d%n",classModifiers);
//        System.out.printf("classModifier в двоичной системе счисления = %s%n",Integer.toBinaryString(classModifiers));

        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
//        return (allModifiers & specificModifier) > 0;
        return (allModifiers & specificModifier) != 0;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
