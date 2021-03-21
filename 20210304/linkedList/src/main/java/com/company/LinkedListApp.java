package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {

    public static int total(LinkedList<Integer> numbers) { //refactored from using an array to using a list. interface list with object integer is passed through this parameter

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static int totalEven(LinkedList<Integer> numbers) {

        int sum = 0;
        for (int i = 0; i < numbers.size(); i += 2) { //number.size is the length of the list
            sum += numbers.get(i); //numbers.get(i) is like the index in an array
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(LinkedList<String> strings) {

        String temp = strings.get(0); //creating new variable called temp and equalling it to index zero
        strings.set(0, strings.get(strings.size() - 1)); //we made (set) index zero in strings equal to the last index in the list
        strings.set(strings.size() - 1, temp); //we set the last index to temp

        return strings; //returned string
    }

    public static List<Integer> reverse(LinkedList<Integer> numbers) {

        List<Integer> reversed = new ArrayList<>();//

        for (int i = 0; i < numbers.size(); i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            reversed.add(numbers.get(i)); //reversed[i] (the new list that was created) equals last index in numbers array
        }

        return reversed;
    }

    public static List<Integer> lessThanFive(LinkedList<Integer> numbers) {

        List<Integer> lessThan = new ArrayList<>(); //create new instance

        int numLessThanFive = 0; //create new variable

        for (int num : numbers) { //for loop created num inside of the for loop
            if (num < 5) { //if num is less than 5 add num to the new list
                lessThan.add(num);
            }
        }

        if (lessThan.size() > 0) { //if new list size is more than zero return array
            return lessThan;
        } else return null; //else return null
    }

    //challenge
    public static int[][] splitAtFive(int[] numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;

        for (int num : numbers) {
            if (num < 5) {
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

        int[] lessThan = new int[numLessThanFive];
        int[] moreThan = new int[numMoreThanFive];


        for (int num : numbers) {

            // subtracting numLessThanFive from length then decrementing numLessThanFive
            // allows us to go from 0 to length - 1 in order without additional variables
            // same with numMoreThanFive
            if (num < 5) {
                lessThan[lessThan.length - numLessThanFive] = num;
                numLessThanFive--;
            } else {
                moreThan[moreThan.length - numMoreThanFive] = num;
                numMoreThanFive--;
            }
        }

        return new int[][]{lessThan, moreThan};
    }
}
