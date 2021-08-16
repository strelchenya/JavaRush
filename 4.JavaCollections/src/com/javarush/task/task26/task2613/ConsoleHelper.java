package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

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

            System.out.println("What operation would you like to perform? " + "\n" +
                    "Enter a number: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT.");

            int number = 0;


            String operation = readString();

            number = Integer.parseInt(operation);

            if (number > 0 && number < 5) {
                return Operation.getAllowableOperationByOrdinal(number);
            }

            System.out.println("You entered an invalid operation! " + "\n" +
                    "Valid operations: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT.");
        }
    }

}
