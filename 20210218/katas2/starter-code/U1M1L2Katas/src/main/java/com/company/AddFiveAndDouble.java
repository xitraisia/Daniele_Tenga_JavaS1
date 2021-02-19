package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a number");
        int num1 = Integer.parseInt(scanner.nextLine());

        int sum = num1 + 5;
        int product = sum * 2;

        System.out.println(product);
    }
}
