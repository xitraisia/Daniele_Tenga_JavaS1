package com.company;

import com.company.interfaces.Vehicle;

public class Car implements Vehicle{

    //these are the car properties
    public String make;
    public String model;
    public String milesTraveled;

    //and the associated getters and setters

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(String milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    @Override
    public void displayMilesTraveled() {

    }

    @Override
    public void drive(int miles) {

    }
}
