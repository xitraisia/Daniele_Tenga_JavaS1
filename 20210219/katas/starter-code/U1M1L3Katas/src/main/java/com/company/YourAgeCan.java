package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your age?");
        int age = Integer.parseInt(scanner.nextLine());

        if(age >= 18){
            System.out.println("You can vote?");
        }
        else{
            System.out.println("You cannot vote");
        }
        if (age >= 21){
            System.out.println("You can drink alcohol?");
        }
        else {
            System.out.println("You cannot drink alcohol?");
        }
        if (age >= 35){
            System.out.println("You can be the president?");
        }
        else {
            System.out.println("You cannot be the president?");
        }
        if (age >= 55){
            System.out.println("You are eligible for AARP?");
        }
        else {
            System.out.println("You are not eligible for AARP?");
        }
        if (age >= 65){
            System.out.println("You can retire?");
        }
        else {
            System.out.println("You cannot retire?");
        }
        if (age <= 80  age => 89){
            System.out.println("You are an octogenarian?");
        }
        else {
            System.out.println("You are not an octogenarian?");
        }
        if (age >= 100){
            System.out.println("You are more than a century old?");
        }
        else {
            System.out.println("You are not more than a century old?");
        }
    }
}
