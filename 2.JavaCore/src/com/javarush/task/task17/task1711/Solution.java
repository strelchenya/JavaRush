package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    private static SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {
        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 3) {
                            String name = args[i];
                            String sex = args[i + 1];
                            Date date = inputFormat.parse(args[i + 2]);
                            Person person = sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date);
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i = i + 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            String sex = args[i + 2];
                            Date date = inputFormat.parse(args[i + 3]);
                            allPeople.get(id).setName(name);
                            allPeople.get(id).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                            allPeople.get(id).setBirthDate(date);
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            allPeople.get(Integer.parseInt(args[i])).setName(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                        }
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            Person person = allPeople.get(id);
                            System.out.print(person.getName() + " ");
                            System.out.print(person.getSex().equals(Sex.MALE) ? "м " : "ж ");
                            System.out.println(outputFormat.format(person.getBirthDate()));
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
      /*  if (args == null || args.length < 1)
            throw new RuntimeException();

        Date birthdayDate = new Date();
       
        Person person;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        birthdayDate = simpleDateFormat.parse(args[i + 2]);
                        if (args[i + 1].equals("м"))
                            person = Person.createMale(args[i], birthdayDate);
                        else
                            person = Person.createFemale(args[i], birthdayDate);
                        allPeople.add(person);
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int j = 1; j < args.length; j += 4) {
                        birthdayDate = simpleDateFormat.parse(args[j + 3]);
                        int id = Integer.parseInt(args[j]);
                        person = allPeople.get(id);
                        if (person == null)
                            throw new IllegalArgumentException();
                        person.setSex(getSex(args[j + 2]));
                        person.setBirthDate(birthdayDate);
                        person.setName(args[j + 1]);
                        allPeople.set(id, person);
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int k = 1; k < args.length; k++) {
                        Person currentPerson = allPeople.get(Integer.valueOf(args[k]));
                        currentPerson.setName(null);
                        currentPerson.setSex(null);
                        currentPerson.setBirthDate(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int n = 1; n < args.length; n++) {
                        person = allPeople.get(Integer.parseInt(args[n]));
                        if (person != null)
                            System.out.println(person.getName() + " " +
                                    (person.getSex() == Sex.MALE ? "м" : "ж") + " " +
                                    simpleDateFormat2.format(person.getBirthDate()));
                    }
                    break;
                }
        }
    }

    private static Sex getSex(String sexParam) {
        return sexParam.equals("м") ? Sex.MALE : Sex.FEMALE;
    }
}*/