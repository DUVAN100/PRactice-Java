package library;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenuMain() {
        System.out.println("--- Main Menu ---");
        System.out.println("1. Menu Library");
        System.out.println("2. Menu User");
        System.out.println("3. Management Relations");
        System.out.println("0. Exit");
    }

    public int getOptionMenuMain() {
        System.out.print("Type option: ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid option, please try again.");
            scanner.nextLine(); 
            return getOptionMenuMain();
        }
    }

    public void showMenuLibrary() {
        System.out.println("--- Library Menu ---");
        System.out.println("1. Add book");
        System.out.println("2. Remove book"); //sin funcionalidad
        System.out.println("3. Search book"); //sin funcionalidad
        System.out.println("4. List all books");
        System.out.println("0. Back to main menu");
    }

    public void showMenuUser() {
        System.out.println("--- User Menu ---");
        System.out.println("1. Add user");
        System.out.println("2. Remove user"); //sin funcionalidad
        System.out.println("3. Search user"); //sin funcionalidad
        System.out.println("4. List all users");
        System.out.println("0. Back to main menu");
    }

    public void showMenuManagementRelations() {
        System.out.println("--- Management Relations Menu ---");
        System.out.println("1. Add borrowing");
        System.out.println("2. Remove borrowing");
        System.out.println("3. Search borrowing"); //sin funcionalidad
        System.out.println("4. List all borrowings");
        System.out.println("0. Back to main menu");
    }
}
