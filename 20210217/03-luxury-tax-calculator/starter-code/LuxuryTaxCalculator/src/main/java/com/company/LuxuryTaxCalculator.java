package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is Player 1's salary?");
        int salary1 = Integer.parseInt(scanner.nextLine());

        System.out.println("What is Player 2's salary?");
        int salary2 = Integer.parseInt(scanner.nextLine());

        System.out.println("What is Player 3's salary?");
        int salary3 = Integer.parseInt(scanner.nextLine());

        int sum = salary1 + salary2 + salary3;

        System.out.println(sum);

        int luxuryTax = 40000000;

        if(sum > luxuryTax){
            int cost = sum - luxuryTax;
            float taxCost = cost * .18f;
            System.out.println(taxCost);
        }
    }
}
