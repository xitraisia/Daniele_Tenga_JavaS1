package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a number");
        int num1 = Integer.parseInt(scanner.nextLine());


        System.out.println("Give me another number");
        int num2 = Integer.parseInt(scanner.nextLine());

        System.out.println("Give me another number");
        int num3 = Integer.parseInt(scanner.nextLine());

        int product = num1 * num3 * num2;

        System.out.println(product);
    }
}