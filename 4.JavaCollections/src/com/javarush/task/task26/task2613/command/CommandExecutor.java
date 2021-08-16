package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> ALL_KNOWN_COMMANDS_MAP = new HashMap<>();

    static {
        ALL_KNOWN_COMMANDS_MAP.put(Operation.DEPOSIT, new DepositCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.WITHDRAW, new WithdrawCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.INFO, new InfoCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXIT, new ExitCommand());
    }


    private CommandExecutor() {
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        ALL_KNOWN_COMMANDS_MAP.get(operation).execute();
    }
}
