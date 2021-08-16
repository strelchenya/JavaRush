package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

class DepositCommand implements Command{
    @Override
    public void execute() {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] nominalAndQuantity = ConsoleHelper.getValidTwoDigits(currencyCode);
        int denomination = Integer.parseInt(nominalAndQuantity[0]);
        int count = Integer.parseInt(nominalAndQuantity[1]);


        CurrencyManipulator currencyManipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        currencyManipulator.addAmount(denomination, count);
        System.out.println(denomination + " " + currencyCode + " - " + count);
        System.out.println(currencyManipulator.getTotalAmount());
    }
}
