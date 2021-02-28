package com.ourcompany;

import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = new String[5];

        System.out.println(" Enter 5 words");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLine();
        }

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);

    }
}
