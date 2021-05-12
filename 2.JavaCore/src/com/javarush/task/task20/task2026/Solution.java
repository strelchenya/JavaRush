package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 5");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int column = a.length;
        int row = a[0].length;
        int countRectangle = 0;

        //поиск прямоугольников по нижнему правому углу
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (a[i][j] == 1) {
                    if (j != row - 1 && a[i][j + 1] == 0) {
                        if (i != column - 1 && a[i + 1][j] == 0) countRectangle++;
                    }
                    if (j == row - 1) {
                        if (i == column - 1 || a[i + 1][j] == 0) countRectangle++;
                    }
                    else if (i == column - 1){
                        if (j == row - 1 || a[i][j + 1] == 0) countRectangle++;
                    }
                }
            }
        }

        return countRectangle;
    }
}



        /*
        ----------------------Альтернативное решение-------------------------
        byte[][] b = a;
        int count = 0;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] == 1) {
                    count++;
                    int gor = 1;
                    while (j + gor < b[i].length && b[i][j + gor] == 1) {
                        b[i][j + gor] = 0;
                        gor++;
                    }
                    int vert = 1;
                    while (i + vert < b.length && b[i + vert][j] == 1) {
                        b[i + vert][j] = 0;
                        int gortime = 1;
                        while (gortime != gor) {
                            b[i + vert][j + gortime] = 0;
                            gortime++;
                        }
                        vert++;
                    }
                }
            }

        }
        return count;
    }
}*/
