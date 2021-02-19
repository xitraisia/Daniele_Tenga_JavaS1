package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int input;
        do {
            System.out.println("Enter a number between 15 and 32. Please.");
            input = Integer.parseInt(myScanner.nextLine());
        } while (input < 15 || input > 32);
        System.out.println("You entered a " + input);
    }
}
