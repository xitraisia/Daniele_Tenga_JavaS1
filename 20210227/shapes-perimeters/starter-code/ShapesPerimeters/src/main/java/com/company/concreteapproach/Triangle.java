package com.company.concreteapproach;

public class Triangle extends Shape{

    public double height;
    public double base;
    public double side;

    public Triangle(double height, double base, double side, String name, String color, double x_coordination, double y_coordination) {
        super(name, color, x_coordination, y_coordination);
        this.height = height;
        this.base = base;
        this.side = side;
    }
    public double area() {
        return 0;
    }

    public double perimeter() {
        return 0;
    }
}
