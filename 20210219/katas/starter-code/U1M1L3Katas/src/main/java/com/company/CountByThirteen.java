package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number");
        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= input; i+=13) {
            System.out.println(i);
        }
    }
}