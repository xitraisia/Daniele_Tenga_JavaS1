package com.company;

import java.util.ArrayList;
import java.util.Collections;                       //implimenting a method is adding a body on the method
import java.util.List;

public class App {

    public static void main(String[] args) {

        ArrayList<Integer> newList1 = new ArrayList<>(5);//we created a new list to put into the method total number
        newList1.add(4);//filled the list up
        newList1.add(3);
        newList1.add(2);
        newList1.add(5);
        newList1.add(4);
        System.out.println(total(newList1));//we then called the method with its parameter (our new list that we created)

        List<Integer> newList = new ArrayList<>();
        newList.add(6);
        newList.add(7);
        newList.add(8);
        //calling a method lessthanfive.. which means just use this method and in order to use this method we need to first create a list because the method takes in a list
        System.out.println(lessThanFive(newList));//calling a method system.out.println()

        ArrayList<Integer> newList2 = new ArrayList<>();
        newList2.add(2);
        newList2.add(4);
        newList2.add(3);
        newList2.add(5);
        newList2.add(10);
        System.out.println(totalEven(newList2));


    }

    public static int total (ArrayList<Integer> numbers) { //refactored from using an array to using a list. interface list with object integer is passed through this parameter

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static int totalEven (ArrayList<Integer> numbers) { //we just implemented the method totaleven

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) { //number.size is the length of the list
            sum += numbers.get(i); //numbers.get(i) is like the index in an array
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(ArrayList<String> strings) {

        String temp = strings.get(0); //creating new variable called temp and equalling it to index zero
        strings.set(0, strings.get(strings.size() - 1)); //we made (set) index zero in strings equal to the last index in the list
        strings.set(strings.size() - 1, temp); //we set the last index to temp

        return strings; //returned string
    }

    public static List<Integer> reverse(ArrayList<Integer> numbers) {

        List<Integer> reversed = new ArrayList<>();//

        for(int i = 0; i < numbers.size(); i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            reversed.add(numbers.get(i)); //reversed[i] (the new list that was created) equals last index in numbers array
        }

        return reversed;
    }

    public static List<Integer> lessThanFive(List<Integer> numbers) {//this takes in a list becasue of list<integer>

        List<Integer>lessThan = new ArrayList<>(); //create new instance

        int numLessThanFive = 0; //create new variable

        for(int num : numbers) { //for loop created num inside of the for loop
            if ( num < 5 ) { //if num is less than 5 add num to the new list
                lessThan.add(num);
            }
        }

        if ( lessThan.size() > 0) { //if new list size is more than zero return array
            return lessThan;
        }else return null; //else return null
    }

    //challenge
    public static int[][] splitAtFive(int[] numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

        int[] lessThan = new int[numLessThanFive];
        int[] moreThan = new int[numMoreThanFive];


        for(int num : numbers) {

            // subtracting numLessThanFive from length then decrementing numLessThanFive
            // allows us to go from 0 to length - 1 in order without additional variables
            // same with numMoreThanFive
            if ( num < 5 ) {
                lessThan[lessThan.length - numLessThanFive] = num;
                numLessThanFive--;
            } else {
                moreThan[moreThan.length - numMoreThanFive] = num;
                numMoreThanFive--;
            }
        }

        return new int[][] { lessThan, moreThan };
    }

    // Challenge
    public static String[][] evensAndOdds(String[] strings) {

        //leveraging integer division
        String[] odds = new String[ strings.length/2 ];

        // Set evens to null for reassignment below
        String[] evens = null;

        // again leveraging integer division
        // if it's already of even length, we're good
        // but if it's of odd length, there's one more even index than odd
        if (strings.length % 2 == 0) {
            evens = new String[ strings.length/2];
        } else {
            evens = new String[ strings.length/2 + 1];
        }

        for(int i = 0; i < strings.length; i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens[currIndex] = strings[i];
            } else {
                odds[currIndex] = strings[i];
            }
        }

        return new String[][] { evens, odds };
    }
}
