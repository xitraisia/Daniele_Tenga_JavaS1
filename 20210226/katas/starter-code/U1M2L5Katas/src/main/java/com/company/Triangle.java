package com.company;

import com.company.interfaces.Shape;

import java.util.Scanner;

public class Triangle implements Shape{
    Scanner scanner = new Scanner(System.in);

    private double base;
    private double height;
    private double sideA;
    private double sideB;
    //Area of triangle: A = (base * height) / 2

    public double perimeter(){
        return sideA + sideB + height;
    };
    public double area(){
        return (base * height)/2;
    };
}
