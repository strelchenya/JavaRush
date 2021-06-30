package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int count = 0;
        for (Map.Entry<K, List<V>> element: map.entrySet()) {
            count += element.getValue().size();
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        List<V> keyList = null;
        if (map.get(key) != null){
            keyList = new ArrayList<>(map.get(key));
            if (keyList.size() == repeatCount){
                keyList.remove(0);
            }
            keyList.add(value);
        }else {
            keyList = new ArrayList<>();
            keyList.add(value);
        }

        if (map.containsKey(key) && keyList.size() < repeatCount){

            map.put(key, keyList);
            return keyList.get(keyList.size()-2);
        }
        else if (keyList.size() == repeatCount){
            map.put(key, keyList);
            return keyList.get(keyList.size()-2);
        }

        map.put(key, keyList);
        if (map.get(key).size()-1 == 0){
            return null;
        }
       return  keyList.get(keyList.size()-2);
    }

    @Override
    public V remove(Object key) {
        V v = null;
        if (map.containsKey(key) && map.get(key).size() !=0){
            v = map.get(key).get(0);
        }

        if (!map.containsKey(key)){
            return null;
        }
        if (map.get(key).size() > 1){
            map.get(key).remove(0);
            return v;
        }
        map.remove(key);
        return null;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        return  null;
    }

    @Override
    public boolean containsKey(Object key) {

        //напишите тут ваш код
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}