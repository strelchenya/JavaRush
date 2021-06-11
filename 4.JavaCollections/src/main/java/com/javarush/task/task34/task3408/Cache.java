package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {

        if (!cache.containsKey(key)) {
            //получаем определённый конструктор, из-за вложенного key.getClass()
            Constructor<V> constructor = clazz.getConstructor(key.getClass());
            //создаём объект на основе коструктора
            V value = constructor.newInstance(key);
            //возвращаем в мапу
            cache.put(key, value);
        }
        return cache.get(key);
    }

    public boolean put(V obj) {

        try {

            //получили ссылку на метод getKey класса obj
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            //получение доступа
            getKey.setAccessible(true);
            //создание объекта на основе метода getKey
            K key = (K) getKey.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (NoSuchMethodException e) {
        } catch (InvocationTargetException e) {
        } catch (IllegalAccessException e) {
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
