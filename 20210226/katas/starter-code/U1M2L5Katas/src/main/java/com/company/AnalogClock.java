package com.company;

import com.company.interfaces.Clock;

public class AnalogClock implements Clock {
    public void displayTime() {
        System.out.println("display time");
    }
    public void timer(int hour, int minute) {
        System.out.println("hour and minute");
    }
}
