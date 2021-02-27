package com.company;

public class Kitchen {

    private double squareFootage;
    private double roomLength;
    private double roomWidth;
    private double flooringType;
    private double ceilingHeight;

    public double getSquareFootage(){
        return squareFootage;
    }
    public void setSquareFootage( double sqft){
        this.squareFootage = sqft;
    }
    public double getroomLength(){
        return roomLength;
    }
    public void setRoomLength (double roomLength){
        this.roomLength = roomLength;
    }
    public   double getRoomWidth(){
        return roomWidth;
    }
    public void setRoomWidth  ( double roomWidth){
        this.roomWidth = roomWidth;
    }
    public double getFlooringType(){
        return flooringType;
    }
    public void setFlooringType( double flooringType){
        this.flooringType = flooringType;
    }
    public double getCeilingHeight(){
        return ceilingHeight;
    }
    public void setCeilingHeight(double ceilingHeight){
        this.ceilingHeight = ceilingHeight;
    }
}
