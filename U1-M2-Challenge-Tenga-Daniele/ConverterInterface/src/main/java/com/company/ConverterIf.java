package com.company;
import com.company.interfaces.Converter;

import java.util.Scanner;

public class ConverterIf implements Converter {

    @Override
    public String convertMonth(int monthNumber) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 12");
        monthNumber = Integer.parseInt(scanner.nextLine());

        if ((monthNumber <1) || (monthNumber > 12)){
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }
        else if ((monthNumber == 1)){
            System.out.println("January");
        }
        else if (monthNumber == 2){
            System.out.println("February");
        }
        else if (monthNumber == 3){
            System.out.println("March");
        }
        else if (monthNumber == 4){
            System.out.println("April");
        }
        else if (monthNumber == 5){
            System.out.println("May");
        }
        else if (monthNumber == 6){
            System.out.println("June");
        }
        else if (monthNumber == 7){
            System.out.println("July");
        }
        else if (monthNumber == 8){
            System.out.println("August");
        }
        else if (monthNumber == 9){
            System.out.println("September");
        }
        else if (monthNumber == 10){
            System.out.println("October");
        }
        else if (monthNumber == 11){
            System.out.println("November");
        }
        else {
            System.out.println("December");
        }
        return null;
    }

    @Override
    public String convertDay(int dayNumber) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 7");
        dayNumber = Integer.parseInt(scanner.nextLine());

        if ((dayNumber <1) || (dayNumber > 7)){
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.");
        }
        else if ((dayNumber == 1)){
            System.out.println("Sunday");
        }
        else if (dayNumber == 2){
            System.out.println("Monday");
        }
        else if (dayNumber == 3){
            System.out.println("Tuesday");
        }
        else if (dayNumber == 4){
            System.out.println("Wensday");
        }
        else if (dayNumber == 5){
            System.out.println("Thursday");
        }
        else if (dayNumber == 6){
            System.out.println("Friday");
        }
        else  {
            System.out.println("Saturday");
        }

        return null;
    }
    public ConverterIf(){

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
