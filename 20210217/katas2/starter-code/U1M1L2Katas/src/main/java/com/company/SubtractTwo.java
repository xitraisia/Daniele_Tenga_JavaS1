package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a number");
        int num1 = Integer.parseInt(scanner.nextLine());

        int product = num1 * 2;
        int sum = product + 5;

        System.out.println(sum);
    }
}
