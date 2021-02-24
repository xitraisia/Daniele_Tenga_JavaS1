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
//
//        public static int secondLargestNumber(int [] arrayNumber) {
//            int largestNumber = Integer.MIN_VALUE;
//            int secondBiggestNumber = Integer.MIN_VALUE;
//
//            for (int i = 0; i < arrayNumber.length; i++) {
//                if (arrayNumber[i] > largestNumber) {
//                    secondBiggestNumber = largestNumber;
//                    largestNumber = arrayNumber[i];
//                } else if (arrayNumber[i] > secondBiggestNumber) {
//                    secondBiggestNumber = arrayNumber[i];
//                }
//            }return secondBiggestNumber;
//        }
//
//    public static String[] swapFirstAndLast(String[] arrayOne) {
//        String storeOfValue = arrayOne[0];
//        arrayOne[0] = arrayOne[arrayOne.length - 1];
//        arrayOne[arrayOne.length-1] = storeOfValue;
//
//        return arrayOne;
//    }
//
//        public static int reverse ( int[] array1, int n){
//            int index;
//            int firstElement;
//            int secondElement;
//
//
//            for (int i = 0; i < n / 2; i++) {
//                index = array1[i];
//                array1[i] = array1[n - i - 1];
//                array1[n - i - 1] = index;
//            }
//            return n;
//        }
//
//    public static String concatenateString(String[] arrayString) {
//        String concatenate = "";
//
//        for (int i = 0; i < arrayString.length ; i++) {
//            concatenate = concatenate + arrayString[i];
//        }
//        return concatenate;
//    }

      public static int everyThird (int[] arrayNew){
          int[] newArray;
          int counter = 0;

          for (int i = 0; i < arrayNew.length; i+=3) {
              counter = counter + arrayNew[i];
              return counter;
          }
          return newArray[counter];
      }
//
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
