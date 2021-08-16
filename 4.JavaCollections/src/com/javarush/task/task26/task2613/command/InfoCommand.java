package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.List;

class InfoCommand implements Command {

    @Override
    public void execute() {
        List<CurrencyManipulator> manipulators =
                (List<CurrencyManipulator>) CurrencyManipulatorFactory.getAllCurrencyManipulators();

        if (manipulators.size() == 0){
            System.out.println("No money available.");
        }

        for (CurrencyManipulator currencyManipulator : manipulators) {
            if (currencyManipulator.hasMoney()) {
                System.out.println(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
            } else {
                System.out.println("No money available.");

            }
        }

    }
}
