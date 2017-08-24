package com.tdd.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veraxmedax on 22/08/2017.
 */
public class RecentlyUsedList<T> {
    private List<T> list;

    public RecentlyUsedList() {
        this.list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public T get(int index) {
        return list.get(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("NULL element can not be added");
        }
        if (!list.contains(element)) {
            addToHead(element);
        }
    }

    public void remove(T element) {
        list.remove(element);
    }

    private void addToHead(T element) {
        List<T> tempList = new ArrayList<>();
        tempList.addAll(list);
        list.clear();
        list.add(element);
        list.addAll(tempList);
    }
}
