package main;

import views.ClientView;
import views.VeterinarianView;
import java.util.Scanner;

/**
 * Main class that provides a menu to navigate between
 * client and veterinarian management.
 * 
 * @author Duvan Yesid Vivaas Bermudez 1002280067
 */
public class Main {
    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Duvan Yesid Vivas Bermuez ---");
            System.out.println("\n--- 1002280067 ---");
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Client Menu");
            System.out.println("2. Veterinarian Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            while (!entry.hasNextInt()) { 
                System.out.println("Invalid input. Please enter a number.");
                entry.next();
            }
            option = entry.nextInt();
            switch (option) {
                case 1:
                    ClientView clientView = new ClientView();
                    clientView.showMenu();
                    break;
                case 2:
                    VeterinarianView veterinarianView = new VeterinarianView();
                    veterinarianView.showMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 3);

        entry.close();
    }
}
