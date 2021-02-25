package com.company;

import com.company.interfaces.Alarm;
import com.company.interfaces.Clock;

public class DigitalClock implements Clock, Alarm{
    public void displayTime() {
        System.out.println("display time");
    }
    public void timer(int hour, int minute) {
        System.out.println("hour and minute");
    }
    public void sound() {
        System.out.println("Alarm!!!!!");
    }
}
