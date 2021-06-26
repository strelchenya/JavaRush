package com.javarush.task.task35.task3512;

import java.lang.reflect.Constructor;

public class Generator<T> {
    Class<T> tClass;
    public Generator(Class<T> tClass) {
        this.tClass = tClass;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return tClass.newInstance();
    }
}
