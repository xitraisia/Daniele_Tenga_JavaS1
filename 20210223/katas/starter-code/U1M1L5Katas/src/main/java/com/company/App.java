package com.company;

public class App {
//    public static int total(int [] arr1) {
//        int sum = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            sum += arr1[i];
//        }
//        return sum;
//    }

//    public static int totalOdd(int [] arrayNumbers) {
//        int sum = 0;
//        for (int i = 0; i < arrayNumbers.length; i++) {
//            if (i % 2 != 0){
//                sum += arrayNumbers[i];
//            }
//        }return sum;
//    }

//    public static int totalEven(int [] evenNumbers) {
//        int sum = 0;
//        for (int i = 0; i < evenNumbers.length; i++) {
//            if (i % 2 == 0){
//                sum += evenNumbers[i];
//            }
//        }return sum;
//    }

    public static int secondLargestNumber (int[] array2) {
        int largestNumber = array2[0];
        int secondBiggestNumber = array2[0];

        for (int i = 0; i < array2.length; i++) {
            if (array2[i] > largestNumber){
                secondBiggestNumber = largestNumber;
                largestNumber = array2[i];
            }
            else if (array2[i] > secondBiggestNumber){ //&& array2[i] != largestNumber
                secondBiggestNumber = array2[i];
            }
        } return secondBiggestNumber;
    }

//    public static String swapFirstAndLast(String[] arrayOne) {
//        String temp = arrayOne[0];
//        arrayOne[0] = arrayOne[arrayOne.length - 1];
//        arrayOne[arrayOne.length - 1] = temp;
//
//        for(String i=0; i =< arrayOne.length; i++) {
//            if(i > 0 && arrayOne[i] = 0 && arrayOne[i-1] != 0)
//            {
//                temp = arrayOne[0];
//                arrayOne[0] = arrayOne[arrayOne.length - 1];
//                arrayOne[arrayOne.length - 1] = temp;
//            }
//        }return arrayOne;
//    }

//    public static int reverse(int[] array1, int n) {
//        int index;
//        int firstElement;
//        int secondElement;
//
//
//        for (int i = 0; i < n / 2 ; i++) {
//            index = array1[i];
//            array1[i] = array1[n - i - 1];
//            array1[n - i - 1] = index;
//        } return n;
//    }
//    public static String concatenateString(String[] arrayString) {
//        String concatenate = " ";
//
//        for (int i = 0; i < arrayString.length ; i++) {
//            concatenate = concatenate + arrayString[i];
//        }
//        return concatenate;
//    }

//      public static int everyThird (int[] arrayNew){
//          int newArray = new int[];
//
//          for (int i = 0; i < arrayNew.length; i+=3) {
//              return arrayNew[i];
//          }
//      }

//    public static int lessThanFive (int[] array2){
//        int five = 5;
//        int newArray = 0;
//        for (int i = 0; i < array2.length; i++) {
//            if (array2[i] < five){
//                newArray = array2[i]++;
//            }
//            else if () {
//                return null;
//            }
//
//        }return newArray;
//    }
}
