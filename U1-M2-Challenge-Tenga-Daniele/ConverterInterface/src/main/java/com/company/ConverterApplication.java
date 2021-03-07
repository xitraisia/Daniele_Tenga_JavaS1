package com.company;


//i dont know how to instantiate if/else and switch method here
public class ConverterApplication {
    public static void main(String[] args) {
        ConverterSwitch converterSwitch = new ConverterSwitch();
        ConverterIf converterIf = new ConverterIf();

        System.out.println(converterIf.convertDay(2));
        System.out.println(converterIf.convertMonth(2));
        System.out.println(converterSwitch.convertDay(5));
        System.out.println(converterSwitch.convertMonth(25));
    }
}
