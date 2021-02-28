package com.ourcompany;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess a number 1-10");
        int userInput = Integer.parseInt(scanner.nextLine());

        do{
            if ((userInput < 1) || (userInput > 10)) {
                System.out.println("You must enter a number between 1 and 10. Please try again.");
                userInput = Integer.parseInt(scanner.nextLine());
            }
        }while((userInput < 1) || (userInput > 10));
            System.out.println(userInput);
    }
}
