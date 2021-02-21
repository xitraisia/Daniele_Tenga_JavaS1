package com.ourcompany;

import java.util.Random;

public class HowManyTimesTo7 {
    public static void main(String[] args) {

        int myDieRoll1;
        int myDieRoll2;
        int rolls;
        int counter = 0;
        int firstSeven = 0;
        Random randomGenerator = new Random();

        for (int i = 1; i <= 100; i++) {
            myDieRoll1 = randomGenerator.nextInt(6) + 1;
            myDieRoll2 = randomGenerator.nextInt(6) + 1;
            rolls = myDieRoll1 + myDieRoll2;
            System.out.println(rolls);

            if (rolls == 7) {
                counter++;
                if(firstSeven == 0){
                    firstSeven = i;
                }
            }
        }System.out.println("This is how many times you rolled a 7 " + counter);
         System.out.println("This is how many times it took us to roll a 7: " + firstSeven);
    }
}


