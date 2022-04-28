package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class E_20_6 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }
        LinkedList<Integer> linkedList = new LinkedList<>(list);

        long start = System.currentTimeMillis();
        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        long end = System.currentTimeMillis();

        System.out.println("Iterator time :"
                + (end - start) + " millis");

        long getstart = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            linkedList.get(i);
        }
        long getend = System.currentTimeMillis();

        System.out.println("get(index) time :"
                + (getend - getstart) + " millis");
    }
}

