package com.ourcompany;

import java.util.Random;

public class HowManyTimesTo7 {
    public static void main(String[] args) {

        int myDieRoll1;
        int myDieRoll2;
        int rolls;

        Random randomGenerator = new Random();
        myDieRoll1 = randomGenerator.nextInt(6) + 1;
        myDieRoll2 = randomGenerator.nextInt(6) + 1;
        rolls = myDieRoll1 + myDieRoll2;
        System.out.println(rolls);

        if (rolls == 7)
            rolls++;
            System.out.println(rolls++);
        }
    }

}
