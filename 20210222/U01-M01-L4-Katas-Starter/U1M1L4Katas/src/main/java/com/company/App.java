package com.company;

public class App {


	// subtract
    public static int subtract(int a, int b) {
        return a -  b;
    }


	// subtractOrZero
    public static int subtractOrZero(int a, int b){
        int difference = a - b;
        if (difference < 0){
            return 0;
        }
        return difference;
    }


	// max
    public static int max(int a, int b, int c){
        int maxNumber = Math.max(a,b);
        int maxNumber2 = Math.max(maxNumber, c);
        return maxNumber2;
    }



	// min
    public static int min(int a, int b, int c){
        int minNumber = Math.min(a,b);
        int minNumber2 = Math.min(minNumber, c);
        return minNumber2;
    }


	// isLarger
    public static boolean isLarger(int first, int second){
        if(first > second){
            return true;
        }
        return false;
    }



}
