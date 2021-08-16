package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        boolean isExit = true;
        do {

            Operation operation = ConsoleHelper.askOperation();

            switch (operation) {
                case INFO:
                    CommandExecutor.execute(Operation.INFO);
                    break;
                case DEPOSIT:
                    CommandExecutor.execute(Operation.DEPOSIT);
                    break;
                case WITHDRAW:
                    CommandExecutor.execute(Operation.WITHDRAW);
                    break;
                case EXIT:
                    isExit = false;
                    CommandExecutor.execute(Operation.EXIT);
                    break;
            }

        } while (isExit /*!ConsoleHelper.askOperation().equals(Operation.EXIT)*/);


    }
}
