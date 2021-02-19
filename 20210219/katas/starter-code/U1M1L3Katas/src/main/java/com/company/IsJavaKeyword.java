package com.company;

import java.util.Locale;
import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a word.");
        System.out.println("abstract");
        System.out.println("assert");
        System.out.println("boolean");
        System.out.println("break");
        System.out.println("byte");
        System.out.println("case");
        System.out.println("catch");
        System.out.println("char");
        System.out.println("class");
        System.out.println("continue");
        System.out.println("const");
        System.out.println("default");
        System.out.println("do");
        System.out.println("double");
        System.out.println("else");
        System.out.println("enum");

        String keyword = scanner.nextLine();
        keyword = keyword.toLowerCase();

        switch (keyword) {
            case "abstract":
                System.out.println("This is a keyword");
                break;
            case "assert":
                System.out.println("This is a keyword");
                break;
            case "boolean":
                System.out.println("This is a keyword");
                break;
            case "break":
                System.out.println("This is a keyword");
                break;
            case "byte":
                System.out.println("This is a keyword");
                break;
            case "case":
                System.out.println("This is a keyword");
                break;
            case "catch":
                System.out.println("This is a keyword");
                break;
            case "char":
                System.out.println("This is a keyword");
                break;
            case "class":
                System.out.println("This is a keyword");
                break;
            case "continue":
                System.out.println("This is a keyword");
                break;
            case "const":
                System.out.println("This is a keyword");
                break;
            case "default":
                System.out.println("This is a keyword");
                break;
            case "do":
                System.out.println("This is a keyword");
                break;
            case "double":
                System.out.println("This is a keyword");
                break;
            case "else":
                System.out.println("This is a keyword");
                break;
            case "enum":
                System.out.println("This is a keyword");
                break;
            default:
                System.out.println("This is not a valid keyword!");
        }
    }
}
