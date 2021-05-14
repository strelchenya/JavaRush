package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> result = detectAllWords(crossword, "home", "same", "u");
        for (Word w : result) {
            System.out.println(w);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }
   /* public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String s :words) {
            for (int i = 0; i <crossword.length ; i++) {
                for (int j = 0; j <crossword[i].length ; j++) {
                    if (s.charAt(0) == crossword[i][j]) {
                        Word w = new Word(s);
                        w.setStartPoint(j,i);
                        // указываем координаты за пределами массива, чтобы потом отфильтровать слова (есть первая буква, но нет слова полностью)
                        w.setEndPoint(-1,-1);
                        Solution solution = new Solution();
                        // вызываем findLast который проверяет слово и устанавливает координаты последней буквы
                        solution.findLast(crossword, w, w.startX, w.startY, 1,  0,  1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1,  0, -1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1,  1,  0);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, -1,  0);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, -1, -1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1, -1,  1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1,  1,  1);
                        solution.findLast(crossword, w, w.startX, w.startY, 1,  1, -1);
                        // если слово имеет корректные координаты добавляем в список
                        if (w.endX!=-1&& w.endY!=-1) list.add(w);
                    }
                }
            }
        }
        return list;
    }
    // передаем массив, обьект, координаты первой буквы, номер символа text который проверяем, направление смещения
    public void findLast(int[][] crossword, Word w, int startX, int startY, int z, int x, int y){
        try{
            // если символ с заданным смещением равен следующему символу в text - продолжаем проверку
            if(crossword[startY+y][startX+x]==w.text.charAt(z)) {
                // если проверили последний символ в text устанавливаем ему endX и endY
                if (z==w.text.length()-1) {w.setEndPoint(startX + x, startY + y);}
                else
                    // метод вызывает сам себя с новыми параметрами
                    findLast(crossword,w,startX+x ,startY+y,++z,x,y);
            } }
        catch (ArrayIndexOutOfBoundsException e){}
    }*/

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> wordArray = new ArrayList<>();
        int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

        //проверяем входящее слово в метод
        for (String s : words) {
            //разбиваем слово на массив символов
            char[] c = s.toCharArray();
            //перебираем матрицу двойным фором
            for (int y = 0; y < crossword.length; y++) {
                for (int x = 0; x < crossword[0].length; x++) {
                    //начинаем поиск, если первый символ в слове совпадает с символом в ячейке
                    if (crossword[y][x] == c[0]) {
                        //ищем направление слова от первого символа, верх-вниз, влево, вправо и 4 стороны диагонали
                        for (int i = 0; i < dx.length; i++) {
                            //по умолчанию wordFound тру если слово наглось
                            boolean wordFound = true;
                            //перебираем все символы в слове, начиная со второго символа
                            for (int j = 1; j < c.length; j++) {
                                //1. Если
                                if (y + dy[i] * j < 0 || y + dy[i] * j >= crossword.length ||
                                        x + dx[i] * j < 0 || x + dx[i] * j >= crossword[y + dy[i] * j].length ||
                                        crossword[y + dy[i] * j][x + dx[i] * j] != c[j]) {
                                    wordFound = false;
                                    break;
                                }
                            }
                            if (wordFound) {
                                //добавить найденое слово с координатами первого и споследнего символа
                                Word w = new Word(s);
                                w.setStartPoint(x, y);
                                w.setEndPoint(x + dx[i] * (c.length - 1), y + dy[i] * (c.length - 1));
                                wordArray.add(w);
                                //если в слове только один символ, то выйти из цикла
                                if (c.length == 1)  break;
                            }

                        }
                    }
                }
            }
        }
        return wordArray;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

        /*ArrayList<Word> result = new ArrayList<>();
        int hor = crossword[0].length;
        int ver = crossword.length;

        outer:
        for (String s : words) {
            //по горизонтали
            for (int i = 0; i < ver; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < hor; j++)
                    sb.append((char) crossword[i][j]);

                String horLine = sb.toString();
                if (horLine.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(horLine.indexOf(s), i);
                    word.setEndPoint(horLine.indexOf(s) + s.length() - 1, i);

                    result.add(word);
                    continue outer;
                }
                String horReverse = sb.reverse().toString();
                if (horReverse.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(hor - horReverse.indexOf(s) - 1, i);
                    word.setEndPoint(hor - horReverse.indexOf(s) - s.length(), i);

                    result.add(word);
                    continue outer;
                }
            }
            //по вертикали
            for (int i = 0; i < hor; i++) {
                StringBuilder sb = new StringBuilder();
                for (int[] aCrossword : crossword)
                    sb.append((char) aCrossword[i]);

                String horLine = sb.toString();
                if (horLine.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, horLine.indexOf(s));
                    word.setEndPoint(i, horLine.indexOf(s) + s.length() - 1);

                    result.add(word);
                    continue outer;
                }
                String horReverse = sb.reverse().toString();
                if (horReverse.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, ver - horReverse.indexOf(s) - 1);
                    word.setEndPoint(i, ver - s.length() - horReverse.indexOf(s));

                    result.add(word);
                    continue outer;
                }
            }

            //по диагонали вправо
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < hor; j++) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();
                    while (iTemp < ver && jTemp < hor) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp++;
                    }
                    String horLine = sb.toString();
                    if (horLine.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j + horLine.indexOf(s), i + horLine.indexOf(s));
                        word.setEndPoint(j + horLine.indexOf(s) + s.length() - 1, i + horLine.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp - 1 - horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp - horReverse.indexOf(s) - s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }
                }
            }

            //по диагонали влево
            for (int i = 0; i < ver; i++) {
                for (int j = hor - 1; j >= 0; j--) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();
                    while (iTemp < ver && jTemp >= 0) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp--;
                    }

                    String horLine = sb.toString();
                    if (horLine.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j - horLine.indexOf(s), i + horLine.indexOf(s));
                        word.setEndPoint(j - horLine.indexOf(s) - s.length() + 1, i + horLine.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp + 1 + horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp + horReverse.indexOf(s) + s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }
                }
            }
        }

        System.out.println(result);

        return result;
    }*/


