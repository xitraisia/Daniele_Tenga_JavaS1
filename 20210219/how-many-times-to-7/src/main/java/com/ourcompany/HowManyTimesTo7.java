package com.ourcompany;

import java.util.Random;

public class HowManyTimesTo7 {
    public static void main(String[] args) {

        int myDieRoll1;
        int myDieRoll2;
        int rolls;
        int counter = 0;
        int numberLoops = 0;
        Random randomGenerator = new Random();

        for (int i = 0; i < 100; i++) {
            myDieRoll1 = randomGenerator.nextInt(6) + 1;
            myDieRoll2 = randomGenerator.nextInt(6) + 1;
            rolls = myDieRoll1 + myDieRoll2;
            System.out.println(rolls);

            numberLoops++;

            if (rolls == 7) {
                counter++;
            }
        }System.out.println("This is how many times you rolled a 7 " + counter);
         System.out.println("This is how many times it took us to roll a 7 " + numberLoops);
    }
}


