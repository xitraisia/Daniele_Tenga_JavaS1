package com.company.com.company.abstractapproach;

import java.util.Objects;

public abstract class Shape {
    public String name;
    public String color;
    public double x_coordination;
    public double y_coordination;

    public Shape(String name, String color, double x_coordination, double y_coordination) {
        this.name = name;
        this.color = color;
        this.x_coordination = x_coordination;
        this.y_coordination = y_coordination;
    }
    public abstract double area();
    public abstract double perimeter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getX_coordination() {
        return x_coordination;
    }

    public void setX_coordination(double x_coordination) {
        this.x_coordination = x_coordination;
    }

    public double getY_coordination() {
        return y_coordination;
    }

    public void setY_coordination(double y_coordination) {
        this.y_coordination = y_coordination;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", x_coordination=" + x_coordination +
                ", y_coordination=" + y_coordination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Double.compare(shape.x_coordination, x_coordination) == 0 && Double.compare(shape.y_coordination, y_coordination) == 0 && Objects.equals(name, shape.name) && Objects.equals(color, shape.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, x_coordination, y_coordination);
    }
}
