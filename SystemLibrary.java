
package projectlibrary;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//import java.util.Stack;
import java.util.*;

/**
 *
 * @author usuario
 */
public class ProjectLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String[]> books = new ArrayList<>();
        LinkedList<String[]> users = new LinkedList<>();
        Stack<String[]> booksP = new Stack<>();
        Queue<String[]> queue = new LinkedList<>();
        Scanner entrance = new Scanner(System.in);
        int option;
        do {
            System.out.println("Duvan Yesid Vivas Bermudez");
            System.out.println("================================");
            System.out.println("    SYSTEM MANAGEMENT LIBRARY   ");
            System.out.println("================================");
            System.out.println("1_ Add book ");
            System.out.println("2_ Register user ");
            System.out.println("3_ Lend book");
            System.out.println("4_ Return book ");
            System.out.println("5_ Show books available ");
            System.out.println("6_ Show users registred ");
            System.out.println("7_ Close program");
            System.out.println(" Select option ");
            
            while (!entrance.hasNextInt()) {
                System.out.println("Error: please type a valid value!!");
                entrance.nextLine();
                System.out.println("Select option");
            }
            option = entrance.nextInt();
            entrance.nextLine(); 

            switch (option) {
                case 1: 
                    // Add book
                    System.out.println("Write the Id of the book: ");
                    String idLibro = entrance.nextLine();
                    boolean isDuplicated = false;
                    for (String[] book : books) {
                        if (book[0].equals(idLibro)) {
                            isDuplicated = true;
                            break;
                        }
                    }
                    if (isDuplicated) {
                        System.out.println("Error: This Id already exists.");
                    } else {
                        System.out.println("Write the name of the book: ");
                        String nameBook = entrance.nextLine();
                        System.out.println("Enter the author of the book: ");
                        String nameAuthor = entrance.nextLine();
                        books.add(new String[]{idLibro, nameBook, nameAuthor});
                        System.out.println("Book has been added successfully!");
                    }
                    break;
                case 2: 
                    // Register user
                    System.out.println("Write the CC or ID number: ");
                    while (!entrance.hasNextInt()) {
                        System.out.println("Error: please type a valid value!!");
                        entrance.nextLine();
                        System.out.println("Enter CC number: ");
                    }
                    int ccUser = entrance.nextInt();
                    entrance.nextLine(); 
                    System.out.println("Enter the user's first name: ");
                    String nameUser = entrance.nextLine();
                    System.out.println("Enter the user's last name: ");
                    String lastName = entrance.nextLine();
                    boolean isDuplicatedCC = false;
                    for (String[] user : users) {
                        if (user[0].equals(String.valueOf(ccUser))) {
                            isDuplicatedCC = true;
                            break;
                        }
                    }
                    if (isDuplicatedCC) {
                        System.out.println("Error: This CC already exists.");
                    } else {
                        users.add(new String[]{String.valueOf(ccUser), nameUser, lastName});
                        System.out.println("User has been registered successfully!");
                    }
                    break;

                case 3: 
                    // Lend book
                    System.out.println("Enter the book Id to lend: ");
                    String lendBookId = entrance.nextLine();
                    boolean foundBook = false;
                    for (String[] book : books) {
                        if (book[0].equals(lendBookId)) {
                            booksP.push(book);  
                            books.remove(book); 
                            foundBook = true;
                            System.out.println("Book lent successfully.");
                            break;
                        }
                    }
                    if (!foundBook) {
                        System.out.println("Book not available at the moment. Enter your CC number to be added to the waiting queue:");
                        String userCC = entrance.nextLine();
                        queue.add(new String[]{lendBookId, userCC});
                        System.out.println("You have been added to the waiting list for the book.");
                    }
                    break;
                case 4: 
                    // Return book
                    if (!booksP.isEmpty()) {
                        String[] returnedBook = booksP.pop();
                        books.add(returnedBook);
                        System.out.println("Book returned successfully.");
                        if (!queue.isEmpty()) {
                            String[] waitingUser = queue.peek(); 
                            if (waitingUser[0].equals(returnedBook[0])) {
                                System.out.println("The book is now available for the user with CC: " + waitingUser[1]);
                                queue.remove(); 
                            }
                        }
                    } else {
                        System.out.println("No books have been lent out.");
                    }
                    break;
                case 5: 
                    // Show available books
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("Available books:");
                        for (String[] book : books) {
                            System.out.println("Id: " + book[0] + ", Name: " + book[1] + ", Author: " + book[2]);
                        }
                    }
                    break;
                case 6: 
                    // Show registered users
                    if (users.isEmpty()) {
                        System.out.println("No users registered.");
                    } else {
                        System.out.println("Registered users:");
                        for (String[] user : users) {
                            System.out.println("CC: " + user[0] + ", Name: " + user[1] + " " + user[2]);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Closing program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 7);
        entrance.close();
    }
}
