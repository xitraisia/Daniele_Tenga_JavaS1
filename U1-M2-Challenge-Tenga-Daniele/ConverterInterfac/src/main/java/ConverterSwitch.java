import java.util.Scanner;

public class ConverterSwitch implements Converter{
    @Override
    public String convertMonth(int monthNumber) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 12");
        monthNumber = Integer.parseInt(scanner.nextLine());

        switch (monthNumber) {
            case 1:
                return "January";
            break;
            case 2:
                return "February";
            break;
            case 3:
                return "March";
            break;
            case 4:
                return "April";
            break;
            case 5:
                return "May";
            break;
            case 6:
                return "June";
            break;
            case 7:
                return "July";
            break;
            case 8:
                return "August";
            break;
            case 9:
                return "September";
            break;
            case 10:
                return "October";
            break;
            case 11:
                return "November";
            break;
            case 12:
                return "December";
            break;
            default:
                return "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
        }
    }

    public String convertDay(int dayNumber) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 7");
        dayNumber = Integer.parseInt(scanner.nextLine());

        switch (dayNumber) {
            case 1:
                return "Sunday";
            break;
            case 2:
                return "Monday";
            break;
            case 3:
                return "Tuesday";
            break;
            case 4:
                return "Wednesday";
            break;
            case 5:
                return "Thursday";
            break;
            case 6:
                return "Friday";
            break;
            case 7:
                return "Saturday";
            break;
            default:
                return "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";
        }
    }
}
