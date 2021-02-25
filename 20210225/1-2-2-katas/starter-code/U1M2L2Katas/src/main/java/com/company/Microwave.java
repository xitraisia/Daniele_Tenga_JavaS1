package com.company;

public class Microwave {
    public String manufacturer;
    public String model;
    public int secondsLeft;
    public String time;
    public boolean running;

    public Microwave(String manufacturer, String model, int secondsLeft, String time, boolean running){
        this.manufacturer = manufacturer;
        this.model = model;
        this.secondsLeft = secondsLeft;
        this.time = time;
        this.running = running;
    }

    public void start(int secondsLeft){
        System.out.println("secondsLeft");
    }
    public void stop(){
        System.out.println("stop");
    }
    public void clear(){
        System.out.println("clear");
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public int getSecondsLeft(){
        return secondsLeft;
    }
    public void setSecondsLeft(int secondsLeft){
        this.secondsLeft = secondsLeft;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public boolean isRunning(){
        return running;
    }
    public void setRunning(boolean running){
        this.running = running;
    }
}
