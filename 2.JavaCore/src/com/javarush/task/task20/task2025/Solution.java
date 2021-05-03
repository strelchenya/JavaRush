package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    private static long S;
    private static int N;
    private static int[] digitsMultiSet;
    private static int[] testMultiSet;

    private static List<Long> results;
    private static long maxPow;
    private static long minPow;

    private static long[][] pows;

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }

    public static long[] getNumbers(long upperLimit) {
        if (upperLimit <= 1) return new long[0];

        S = upperLimit;
        List<Long> armstrongList = generate(String.valueOf(S).length() + 1);
        long[] result = new long[armstrongList.size()];

        for (int i = 0; i < armstrongList.size(); i++) {
            result[i] = armstrongList.get(i);
        }
        return result;
    }

    private static void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;

        if (digit == -1) {
            if (check(pow) && pow < S) results.add(pow);
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N]);
        } else {
            // Check if we can generate more than minimum
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][N];
                    // Check maximum and break the loop - doesn't help
                    // if (p >= maxPow) break;
                }
            }
        }
    }

    private static List<Long> generate(int maxN) {
        if (maxN >= 21) throw new IllegalArgumentException();

        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];

        for (N = 1; N < maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);

            search(9, N, 0);
        }

        Collections.sort(results);

        return results;
    }
}


/*
public class Solution {
    public static long[] getNumbers(long N) {

        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i < N; i++) {

            int pow = Long.toString(i).length();

            String s = Long.toString(i);
            char[] chs = s.toCharArray();
            int[] a = new int[pow];
            int j = 0;
            for(char c : chs){
                a[j] = Integer.parseInt(Character.toString(c));
                j++;
            }

            long sum = 0;  // сумма
            int k = 0;     // порядковый номер цифры
            while (k < pow && sum <= i){
                long tmp = 1;
                for (int l = 0; l < pow; l++){
                    tmp = tmp * a[k];
                }
                sum = sum + tmp;
                k++;
            }

            if (i == sum && k == pow){
                list.add(i);
            }
        }

        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    */
/*public static long[] getNumbers(long N) {

        if (N < 0) N *= -1;


        List<Long> resultLong = new ArrayList<>();
        long k = 0;
        for (long i = 1; i < N; i++) {
            List<Byte> numbers = new ArrayList<>(); // запись листа цифр с каждого числа
            long j = i;
            k = i;
            while (j > 0) {        //цикл разбития на цифры
                numbers.add((byte) (j % 10));
                j /= 10;
            }
            long number = 0;
            long var = 1;
            for (byte a : numbers) {
                for (int l = 0; l < numbers.size(); l++) {
                    var *= numbers.get(l);
                }
//                number += Math.pow(a, numbers.size());
                number += Math.pow(a, numbers.size());
            }
            if (k == number) {
                resultLong.add(number);
            }
            numbers.clear();
        }
        long[] result = new long[resultLong.size()];
        for (int i = 0; i < resultLong.size(); i++) {
            result[i] = resultLong.get(i);
        }
        return result;
    }*//*


    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
*/
