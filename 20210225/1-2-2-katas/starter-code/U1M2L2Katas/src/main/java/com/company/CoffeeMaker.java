package com.company;

public class CoffeeMaker {
    public String manufacturer;
    public String model;
    public int carafeSize;
    public int cupsLeft;
    public boolean powered;

    public CoffeeMaker(String manufacturer, String model, int carafeSize, int cupsLeft, boolean powered){
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafeSize;
        this.cupsLeft = cupsLeft;
        this.powered = powered;
    }

    public String getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(String model){
        this.manufacturer = manufacturer;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public int getCarafeSize(){
        return carafeSize;
    }
    public void setCarafeSize (int carafeSize){
        this.carafeSize = carafeSize;
    }
    public int getCupsLeft(){
        return cupsLeft;
    }
    public void setCupsLeft(int cupsLeft){
        this.cupsLeft = cupsLeft;
    }
    public boolean isPowered(){
        return powered;
    }
    public void setPowered(boolean powered){
        this.powered = powered;
    }
}
