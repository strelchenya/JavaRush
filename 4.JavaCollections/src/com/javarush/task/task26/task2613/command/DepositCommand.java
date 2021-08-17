package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;


class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit");

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] nominalAndQuantity = ConsoleHelper.getValidTwoDigits(currencyCode);
        int denomination = Integer.parseInt(nominalAndQuantity[0]);
        int count = Integer.parseInt(nominalAndQuantity[1]);

        CurrencyManipulator currencyManipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        currencyManipulator.addAmount(denomination, count);

        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denomination, currencyCode));
//        System.out.println(denomination + " " + currencyCode + " - " + count);
        ConsoleHelper.writeMessage(res.getString("invalid.data"));
//        System.out.println(currencyManipulator.getTotalAmount());
    }
}
