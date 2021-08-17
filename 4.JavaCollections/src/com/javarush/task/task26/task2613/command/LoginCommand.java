package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");


    @Override
    public void execute() throws InterruptOperationException {

        while (true) {

            ConsoleHelper.writeMessage("Please enter number card:");
            String userNumberCard = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Please enter pin code card:");
            String userPinCodeCard = ConsoleHelper.readString();

            if (userNumberCard.matches("\\d{12}") &&
                    userPinCodeCard.matches("\\d{4}")) {


                if (validCreditCards.containsKey(userNumberCard) &&
                        userPinCodeCard.equals(validCreditCards.getString(userNumberCard))) {
                    ConsoleHelper.writeMessage("Success!");
                    break;
                }
            }

        }

        ConsoleHelper.writeMessage("Your card number and card pin code are not correct.");
    }

}
