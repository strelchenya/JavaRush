package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 1)
            throw new RuntimeException();

        Date birthdayDate = new Date();
        Person person;
        switch (args[0]) {
            case "-c":
                birthdayDate = simpleDateFormat.parse(args[3]);

                if (args[2].equals("м"))
                    person = Person.createMale(args[1], birthdayDate);
                else
                    person = Person.createFemale(args[1], birthdayDate);

                allPeople.add(person);
                System.out.println(allPeople.size() - 1);
                break;
            case "-u":
                birthdayDate = simpleDateFormat.parse(args[4]);
                int id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                if (person == null)
                    throw new IllegalArgumentException();
                person.setSex(getSex(args[3]));
                person.setBirthDate(birthdayDate);
                person.setName(args[2]);
                allPeople.set(id, person);
                break;
            case "-d":
                Person currentPerson = allPeople.get(Integer.valueOf(args[1]));
                currentPerson.setName(null);
                currentPerson.setSex(null);
                currentPerson.setBirthDate(null);
                break;
            case "-i":
                person = allPeople.get(Integer.parseInt(args[1]));
                if (person != null)
                    System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + simpleDateFormat2.format(person.getBirthDate()));
                break;
        }
    }

    private static Sex getSex(String sexParam) {
        return sexParam.equals("м") ? Sex.MALE : Sex.FEMALE;
    }
}
/*    public static void main(String[] args) throws IOException, ParseException {
        if (args == null || args.length < 1)
            throw new RuntimeException();
       *//* BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String parameters = reader.readLine();
        String[] parameter = parameters.split(" ");*//*
        String[] parameter = args;

        switch (parameter[0]) {
            case "-c":
                Date dateC = null;
                if (parameter[3] != null) {
                    SimpleDateFormat inputSimpleDateFormat =
                            new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    dateC = inputSimpleDateFormat.parse(parameter[3]);
                }
                *//*String name = "";
                if (!parameter[1].isEmpty() && !parameter[1].matches("[-+]?\\d+")) {// проверка на пустую строку и на то что параметр не число
                    name = parameter[1];
                }*//*
                switch (parameter[2]) {
                    case "м":
                        allPeople.add(Person.createMale(parameter[1], dateC));
//                        System.out.println(allPeople.get(allPeople.size()-1));
                        System.out.println(allPeople.size() - 1);
                        break;
                    case "ж":
                        allPeople.add(Person.createFemale(parameter[1], dateC));
//                        System.out.println(allPeople.get(allPeople.size()-1));
                        System.out.println(allPeople.size() - 1);
                        break;
                }
                break;

            case "-u":
                Date dateU = null;
                if (parameter[4] != null) {
                    SimpleDateFormat inputSimpleDateFormat =
                            new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    dateU = inputSimpleDateFormat.parse(parameter[4]);
                }

               *//* int id = 0;
                if (!parameter[1].isEmpty() && parameter[1].matches("[+]?\\d+")) {// проверка на пустую строку и на то что параметр положительное и целове чило
                    id = Integer.parseInt(parameter[1]); // парсим в целое число
                } else break;*//*
                int idU = Integer.parseInt(parameter[1]);
                switch (parameter[3]) {
                    case "м":
                        allPeople.set(idU, Person.createMale(parameter[2], dateU));//
                        break;
                    case "ж":
                        allPeople.set(idU, Person.createFemale(parameter[2], dateU));//
                        break;
                }
                break;

            case "-d":
                *//*int idD = 0;
                if (!parameter[1].isEmpty() && parameter[1].matches("[+]?\\d+")) {// проверка на пустую строку и на то что параметр положительное и целове чило
                    if (Integer.parseInt(parameter[1]) < allPeople.size()) {
                        idD = Integer.parseInt(parameter[1]); // парсим в целое число
                    }
                } else break;*//*
                int idD = Integer.parseInt(parameter[1]);
                Person person = allPeople.get(idD);
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
//                System.out.println(person.getName());
                break;

            case "-i":
                *//*int idI = 0;
                if (!parameter[1].isEmpty() && parameter[1].matches("[+]?\\d+")) {// проверка на пустую строку и на то что параметр положительное и целове чило
                    if (Integer.parseInt(parameter[1]) < allPeople.size()) {
                        idI = Integer.parseInt(parameter[1]); // парсим в целое число
                    }

                } else break;*//*

                int idI = Integer.parseInt(parameter[1]);
                Person personI = allPeople.get(idI);
                String n = personI.getName();
                String i = (personI.getSex() == Sex.MALE) ? "м" : "ж";
                SimpleDateFormat outputSimpleDateFormat =
                        new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String dateI = outputSimpleDateFormat.format(personI.getBirthDate());
                System.out.println(n + " " + i + " " + dateI);
                break;
            default:
                break;
        }
    }
}*/
