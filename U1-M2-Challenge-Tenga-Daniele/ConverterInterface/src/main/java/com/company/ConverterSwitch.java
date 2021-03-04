package com.company;
import com.company.interfaces.Converter;

import java.util.Scanner;

public class ConverterSwitch implements Converter { //we implemented interface converter

    public ConverterSwitch() {

    }

    @Override
    public String convertMonth(int monthNumber) { //these methods come from converter
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 12");
        monthNumber = Integer.parseInt(scanner.nextLine());

        switch (monthNumber) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }

        return null;
    }

    @Override
    public String convertDay(int dayNumber) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 12");
        dayNumber = Integer.parseInt(scanner.nextLine());

        switch (dayNumber) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.");
        }

        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

