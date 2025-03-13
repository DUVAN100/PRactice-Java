package views;

import controllers.VeterinarianController;
import dao.VeterinarianDao;
import Models.Veterinarian;
import java.util.List;
import java.util.Scanner;

/**
 * VeterinarianView class provides a simple console-based interface
 * for managing veterinarians.
 * 
 * @author Duvan Yesid Vivaas Bermudez 1002280067
 */
public class VeterinarianView {
    private final VeterinarianController veterinarianController;
    private final Scanner entry;

    public VeterinarianView() {
        this.veterinarianController = new VeterinarianController (new VeterinarianDao());
        this.entry = new Scanner(System.in);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Duvan Yesid Vivas Bermuez ---");
            System.out.println("\n--- 1002280067 ---");
            System.out.println("\n--- Veterinarian management ---");
            System.out.println("1. Add Veterinarian");
            System.out.println("2. View Veterinarian");
            System.out.println("3. View All Veterinarians");
            System.out.println("4. Update Veterinarian");
            System.out.println("5. Delete Veterinarian");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = entry.nextInt();
            entry.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addVeterinarian();
                    break;
                case 2:
                    viewVeterinarian();
                    break;
                case 3:
                    viewAllVeterinarians();
                    break;
                case 4:
                    updateVeterinarian();
                    break;
                case 5:
                    deleteVeterinarian();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 6);
    }

    private void addVeterinarian() {
        System.out.print("Enter name: ");
        String name = entry.nextLine();
        System.out.print("Enter specialty: ");
        String specialty = entry.nextLine();
        System.out.print("Enter email: ");
        String email = entry.nextLine();
        System.out.print("Enter phone: ");
        String phone = entry.nextLine();
        veterinarianController.addVeterinarian(name, specialty, email, phone);
        System.out.println("Veterinarian added successfully.");
    }

    private void viewVeterinarian() {
        System.out.print("Enter Veterinarian ID: ");
        int id = entry.nextInt();
        Veterinarian veterinarian = veterinarianController.getVeterinarianById(id);
        if (veterinarian != null) {
            System.out.println(veterinarian);
        } else {
            System.out.println("Veterinarian not found.");
        }
    }

    private void viewAllVeterinarians() {
        List<Veterinarian> veterinarians = veterinarianController.getAllVeterinarians();
        if (veterinarians.isEmpty()) {
            System.out.println("No veterinarians found.");
        } else {
            for (Veterinarian veterinarian : veterinarians) {
                System.out.println(veterinarian);
            }
        }
    }

    private void updateVeterinarian() {
        System.out.print("Enter Veterinarian ID: ");
        int id = entry.nextInt();
        entry.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String name = entry.nextLine();
        System.out.print("Enter new specialty: ");
        String specialty = entry.nextLine();
        System.out.print("Enter new email: ");
        String email = entry.nextLine();
        System.out.print("Enter new phone: ");
        String phone = entry.nextLine();
        veterinarianController.updateVeterinarian(id, name, specialty, email, phone);
        System.out.println("Veterinarian updated successfully.");
    }

    private void deleteVeterinarian() {
        System.out.print("Enter Veterinarian ID: ");
        int id = entry.nextInt();
        veterinarianController.deleteVeterinarian(id);
        System.out.println("Veterinarian deleted successfully.");
    }
}
