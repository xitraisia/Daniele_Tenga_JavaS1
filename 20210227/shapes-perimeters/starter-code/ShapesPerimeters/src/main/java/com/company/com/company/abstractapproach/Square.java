package com.company.com.company.abstractapproach;

public class Square extends Shape {

    public Square(String name, String color, double x_coordination, double y_coordination) {
        super(name, color, x_coordination, y_coordination);
    }

    public double area() { //implementing the abstract method from the parent class shape
        //calculate the area of a circle
        return 0;
    }

    public double perimeter() {
        //calculate the perimeter of a circle
        return 0;
    }
}
