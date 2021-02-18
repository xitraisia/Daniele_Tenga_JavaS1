package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your First name?");
        String firstName = scanner.nextLine();

        System.out.println("What is your Last name?");
        String lastName = scanner.nextLine();

        System.out.println("What is your email?");
        String email = scanner.nextLine();

        System.out.println("What is your twitter handle?");
        String twitterHandle = scanner.nextLine();

        System.out.println("What is your Age?");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("What country are you from?");
        String country = scanner.nextLine();

        System.out.println("What is your profession?");
        String profession = scanner.nextLine();

        System.out.println("What is your favorite operating system?");
        String operatingSystem = scanner.nextLine();

        System.out.println("What is your favorite programing language?");
        String programmingLanguage = scanner.nextLine();

        System.out.println("What is your favorite computer scientist?");
        String computerScientist = scanner.nextLine();

        System.out.println("What is your favorite keyboard shortcut?");
        String shortcut = scanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        String build = scanner.nextLine();

        System.out.println("If you could be a superhero who would you be?");
        String superHero = scanner.nextLine();

        System.out.println(firstName +" "+ lastName);
        System.out.println(email);
        System.out.println(twitterHandle);
        System.out.println(age);
        System.out.println(country);
        System.out.println(profession);
        System.out.println(operatingSystem);
        System.out.println(programmingLanguage);
        System.out.println(computerScientist);
        System.out.println(shortcut);
        System.out.println(build);
        System.out.println(superHero);
    }
}
