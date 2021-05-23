package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    List<Entry<String>> nodesCount = new ArrayList<>();
    Entry<String> root;
    List<Entry<String>> nodes = new ArrayList<>();
    int countEntry = 0;
    Entry<String> lastNode;


    public CustomTree() {
        this.root = new Entry("0");
        nodes.add(root);
        lastNode = nodes.get(0);
        nodesCount.add(root);
    }

    @Override
    public boolean add(String s) {

        Entry<String> child = new Entry<>(s);
        nodesCount.add(child);

        if (lastNode.availableToAddLeftChildren) {

            lastNode.leftChild = child;
            lastNode.availableToAddLeftChildren = false;
            countEntry++;
            nodes.add(child);
            child.parent = lastNode;


            if (!lastNode.isAvailableToAddChildren()) {
                nodes.remove(0);
                lastNode = nodes.get(0);
            }

            return true;
        }

        if (lastNode.availableToAddRightChildren) {

            lastNode.rightChild = child;
            lastNode.availableToAddRightChildren = false;
            countEntry++;
            nodes.add(child);
            child.parent = lastNode;

            if (!lastNode.isAvailableToAddChildren()) {
                nodes.remove(0);
                lastNode = nodes.get(0);
            }

            return true;
        }


        return true;
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
        String returnName = null;
        for (Entry<String> entry: nodesCount ) {
            if (s.equals(entry.elementName)){
                returnName = entry.parent.elementName;
                break;
            }
        }
        return returnName;
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
