package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the width?");
        int width = Integer.parseInt(scanner.nextLine());

        System.out.println("What is the length?");
        int length = Integer.parseInt(scanner.nextLine());

        int area = width * length;
        System.out.println("The area of the driveway is " + area + "feet");

        int perimeter = width + width + length + length;
        System.out.println("The perimeter of the driveway is " + perimeter+ "feet");

        float cement = 12.50f * area;
        System.out.println("The cost of the cement is $" + cement);

        float framing = 8.25f * perimeter;
        System.out.println("The cost of the framing is $" + framing);
    }
}

