package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String language;
        do {
            System.out.println("Type your favorite programing language.");
            language = scanner.nextLine();
        } while (language.equals("Java"));
        System.out.println("That's what I was looking for! Java is definitely the answer!");
    }
}