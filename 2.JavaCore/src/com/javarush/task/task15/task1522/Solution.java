package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
       // System.out.println(thePlanet);
    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String consoleInput = reader.readLine();
        switch (consoleInput) {
            case Planet.EARTH:
                thePlanet = Earth.getInstance();
                break;
            case Planet.MOON:
                thePlanet = Moon.getInstance();
                break;
            case Planet.SUN:
                thePlanet = Sun.getInstance();
                break;
            default:
                thePlanet = null;
                break;
        }
        /*String s;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            s = reader.readLine();
            if (s.equals(Planet.SUN)) thePlanet = Sun.getInstance();
            else if (s.equals(Planet.MOON)) thePlanet = Moon.getInstance();
            else if (s.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
            else thePlanet = null;
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
