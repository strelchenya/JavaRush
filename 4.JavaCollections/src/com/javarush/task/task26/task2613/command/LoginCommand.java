package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");

    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.login");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {

            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String userNumberCard = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Please enter pin code card:");
            String userPinCodeCard = ConsoleHelper.readString();

            if (userNumberCard.matches("\\d{12}") &&
                    userPinCodeCard.matches("\\d{4}")) {


                if (validCreditCards.containsKey(userNumberCard) &&
                        userPinCodeCard.equals(validCreditCards.getString(userNumberCard))) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), userNumberCard));
                    break;
                }
            }
            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), userNumberCard));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
        }



    }

}
