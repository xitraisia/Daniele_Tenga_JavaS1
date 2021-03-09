package com.company;

import java.util.*;
import java.util.Map;

public class App {
    public void printKeys(Map<String, String> map) {//Create a method called printKeys that takes in a Map with string keys and string values
        Set<String> myKeys = map.keySet();//set represents a collection that contains no duplicates
        for (String key : myKeys) {//iterates through and prints out all keys in the Map
            System.out.println(key);//and prints out all keys in the Map
        }
    }
}
