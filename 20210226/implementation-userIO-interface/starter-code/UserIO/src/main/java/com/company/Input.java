package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO{

    Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt) {
        System.out.println("Input an Integer");
        return Integer.parseInt(scanner.nextLine());
    }
    public long readLong(String prompt) {
        System.out.println("Input a long");
        return Long.parseLong(scanner.nextLine());
    }
    public double readDouble(String prompt) {
        System.out.println("Input a double");
        return Double.parseDouble(scanner.nextLine());
    }
    public float readFloat(String prompt) {
        System.out.println("Input a float");
        float floater = Float.parseFloat(scanner.nextLine());
        return floater;
    }
    public String readString(String prompt) {
        System.out.println("Input a string");
        String stringer = scanner.nextLine();
        return stringer;
    }
}
