package com.company;

import com.company.interfaces.Shape;

import java.util.Scanner;

public class Circle implements Shape{
    Scanner scanner = new Scanner(System.in);

    //Area of circle: A = pi * radius²
    //Perimeter of circle: C = 2 * pi * radius


    private double pi = 3.14141414;
//    private double radius = Integer.parseInt(scanner.nextLine());

    public double perimeter(){
       return 2 * pi ;
    };
    public double area(){
       return pi ;
    };
}
