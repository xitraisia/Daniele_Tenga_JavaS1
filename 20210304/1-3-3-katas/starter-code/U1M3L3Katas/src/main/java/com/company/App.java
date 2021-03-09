package com.company;

import java.util.*;
import java.util.Map;

public class App {
    public void printKeys(Map<String, String> map) {//Create a method called printKeys that takes in a Map with string keys and string values. Keys represent the ticket to the coat
        Set<String> myKeys = map.keySet();//set represents a collection of keys that contains no duplicates
        for (String key : myKeys) {//Make String key equal mykeys. iterates through and prints out all keys in the Map
            System.out.println(key);//and prints out all keys in the Map
        }
    }
    public void printValues(Map<String,String> map) {
        Collection<String> myValues = map.values();// collection is a group of elements or values that may or may not duplicate. values represent the coat
        for (String value: myValues) { //make value (String) equal myValue
            System.out.println(value);
        }
    }
    public void printKeysAndValues(Map<String,String> map){
        Set<Map.Entry<String,String>> myEntrySet = map.entrySet();//This set iterates through map.entries
            for (Map.Entry<String,String> entrySet : myEntrySet){//entrySet was a new variable of mapEntry<String,String> element that we made equal my entry set
                System.out.println(entrySet.getKey() + ":" + entrySet.getValue());//Print the keys and values in the Map in the following format: key: value
        }
    }
    public Map<String, Integer> mapFun(Map<String, Integer> map) {//Takes in a Map with string keys and integer values.
        map.put("Ford Explorer", 2012);//Adds two new entries to the Map—a 2012 Ford Explorer and a 2013 Smart Fortwo.
        map.put("Smart Fortwo", 2013);

        map.remove("Jeep Wrangler");//Removes the Jeep Wrangler from the Map.

        return map;//Returns a new Map with string keys and integer values.
    }
    public Map<String, List<Car>> listCars(List<Car> cars) {//Create a method called listCars, which takes in a List of Car objects and does the following:
        List<Car> toyotaList = new ArrayList<>();//Creates a List called toyotaList
        List<Car> fordList = new ArrayList<>();//Creates a List called fordList
        List<Car> hondaList = new ArrayList<>();//Creates a List called hondaList

        for(Car car: cars) {
            if (car.getMake().equals("Toyota")) {//hold all the Car variables with "Toyota" as the make and add them to the list.
                toyotaList.add(car);
            } else if (car.getMake().equals("Ford")) {//hold all the Car variables with "Ford" as the make and add them to the list.
                fordList.add(car);
            } else if (car.getMake().equals("Honda")) {//hold all the Car variables with "Honda" as the make and add them to the list.
                hondaList.add(car);
            }
        }

        Map<String, List<Car>> carMap = new HashMap<>();//Stores all three Lists in a Map with the make as the key.

        carMap.put("Toyota", toyotaList);
        carMap.put("Ford", fordList);
        carMap.put("Honda", hondaList);

        return carMap;//Returns the Map.
    }

}
