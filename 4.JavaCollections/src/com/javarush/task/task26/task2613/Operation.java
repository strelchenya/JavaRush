package com.javarush.task.task26.task2613;

public enum Operation {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        switch (i) {
            case 1:
                return Operation.values()[0];
            case 2:
                return Operation.values()[1];

            case 3:
                return Operation.values()[2];

            case 4:
                return Operation.values()[3];

            default:
                throw new IllegalArgumentException();

        }
    }

}
