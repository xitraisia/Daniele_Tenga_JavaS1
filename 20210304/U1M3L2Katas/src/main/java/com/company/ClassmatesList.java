package com.company;
import java.util.Objects;


import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {
    List<Classmate> classList = new ArrayList<>();


    public void add(Classmate classmate){
        classList.add(classmate);
    }
    public Classmate get(int a){
        return classList.get(a);
    }

    public List<Classmate> getClassList() {
        return classList;
    }
}
