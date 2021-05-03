package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] nameDate = line.split(" ");
                String dateString = nameDate[nameDate.length - 3] + "/" + nameDate[nameDate.length - 2] + "/" + nameDate[nameDate.length - 1];
                String name = "";
                for (int i = 0; i < nameDate.length - 3; i++) {
                    name += nameDate[i] + " ";

                }
                name = name.substring(0, name.length() - 1);
                /*SimpleDateFormat simple = new SimpleDateFormat("dd M yyyy", Locale.ENGLISH);
                Date date = simple.parse(dateString);*/
                int year = Integer.parseInt(nameDate[nameDate.length - 1]);
                int month = Integer.parseInt(nameDate[nameDate.length - 2]) - 1; //January == 0.
                int day = Integer.parseInt(nameDate[nameDate.length - 3]);
                Calendar birthDay = new GregorianCalendar(year, month, day);
                Person person = new Person(name, birthDay.getTime());
                PEOPLE.add(person);
//                System.out.println(person.getBirthDate());
            }
        }
    }
}
