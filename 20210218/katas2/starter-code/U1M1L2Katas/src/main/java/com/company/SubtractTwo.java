package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a number");
        int num1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Give me a number");
        int num2 = Integer.parseInt(scanner.nextLine());

        int difference = num1 -num2;


        System.out.println(difference);
    }
}
