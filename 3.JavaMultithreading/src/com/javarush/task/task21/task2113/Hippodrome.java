package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        Horse plotva = new Horse("Плотва", 3, 0);
        Horse horseBlack = new Horse("Чернышь", 3, 0);
        Horse horseWhite = new Horse("Облочко", 3, 0);
        game.horses.add(plotva);
        game.horses.add(horseBlack);
        game.horses.add(horseWhite);
        game.run();
        game.getWinner();
        game.printWinner();
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }

    public void move(){
        for (Horse horse: getHorses()) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse: getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        double distance = 0.0;
        Horse horseWinner = null;
        for (Horse horse: horses) {
            if (distance < horse.getDistance()){
                distance = horse.getDistance();
                horseWinner = horse;
            }
        }
        return horseWinner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
