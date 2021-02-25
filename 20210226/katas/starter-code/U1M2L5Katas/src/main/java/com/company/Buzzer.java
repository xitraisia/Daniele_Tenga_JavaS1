package com.company;

import com.company.interfaces.Alarm;

public class Buzzer implements Alarm{

    public void sound() {
        System.out.println("Alarm!!!!!");
    }
}
