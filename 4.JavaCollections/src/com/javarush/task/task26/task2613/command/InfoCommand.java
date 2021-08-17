package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.List;
import java.util.ResourceBundle;

class InfoCommand implements Command {

    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.info");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        
        List<CurrencyManipulator> manipulators =
                (List<CurrencyManipulator>) CurrencyManipulatorFactory.getAllCurrencyManipulators();

             if (manipulators.size() == 0){
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }

        for (CurrencyManipulator currencyManipulator : manipulators) {
            if (currencyManipulator.hasMoney()) {
                System.out.println(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
            } else {
                ConsoleHelper.writeMessage(res.getString("no.money"));

            }
        }

    }
}
