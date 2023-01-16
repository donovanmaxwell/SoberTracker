import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Menu {

    private boolean exit = false;

    public static void printHeader() {
        System.out.println("************************");
        System.out.println("*    Welcome to the    *");
        System.out.println("*  Sober Tracker App!  *");
        System.out.println("************************");
    }

    private void printMenu() {
        System.out.println("\nPlease make a selection:");
        System.out.println("(1) Check how many days since last drink");
        System.out.println("(0) Exit menu");
    }

    public void runMenu() {
        printHeader();
        while(!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    private int getInput() {
        int choice = -1;
        Scanner kb = new Scanner(System.in);
        while (choice < 0 || choice > 2) {
            try {
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid selection. Please try again.");
            }
        }
        return choice;
    }

    private void performAction(int choice) {
        switch(choice) {
            case 0:
                exit = true;
                System.out.println("Thank you for using the Sober Tracker application.");
                break;
            case 1:
                System.out.println("Please enter the date of your last drink (format as YYYY-MM-DD):");
                checkNumberOfDays();
                break;
            default:
                System.out.println("An unknown error occurred. Please try again.");
                break;
        }
    }

    private LocalDate getDate() {

        Scanner kb = new Scanner(System.in);

        LocalDate date = LocalDate.parse(kb.nextLine());

        return date;
    }

    private void checkNumberOfDays() {

        LocalDate today = LocalDate.now();
        LocalDate lastDrink = getDate();
        long howMany = ChronoUnit.DAYS.between(lastDrink, today);

        System.out.println("Today is: " + today + ". It has been " + howMany + " since your last drink.");
    }
}
