package com.javarush.task.task18.task1827;

/*Прайсы
        CrUD для таблицы внутри файла.
        Считать с консоли имя файла для операций CrUD.

        Программа запускается со следующим набором параметров:
        -c productName price quantity

        Значения параметров:
        где id - 8 символов.
        productName - название товара, 30 символов.
        price - цена, 8 символов.
        quantity - количество, 4 символа.
        -c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

        В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
        id productName price quantity

        Данные дополнены пробелами до их длины.

        Пример:
        19846   Шорты пляжные синие           159.00  12
        198478  Шорты пляжные черные с рисунко173.00  17
        19847983Куртка для сноубордистов, разм10173.991234


        Требования:
        1. Программа должна считать имя файла для операций CrUD с консоли.
        2. В классе Solution не должны быть использованы статические переменные.
        3. При запуске программы без параметров список товаров должен остаться неизменным.
        4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
        5. Товар должен иметь следующий id, после максимального, найденного в файле.
        6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
        7. Созданные для файлов потоки должны быть закрыты.*/

/*import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //получаем имя файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "d:\\1.txt";
        reader.close();

        if (args.length == 4) {
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];

            if (args[0].equals("-c")) {
                //ищем максимальный id в файле и получаем следующий id
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                int maxID = 0;
                while (true) {
                    String s = fileReader.readLine();
                    if (s == null) break;
                    int idFromFile = Integer.parseInt(s.substring(0, 8).trim());
                    if (idFromFile > maxID) {
                        maxID = idFromFile;
                    }
                }
                String id = "" + (maxID + 1);

                //Добить id до 8 символов
                while (id.length() < 8) {
                    id += " ";
                }

                //Добить productName до 30 сиволов
                while (productName.length() < 30) {
                    productName += " ";
                }

                //Добить price до 8 символов
                while (price.length() < 8) {
                    price += " ";
                }

                //Добить quantity до 4 символов
                while (quantity.length() < 4) {
                    quantity += " ";
                }

                //строим строку для записи в файл
                String finalString = id + productName + price + quantity;

                //записываем в файл
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
                fileWriter.newLine();
                fileWriter.write(finalString);

                //закрываем потоки
                fileReader.close();
                fileWriter.close();
            }
        }

    }
}*/
/* ----------------------------РЕШЕНИЕ ВАЛИ----------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class Product {
        int id;
        String name;
        String price;
        String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Product> products = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                Product product = getProduct(fileReader.readLine());
                products.add(product);
            }
        }

        switch (args[0]) {
            case "-c":
                int id = 0;
                for (Product product : products) {
                    if (product.id > id) id = product.id;
                }
                String name = "";
                for (int i = 1; i < args.length - 2; i++) {
                    name += args[i] + " ";
                }
                if (name.length() > 30) {
                    name = name.substring(0, 30);
                }
                String price = args[args.length - 2];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }
                String quantity = args[args.length - 1];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }
                Product product = new Product(++id, name.trim(), price, quantity);
                products.add(product);
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Product product : products) {
                fileWriter.write(product.toString());
                fileWriter.write("\n");
            }
        }
    }

    public static Product getProduct(String string) {
        String id = string.substring(0, 8).trim();
        String name = string.substring(8, 38).trim();
        String price = string.substring(38, 46).trim();
        String quantity = string.substring(46, 50).trim();
        return new Product(Integer.parseInt(id), name, price, quantity);
    }
}*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 4) return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        BufferedReader readerFile = new BufferedReader(new FileReader(nameFile));

        if (args[0].equals("-c") && args[1].equals("") && args[2].equals("") && args[3].equals("")) {

            ArrayList<Integer> ids = new ArrayList<>();
            String s = null;
            while ((s = readerFile.readLine()) != null) {
                s = s.substring(0, 8).trim(); // обрезка до id
                int id = Integer.parseInt(s); // парсим в число
                ids.add(id); // добавляем в массив чисел
            }
            int idMax = Collections.max(ids); // находим в листе максимальное значение id
            int idNext = idMax + 1; // создаём следуюшее id
            String idStr = String.valueOf(idNext); //переводим в строку новый id
            while (idStr.length() != 8) idStr = idStr + " "; // создан окончательный id по шаблону до 8 символов

            String productName = args[1]; // устанавливаем переменную productName
            while (productName.length() < 30) productName = productName + " ";
            if (productName.length() > 30) productName = productName.substring(0, 30);

            String price = args[2]; // устанавливаем переменную price
            if (price.indexOf(".") == -1) price = price + ".00";
            else if (price.indexOf(".") != -1) {
                StringBuilder cent = new StringBuilder(price.trim()); // выделяю центы (удаляя пробелы) и корректирую под шаблон
                cent.delete(0, price.indexOf(".") + 1); // отбрасываю все символы включительно с точкой
                if (cent.length() == 0) cent.append("00");
                else if (cent.length() == 1) cent.append("0");
                else if (cent.length() > 2) cent.delete(0, 2);
                StringBuilder priceStringBuilder = new StringBuilder(price); // выделяю целые числа
                priceStringBuilder.delete(price.indexOf(".") + 1, price.length());// выделяю целые числа вместе с точкой
                priceStringBuilder.append(cent); // добавляю центы
                price = priceStringBuilder.toString(); // перевожу в строку
                while (price.length() < 8) price = price + " "; // добавляю до 8 символов, если нужно
            }
            String quantity = args[3]; //выделено количество
            while (quantity.length() < 4) quantity = quantity + " ";
            if (quantity.length() > 4) {
                StringBuilder quantityStringBuilder = new StringBuilder(quantity);
                quantityStringBuilder.delete(5, quantity.length());
                quantity = quantityStringBuilder.toString();
            }
            String line = idStr + productName + price + quantity;

            BufferedWriter writerFile = new BufferedWriter(new FileWriter(nameFile, true));
            writerFile.newLine();
            if (line.length() == 50) writerFile.write(line);
            writerFile.close();
        }
        readerFile.close();
    }

}
