package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number.");
        int input = Integer.parseInt(scanner.nextLine());

        while(input == 42) {
            System.out.println("Enter a number.");
            String thingToRepeat = scanner.nextLine();
        }
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }

        int input;
        do {
            System.out.println("Enter a number.");
            input = Integer.parseInt(scanner.nextLine());
        } while (input == 42);
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");

    }
}
