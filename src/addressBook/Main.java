package addressBook;

import java.util.InputMismatchException;
import java.util.List;
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

    public static void addEntry(AddressBook addressBook) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.next();

        Entry entry = new Entry(firstName, lastName, phone, email);
        addressBook.addEntry(entry);
    }

    public static void searchMenu(AddressBook addressBook){
        boolean invalid = false;
        int option = 0;

        System.out.println("1) First Name" +
                "2) Last Name" +
                "3) Phone Number" +
                "4) Email Address");

        do {
            try {
                System.out.print("Choose a search type: ");
                invalid = false;
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                invalid = true;
                System.out.println("Invalid input! Please try again.");
            }
        } while (invalid || (option < 1 || option > 4));
        scanner.nextLine();
        System.out.print("Enter your search: ");
        String searchQuery = scanner.nextLine();

        List<Entry> searchResults = null;
        switch (option){
            case 1:
                searchResults = addressBook.searchEntry("first", searchQuery);
                break;
            case 2:
                searchResults = addressBook.searchEntry("last", searchQuery);
                break;
            case 3:
                searchResults = addressBook.searchEntry("phone", searchQuery);
                break;
            case 4:
                searchResults = addressBook.searchEntry("email", searchQuery);
                break;
            default:
                System.out.println("Something went wrong here! searchMenu - Main.java");
        }

        for (Entry entry : searchResults){
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {

    }
}
