package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\GitHub\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(null, null));
        System.out.println(logParser.getNumberOfUserEvents("Amigo", null, new Date()));
        System.out.println(logParser.getUsersForIP("127.0.0.1", null, null));
        System.out.println(logParser.getLoggedUsers(null, null));
        System.out.println(logParser.getDownloadedPluginUsers(null, new Date()));

    }
}