package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        /*int i, j;

        for (i = 2; i <= n; i++) {
            int k = 0;

            for (j = 2; j <= i; j++) {
                if ((i % j) == 0)
                    k++;
            }
            if (k < 2) {
                if (n % i == 0) {
                    *//*if (n == i) {
                        System.out.print(i + " ");
                        break;
                    }*//*
                    System.out.print(i + " ");
                    recurse(n / i);
                    break;
                }
            }

        }*/


        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
    }
}
