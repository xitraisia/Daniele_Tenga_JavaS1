package com.ourcompany;

public class SomeMath {
    public static void main(String[] args) {

        int resultTotal = total5(1,2,3,4,5);
        System.out.println(resultTotal);

        double resultAverage = average5(1,3,5,7,9);
        System.out.println(resultAverage);

        double resultlargest = largest5(42.0, 35.1, 2.3, 40.2, 15.6);
        System.out.println(resultlargest);
    }
    public static int total5( int a, int b, int c, int d, int e){
        int sum = a + b + c + d + e;
        return sum;
    }
    public static int average5( int a, int b, int c, int d, int e){
        int average = (a + b + c + d + e)/5;
        return average;
    }
    public static double largest5( double a, double b, double c, double d, double e){
        double largest = Math.max(a,b);
        double largest2 = Math.max(largest, c);
        double largest3 = Math.max(largest2, d);
        double largest4 = Math.max(largest3, e);
        return largest4;
    }
}
