package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {

        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

        Date date1 = new Date(date); //создание нового объекта даты на основе String data
        SimpleDateFormat ff = new SimpleDateFormat("D");//задаётся формат для даты,
        //"D"-номер дня в году
        int x = Integer.parseInt(ff.format(date1));// применяем формат к  дате
        //и преобразуем к типу int
        return x % 2 != 0;      //проверка на нечётность и возвращение значения типа boolean






        /*------------------------------------------------
        //выравниваем формат значения получаймой строки date
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        // конвертим стринг в дату
        Date yearStartTime = dateFormat.parse(date);
        yearStartTime.setHours(0); // обнуляем в дате час
        yearStartTime.setMinutes(0); // обнуляем в дате минуты
        yearStartTime.setSeconds(0); // обнуляем в дате секунды

        yearStartTime.setDate(1); // выставляем в дате число на 1ое января
        yearStartTime.setMonth(0); // месяц январь, нумерация для месяцев 0-11

        Date newDate = dateFormat.parse(date); // дата получаймая с main конвертнутая со стрианга в дату
        long daysM = newDate.getTime() - yearStartTime.getTime();
        long a = 24 * 60 * 60 * 1000 + 1; //сколько миллисекунд в одних сутках
        int dayCount = (int) (daysM/a); //количество целых дней
        if (dayCount % 2 != 0) return true;
        else return false;*/

    }
}



