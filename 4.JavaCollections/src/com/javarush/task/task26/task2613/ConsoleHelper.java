package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common");

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String line = "";
        try {
            line = bis.readLine();

        } catch (IOException e) {

        }

        if (line.toLowerCase().equals("exit")) {
            throw new InterruptOperationException();
        }
        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            System.out.println("Enter currency code:");

            String currencyCode = readString().toUpperCase();

            if (currencyCode.length() == 3) {
                return currencyCode;
            }

            System.out.println("The data is incorrect, please re-enter the data.");
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            System.out.println("Enter nominal and quantity:");
            String nominalAndQuantity = readString();

            if (nominalAndQuantity.matches("^\\d+ \\d+$")) {
                String[] value = nominalAndQuantity.split(" ");
                return value;
            }
            System.out.println("The data is incorrect, please re-enter the data." + currencyCode);
        }
    }

    public static Operation askOperation() throws InterruptOperationException {

        while (true) {

            ConsoleHelper.writeMessage(res.getString("choose.operation"));
            ConsoleHelper.writeMessage("\t 1 - " + res.getString("operation.INFO"));
            ConsoleHelper.writeMessage("\t 2 - " + res.getString("operation.DEPOSIT"));
            ConsoleHelper.writeMessage("\t 3 - " + res.getString("operation.WITHDRAW"));
            ConsoleHelper.writeMessage("\t 4 - " + res.getString("operation.EXIT"));
            Integer i = Integer.parseInt(ConsoleHelper.readString().trim());
            try {
                return Operation.getAllowableOperationByOrdinal(i);
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }

}
