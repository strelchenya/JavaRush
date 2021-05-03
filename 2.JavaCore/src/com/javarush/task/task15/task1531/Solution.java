package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {

        BigInteger f = new  BigInteger("1");
        if(n < 0) return "0";
        for (int i = 1; i <= n; ++i) f = f.multiply(BigInteger.valueOf(i));
        return f.toString();


        /*BigInteger f = BigInteger.ONE;
        if(n < 0) return "0";
        for (int i = 1; i <= n; ++i) f = f.multiply(BigInteger.valueOf(i));
        return f.toString();*/


       /* Вариант через рекурсию которая работает до 13!, далее упирается в int
       int result = 1;
        if (n == 1 || n == 0) return String.valueOf(result);
        else if (n < 0) return "0";
        result = n * (Integer.parseInt(factorial(n - 1)));
        return String.valueOf(result);*/
    }
}
