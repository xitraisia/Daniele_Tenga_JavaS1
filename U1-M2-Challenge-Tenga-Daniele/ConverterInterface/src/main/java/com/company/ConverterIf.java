package com.company;
import com.company.interfaces.Converter;

import java.util.Objects;
import java.util.Scanner;

public class ConverterIf implements Converter {

    @Override
    public String convertMonth(int monthNumber) { //we are returning a string so we must output a string hence the string month = ""; variable
        String month = " ";

        if ((monthNumber <1) || (monthNumber > 12)){
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }
        else if ((monthNumber == 1)){
            month = "January";
        }
        else if (monthNumber == 2){
            month = "February";
        }
        else if (monthNumber == 3){
            month = "March";
        }
        else if (monthNumber == 4){
            month ="April";
        }
        else if (monthNumber == 5){
            month = "May";
        }
        else if (monthNumber == 6){
            month = "June";
        }
        else if (monthNumber == 7){
            month = "July";
        }
        else if (monthNumber == 8){
            month = "August";
        }
        else if (monthNumber == 9){
            month = "September";
        }
        else if (monthNumber == 10){
            month = "October";
        }
        else if (monthNumber == 11){
            month = "November";
        }
        else {
            month = "December";
        }
        return month;
    }

    @Override
    public String convertDay(int dayNumber) {
        String month = " ";

        if ((dayNumber <1) || (dayNumber > 7)){
            month = "You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.";
        }
        else if ((dayNumber == 1)){
            month = "Sunday";
        }
        else if (dayNumber == 2){
            month = "Monday";
        }
        else if (dayNumber == 3){
            month = "Tuesday";
        }
        else if (dayNumber == 4){
            month = "Wensday";
        }
        else if (dayNumber == 5){
            month = "Thursday";
        }
        else if (dayNumber == 6){
            month = "Friday";
        }
        else  {
            month = "Saturday";
        }

        return month;
    }

    public ConverterIf() {
    }

    @Override
    public String toString() {
        return "ConverterIf{}";
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
