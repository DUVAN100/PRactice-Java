package sistembanc;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryService {
    static class NodoBook {
        String id;
        String name;
        String autor;
        NodoBook left, right;

        public NodoBook(String id, String name, String autor) {
            this.id = id;
            this.name = name;
            this.autor = autor;
            this.left = this.right = null;
        }
    }

    static class NodoUser {
        String cedula;
        String name;
        String lastNames;
        NodoUser left, right;

        public NodoUser(String cedula, String name, String lastNames) {
            this.cedula = cedula;
            this.name = name;
            this.lastNames = lastNames;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        NodoBook rootBooks = null;
        NodoUser rootUser = null;
        ArrayList<NodoBook> booksBorrowed = new ArrayList<>();
        Scanner inputScanner = new Scanner(System.in);
        int opc;

        do {
            System.out.println("=== Duvan Yesid Vivas Bermudez - 1002280067  ===");
            System.out.println("=== Library Management System ===");
            System.out.println("Please select an option:");
            System.out.println("1. Book Menu");
            System.out.println("2. User Menu");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Show Borrowed Books");
            System.out.println("6. Show Available Books");
            System.out.println("0. Exit");
            System.out.println("=================================");
            opc = inputScanner.nextInt();
            inputScanner.nextLine();
            switch (opc) {
                case 1:
                    bookMenu(inputScanner, rootBooks);
                    break;
                case 2:
                    userMenu(inputScanner, rootUser);
                    break;
                case 3:
                    borrowBook(inputScanner, rootBooks, booksBorrowed);
                    break;
                case 4:
                    returnBook(inputScanner, booksBorrowed);
                    break;
                case 5:
                    showBorrowedBooks(booksBorrowed);
                    break;
                case 6:
                    System.out.println("=== Show Available Books ===");
                    showAllBooks(rootBooks);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (opc != 0);
        inputScanner.close();
    }

    private static void bookMenu(Scanner inputScanner, NodoBook rootBooks) {
        int opcBook;
        do {
            System.out.println("\n=== Book Menu ===");
            System.out.println("Please select an option:");
            System.out.println("1. Add a Book");
            System.out.println("2. Delete a Book");
            System.out.println("3. Show All Books");
            System.out.println("0. Return to Main Menu");
            opcBook = inputScanner.nextInt();
            inputScanner.nextLine();
            switch (opcBook) {
                case 1:
                    System.out.println("Enter book ID:");
                    String id = inputScanner.nextLine();
                    if (searchBook(rootBooks, id)) {
                        System.out.println("This book already exists with ID: " + id);
                    } else {
                        System.out.print("Enter book name: ");
                        String name = inputScanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = inputScanner.nextLine();
                        NodoBook newBook = new NodoBook(id, name, author);
                        rootBooks = insertBook(rootBooks, newBook);
                        System.out.println("Book added successfully!");
                    }
                    break;
                case 2:
                    System.out.println("Enter book ID to delete:");
                    String idD = inputScanner.nextLine();
                    if (!searchBook(rootBooks, idD)) {
                        System.out.println("Book with ID " + idD + " does not exist.");
                    } else {
                        rootBooks = deleteBook(rootBooks, idD);
                        System.out.println("Book with ID " + idD + " deleted successfully.");
                    }
                    break;
                case 3:
                    showAllBooks(rootBooks);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (opcBook != 0);
    }

    private static void userMenu(Scanner inputScanner, NodoUser rootUser) {
        int opcUser;
        do {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Show All Users");
            System.out.println("0. Return to Main Menu");
            opcUser = inputScanner.nextInt();
            inputScanner.nextLine();
            switch (opcUser) {
                case 1:
                    System.out.print("Enter user ID (cedula): ");
                    String cedula = inputScanner.nextLine();
                    if (searchUser(rootUser, cedula)) {
                        System.out.println("This user already exists with ID: " + cedula);
                    } else {
                        System.out.print("Enter user name: ");
                        String name = inputScanner.nextLine();
                        System.out.print("Enter user last names: ");
                        String lastNames = inputScanner.nextLine();
                        NodoUser newUser = new NodoUser(cedula, name, lastNames);
                        rootUser = insertUser(rootUser, newUser);
                        System.out.println("User added successfully!");
                    }
                    break;
                case 2:
                    System.out.print("Enter user ID to delete: ");
                    String idD = inputScanner.nextLine();
                    if (!searchUser(rootUser, idD)) {
                        System.out.println("User with ID " + idD + " does not exist.");
                    } else {
                        rootUser = deleteUser(rootUser, idD);
                        System.out.println("User with ID " + idD + " deleted successfully.");
                    }
                    break;
                case 3:
                    showAllUsers(rootUser);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (opcUser != 0);
    }

    private static void borrowBook(Scanner inputScanner, NodoBook rootBooks, ArrayList<NodoBook> booksBorrowed) {
        System.out.print("Enter the book ID to borrow: ");
        String id = inputScanner.nextLine();
        if (searchBook(rootBooks, id)) {
            NodoBook borrowedBook = searchBook(rootBooks, id);
            booksBorrowed.add(borrowedBook);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book with ID " + id + " does not exist.");
        }
    }

    private static void returnBook(Scanner inputScanner, ArrayList<NodoBook> booksBorrowed) {
        System.out.print("Enter the book ID to return: ");
        String id = inputScanner.nextLine();
        for (NodoBook book : booksBorrowed) {
            if (book.id.equals(id)) {
                booksBorrowed.remove(book);
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found in borrowed list.");
    }

    private static void showBorrowedBooks(ArrayList<NodoBook> booksBorrowed) {
        if (booksBorrowed.isEmpty()) {
            System.out.println("No borrowed books.");
        } else {
            System.out.println("=== Borrowed Books ===");
            for (NodoBook book : booksBorrowed) {
                System.out.println("ID: " + book.id + ", Name: " + book.name + ", Author: " + book.autor);
            }
        }
    }
    
    private static void showAllBooks(NodoBook node) {
        if (node != null) {
            showAllBooks(node.left); 
            System.out.println("ID: " + node.id + ", Name: " + node.name + ", Author: " + node.autor);
            showAllBooks(node.right); 
        }
    }

    private static boolean searchBook(NodoBook nodoBook, String id) {
        if (nodoBook == null) {
            return false;
        }
        if (nodoBook.id.equals(id)) {
            return true; 
        }
        return searchBook(nodoBook.left, id) || searchBook(nodoBook.right, id);
    }

    private static NodoBook deleteBook(NodoBook root, String id) {
        if (root == null) {
            return null; 
        }
        if (id.compareTo(root.id) < 0) {
            root.left = deleteBook(root.left, id); 
        } else if (id.compareTo(root.id) > 0) {
            root.right = deleteBook(root.right, id); 
        } else {
            if (root.left == null && root.right == null) {
                return null; 
            }
            if (root.left == null) {
                return root.right; 
            }
            if (root.right == null) {
                return root.left; 
            }
            NodoBook smallestNode = findSmallestNode(root.right);
            root.id = smallestNode.id;
            root.name = smallestNode.name;
            root.autor = smallestNode.autor;
            root.right = deleteBook(root.right, smallestNode.id); 
        }
        return root;
    }

    private static NodoBook insertBook(NodoBook root, NodoBook newBook) {
        if (root == null) {
            return newBook; 
        }
        if (newBook.id.compareTo(root.id) < 0) {
            root.left = insertBook(root.left, newBook); 
        } else {
            root.right = insertBook(root.right, newBook); 
        }
        return root;
    }
    private static NodoBook findSmallestNode(NodoBook root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;    
    }
}
