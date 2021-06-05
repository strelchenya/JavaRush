package com.javarush.task.task25.task2515;

public class Canvas {

    private int width;
    private int height;
    private char[][] matrix;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }

    public void setPoint(double x, double y, char c) {
        int a = (int) Math.round(x);
        int b = (int) Math.round(y);
        if (((0 <= a && a < matrix[0].length) &&
                (0 <= b && b < matrix.length))) {
                matrix[b][a] = c;
        }

    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0){
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }
}
