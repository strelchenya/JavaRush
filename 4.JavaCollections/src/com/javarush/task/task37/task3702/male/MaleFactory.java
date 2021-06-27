package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements Human{

    public Human getPerson(int age) {
        if (age <= KidBoy.MAX_AGE) {
            return new KidBoy();
        } else if (age > KidBoy.MAX_AGE && age <= TeenBoy.MAX_AGE) {
            return new TeenBoy();
        }
        return new Man();
    }
}
