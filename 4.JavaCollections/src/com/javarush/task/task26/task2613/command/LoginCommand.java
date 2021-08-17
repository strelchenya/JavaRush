package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

public class LoginCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {

        final String numberCard = "123456789012";
        final String pinCode = "1234";

        while (true) {

            ConsoleHelper.writeMessage("Please enter number card:");
            String userNumberCard = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Please enter pin code card:");
            String userPinCodeCard = ConsoleHelper.readString();

            if (userNumberCard.matches("\\d{12}") &&
                    userPinCodeCard.matches("\\d{4}")) {

                if (numberCard.equals(userNumberCard) && pinCode.equals(userPinCodeCard)){
                    ConsoleHelper.writeMessage("Success!");
                    break;
                }
            }

            ConsoleHelper.writeMessage("Your card number and card pin code are not correct.");
        }
    }
}
