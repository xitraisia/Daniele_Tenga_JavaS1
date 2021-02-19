package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //        The following formula is used to calculate
//        the fixed monthly payment (P) required to fully
//        amortize a loan of L dollars over a term of n
//        months at a monthly interest rate of c. [If the
//        quoted rate is 6%, for example, c is .06/12 or .005].
//        P = L[c(1 + c)n]/[(1 + c)n - 1]

        int loan;
        System.out.println("Input your loan number");
        loan = Integer.parseInt(scanner.nextLine());

        int months;
        System.out.println("Input the length of the loan in months");
        months = Integer.parseInt(scanner.nextLine());

        int interestRate;
        System.out.println("Input the interest rate");
        interestRate = Integer.parseInt(scanner.nextLine());
        interestRate = interestRate % 100;

        int mortgagePayment = loan*(interestRate*(1 + interestRate)*months)/((1 + interestRate)*months - 1);

        System.out.println("This is your mortgage payment");
        System.out.println(mortgagePayment);
    }
}
