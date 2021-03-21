package com.company;
import java.util.Objects;


import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {
    private List<Classmate> classList = new ArrayList<>();


    public void add(Classmate classmate){//add to take in a new Classmate and adds it to the list of classmates.
        classList.add(classmate);
    }
    public Classmate get(int a){//get to take in an int and return the classmate at that index.
        return classList.get(a);
    }

    public List<Classmate> getAll() {//getAll to return the entire list.
        return classList;
    }
}
