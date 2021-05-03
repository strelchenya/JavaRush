package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        //создаем мапу, ключ - чар (символ алфавита), велью - сколько раз встречается буква в строках
        HashMap<Character, Integer> map = new HashMap<>();
        //перебираем все строки из алфавита
        for (Character ch : alphabet){
            //по умолчанию для всех буков ставим велью = 0
            map.put(ch, 0);
        }

        //перебираем все строки из листа строк по порядку
        for(String str : list){
            //перебираем все символы из строки по порядку
            //* строку преобразуем в строку только из маленьких букв
            //* строку преобразуем в массив символов
            for(Character ch :  str.toLowerCase().toCharArray()){

                //если буква есть в алфавите...
                if (alphabet.contains(ch)){
                    //...то из мапы достаем по этому ключу значение (метод ГЕТ)
                    //прибавляем 1
                    //кладем обратно по ключу (метод ПУТ)
                    map.put(ch, map.get(ch).intValue() + 1);
                }
            }
        }

        //печатаем
        for(Character ch : alphabet){
            System.out.printf("%s\t%d%n",ch, map.get(ch).intValue() );
        }

        //Character[] alpha = alphabet.toArray(new Character[alphabet.size()]);
        /*int[] numbers = new int[alphabet.size()];
        int count = 1;

        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < alphabet.size(); j++) {
                    if (s.charAt(i) == alphabet.get(j)) {
                        numbers[j] = numbers[j] + count;
                    }
                }
            }
        }

        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + numbers[i]);
        }*/

    }
}
