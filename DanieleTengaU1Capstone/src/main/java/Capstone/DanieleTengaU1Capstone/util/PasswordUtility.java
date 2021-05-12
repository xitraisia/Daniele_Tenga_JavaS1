//package Capstone.DanieleTengaU1Capstone.util;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Scanner;
//
//public class PasswordUtility {
//
//    public static void main(String[] args) {
//        PasswordEncoder enc = new BCryptPasswordEncoder(); //allows us to encode our password
//        Scanner scanner = new Scanner(System.in);
//        do {
//            System.out.println("Enter a password to encode: ");
//            String stringToEncode = scanner.nextLine();
//            String encodedPassword = enc.encode(stringToEncode);
//            System.out.println("An encoded version of " + stringToEncode + " is " + encodedPassword);
//        } while (true);
//    }
//}
