package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");
        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= input; i++) {
            System.out.println(i);
        }
    }
}
