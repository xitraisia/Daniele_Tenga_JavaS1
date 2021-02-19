package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a number");
        int num1 = Integer.parseInt(scanner.nextLine());


        System.out.println("Give me another number");
        int num2 = Integer.parseInt(scanner.nextLine());

        System.out.println("Give me another number");
        int num3 = Integer.parseInt(scanner.nextLine());

        System.out.println("Give me another number");
        int num4 = Integer.parseInt(scanner.nextLine());

        System.out.println("Give me another number");
        int num5 = Integer.parseInt(scanner.nextLine());

        int sum = num1 + num2 + num3 + num4 +num5;


        System.out.println(sum);
    }
}
