package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {
    public void printSet(int a, int b, int c, int d, int e){//Returns nothing. Takes in five integers as its arguments.

        Set<Integer> numbers = new HashSet<>(); //Adds those integers into a new HashSet.
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        numbers.add(d);
        numbers.add(e);

        Iterator itr = numbers.iterator();//Uses an Iterator to print all members of the HashSet.
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
