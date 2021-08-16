package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String line = "";
        try {
            line = bis.readLine();
        } catch (IOException e) {

        }
        return line;
    }

    public static String askCurrencyCode() {
        while (true) {
            System.out.println("Enter currency code:");

            String currencyCode = readString().toUpperCase();
            if (currencyCode.length() == 3) {
                return currencyCode;
            }

            System.out.println("The data is incorrect, please re-enter the data.");
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) {
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

    public static Operation askOperation() {

        while (true) {

            System.out.println("What operation would you like to perform? " + "\n" +
                    "Enter a number: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT.");

            int number = 0;

            try {
                number = Integer.parseInt(bis.readLine());
            } catch (IOException e) {
            }

            if (number > 0 && number < 5) {
               return Operation.getAllowableOperationByOrdinal(number);
            }

            System.out.println("You entered an invalid operation! " + "\n" +
                    "Valid operations: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT.");
        }
    }

}
