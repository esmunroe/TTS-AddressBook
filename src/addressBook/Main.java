package addressBook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int menu() {
        boolean invalid = false;
        int option = 0;
        System.out.println("1) Add an Entry\n" +
                "2) Remove an Entry\n" +
                "3) Search for a Specific Entry\n" +
                "4) Print Address Book\n" +
                "5) Delete Book\n" +
                "6) Quit");
        do {
            try {
                System.out.print("Please choose what you'd like to do with the database: ");
                invalid = false;
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                invalid = true;
                System.out.println("Invalid input! Please try again.");
            }
        } while (invalid || (option < 1 || option > 6));
        scanner.nextLine();
        return option;
    }

    public static void main(String[] args) {

    }
}
