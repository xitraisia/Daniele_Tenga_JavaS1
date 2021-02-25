package com.company;

import com.company.interfaces.Shape;

public class Square implements Shape{
    private double length;

    public double perimeter(){
        return length + length + length + length;
    }
    public double area(){
        return length * length;
    }
}
