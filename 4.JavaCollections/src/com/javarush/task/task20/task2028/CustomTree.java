package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    //    List<Entry<String>> listEntry = new LinkedList<>();
    Entry<String> root;
    //    static List<Entry<String>> listEntry = new ArrayList<>();
    int countEntry = 0;

    public CustomTree() {
        this.root = new Entry("0");
        root.parent = root;
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        Entry<String> entrySting = new Entry<>(s);
        while (!queue.isEmpty()) {
            Entry<String> entry = queue.poll();
            if (entry.isAvailableToAddChildren()) {
                if (entry.availableToAddLeftChildren) {
                    entry.leftChild = entrySting;
                    entry.availableToAddLeftChildren = false;
                    entrySting.parent = entry;
//                    listEntry.add(entrySting);
                    countEntry++;
                    return true;
                }
                if (entry.availableToAddRightChildren) {
                    entry.rightChild = entrySting;
                    entry.availableToAddRightChildren = false;
                    entrySting.parent = entry;
                    countEntry++;
                    return true;
                }
            }

        }


        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {

        return this.countEntry;
    }

    public String getParent(String s) {

        return "1";
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public Entry(String elementName, Entry leftChild, Entry rightChild) {
            this.elementName = elementName;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;

        }

    }
}
