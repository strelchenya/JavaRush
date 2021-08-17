package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            ConsoleHelper.writeMessage("Please enter the amount:");

            String correctData = ConsoleHelper.readString();

            if (correctData.matches("^\\d+$")){

                int expectedAmount = Integer.parseInt(correctData);
                if (currencyManipulator.isAmountAvailable(expectedAmount)){

                    Map<Integer, Integer> valueQuantity = new TreeMap<>(Comparator.reverseOrder());

                    try {
                        valueQuantity = currencyManipulator.withdrawAmount(expectedAmount);
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage("There is not enough money in the account.");
                    }

                    for (Map.Entry<Integer, Integer> entry: valueQuantity.entrySet()) {
                        ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
                    }

                    ConsoleHelper.writeMessage("Successful transaction.");

                    break;
                }
            }

            ConsoleHelper.writeMessage("You entered incorrect data. Please repeat.");
        }
    }
}
