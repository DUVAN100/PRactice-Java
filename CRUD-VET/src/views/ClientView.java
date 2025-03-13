package views;

import controllers.ClientController;
import dao.ClientDao;
import Models.Client;
import java.util.List;
import java.util.Scanner;

/**
 * ClientDao class provides CRUD operations for the Client model.
 * 
 * @author Duvan Yesid Vivaas Bermudez 1002280067
 */

public class ClientView {
    private final ClientController clientController;
    private final Scanner entry;

    public ClientView() {
        this.clientController = new ClientController(new ClientDao()); 
        this.entry = new Scanner(System.in);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Duvan Yesid Vivas Bermuez ---");
            System.out.println("\n--- 1002280067 ---");
            System.out.println("\n--- Client Managemen ---");
            System.out.println("1. Add Client");
            System.out.println("2. View Client");
            System.out.println("3. View All Clients");
            System.out.println("4. Update Client");
            System.out.println("5. Delete Client");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = entry.nextInt();
            entry.nextLine(); 

            switch (option) {
                case 1:
                    addClient();
                    break;
                case 2:
                    viewClient();
                    break;
                case 3:
                    viewAllClients();
                    break;
                case 4:
                    updateClient();
                    break;
                case 5:
                    deleteClient();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 6);
    }

    private void addClient() {
        System.out.print("Enter the name: ");
        String name = entry.nextLine();
        System.out.print("Enter the email: ");
        String email = entry.nextLine();
        System.out.print("Enter the phone: ");
        String phone = entry.nextLine();
        System.out.print("Enter the address: ");
        String address = entry.nextLine();
        clientController.addClient(name, email, phone, address);
        System.out.println("Client added successfully...");
    }

    private void viewClient() {
        System.out.print("Enter Client ID: ");
        int id = entry.nextInt();
        Client client = clientController.getClientById(id);
        if (client != null) {
            System.out.println(client);
        } else {
            System.out.println("Client not found.");
        }
    }

    private void viewAllClients() {
        List<Client> clients = clientController.getAllClients();
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            for (Client client : clients) {
                System.out.println(client);
            }
        }
    }

    private void updateClient() {
        System.out.print("Enter Client ID: ");
        int id = entry.nextInt();
        entry.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String name = entry.nextLine();
        System.out.print("Enter new email: ");
        String email = entry.nextLine();
        System.out.print("Enter new phone: ");
        String phone = entry.nextLine();
        System.out.print("Enter new address: ");
        String address = entry.nextLine();
        clientController.updateClient(id, name, email, phone, address);
        System.out.println("Client updated successfully.");
    }

    private void deleteClient() {
        System.out.print("Enter Client ID: ");
        int id = entry.nextInt();
        clientController.deleteClient(id);
        System.out.println("Client deleted successfully.");
    }
}
