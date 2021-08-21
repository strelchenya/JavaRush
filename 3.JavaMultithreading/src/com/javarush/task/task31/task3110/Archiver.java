package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args) {
// C:\Users\Strelchenya\Desktop\1\zip.zip
// C:\Users\Strelchenya\Desktop\1\all.pdf

        Operation operation = null;

        while (operation != Operation.EXIT){
            try {
                operation = askOperation();
                if (operation != null){
                    CommandExecutor.execute(operation);
                }
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception exception) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }

    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:\n" +
                Operation.CREATE.ordinal() + " - упаковать файлы в архив\n" +
                Operation.ADD.ordinal() + " - добавить файл в архив\n" +
                Operation.REMOVE.ordinal() + " - удалить файл из архива\n" +
                Operation.EXTRACT.ordinal() + " - распаковать архив\n" +
                Operation.CONTENT.ordinal() + " - просмотреть содержимое архива\n" +
                Operation.EXIT.ordinal() + " - выход");

        int numberOperation = ConsoleHelper.readInt();

        switch (numberOperation) {
            case 0:
                return Operation.CREATE;
            case 1:
                return Operation.ADD;
            case 2:
                return Operation.REMOVE;
            case 3:
                return Operation.EXTRACT;
            case 4:
                return Operation.CONTENT;
            case 5:
                return Operation.EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }

}
