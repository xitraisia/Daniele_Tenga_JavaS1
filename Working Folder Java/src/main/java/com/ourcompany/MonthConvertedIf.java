package com.ourcompany;

import java.util.Scanner;

public class MonthConvertedIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 12");
        int number = Integer.parseInt(scanner.nextLine());

        if ((number <1) || (number > 12)){
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }
        else if ((number == 1)){
            System.out.println("January");
        }
        else if (number == 2){
            System.out.println("February");
        }
        else if (number == 3){
            System.out.println("March");
        }
        else if (number == 4){
            System.out.println("April");
        }
        else if (number == 5){
            System.out.println("May");
        }
        else if (number == 6){
            System.out.println("June");
        }
        else if (number == 7){
            System.out.println("July");
        }
        else if (number == 8){
            System.out.println("August");
        }
        else if (number == 9){
            System.out.println("September");
        }
        else if (number == 10){
            System.out.println("October");
        }
        else if (number == 11){
            System.out.println("November");
        }
        else if (number == 12){
            System.out.println("December");
        }
    }
}
