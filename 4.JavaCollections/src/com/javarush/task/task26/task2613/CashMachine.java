package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);


        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] nominalAndQuantity = ConsoleHelper.getValidTwoDigits(currencyCode);
        Integer denomination = Integer.parseInt(nominalAndQuantity[0]);
        Integer count = Integer.parseInt(nominalAndQuantity[1]);


        CurrencyManipulator currencyManipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        currencyManipulator.addAmount(denomination, count);
        System.out.println(denomination + " " + currencyCode + " - " + count);

    }
}
