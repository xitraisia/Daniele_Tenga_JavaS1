package com.company;  //test fails automatically because of sometbing about how I should be greeting the user and also i couldnt get the number of guesses to display properly

import java.util.Scanner; //randomly generates a number
import java.util.Random; //reads users input

public class HiLo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random randomGenerator = new Random();
        int randomGuess; //random computer generated number to 100
        int userGuess;
        int numberGuesses = 0;
        String name;

        System.out.println("Welcome to Hi-Low!");

        System.out.println("Input your Name");
        name = scanner.nextLine();
        System.out.println("OK, " + name + ", here are the rules:");

        randomGuess = randomGenerator.nextInt(100) + 1;
        do {
            System.out.println("Guess a number 1-100");
            userGuess = Integer.parseInt(scanner.nextLine());

            if (userGuess < randomGuess) {
                System.out.println("Too Low!");
                userGuess = Integer.parseInt(scanner.nextLine());
            } else if (userGuess > randomGuess) {
                System.out.println("Too High!");
                userGuess = Integer.parseInt(scanner.nextLine());
            }
            numberGuesses = numberGuesses + 1;

        } while (userGuess != randomGuess);  //couldn't get the number of guesses to display properly
            System.out.println("Congratulations, " + name + "! You win!");
            System.out.println("It took you " + numberGuesses + " guesses to find my number!");

    }
}

