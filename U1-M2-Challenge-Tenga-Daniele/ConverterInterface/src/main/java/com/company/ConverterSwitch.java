package com.company;
import com.company.interfaces.Converter;

import java.util.Scanner;

public class ConverterSwitch implements Converter { //we implemented interface converter

    public ConverterSwitch() {
    }

    @Override
    public String convertMonth(int monthNumber) { //these methods come from converter
        String month = " ";

        switch (monthNumber) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
        }

        return month;
    }

    @Override
    public String convertDay(int dayNumber) {
        String month = " ";

        switch (dayNumber) {
            case 1:
                month = "Sunday";
                break;
            case 2:
                month = "Monday";
                break;
            case 3:
                month = "Tuesday";
                break;
            case 4:
                month = "Wednesday";
                break;
            case 5:
                month = "Thursday";
                break;
            case 6:
                month = "Friday";
                break;
            case 7:
                month = "Saturday";
                break;
            default:
                month = "You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.";
        }
        return month;
    }

    @Override
    public String toString() {
        return "ConverterSwitch{}";
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

