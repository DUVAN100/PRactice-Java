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
                    int opcBook; 
                    do{
                        System.out.println("\n=== Book Menu ===");
                        System.out.println("Please select an option:");
                        System.out.println("1. Add a Book");
                        System.out.println("2. Delete a Book");
                        System.out.println("3. Show All Books");
                        System.out.println("0. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                        opcBook = inputScanner.nextInt();
                        inputScanner.nextLine();
                        switch (opc) {
                            case 1:
                                System.out.println("Type id of the book");
                                String id = inputScanner.nextLine();
                                if (searchBook(rootBooks, id)) {
                                    System.out.println("This book already exists with id: " + id);
                                } else {
                                    System.out.print("Enter book name: ");
                                    String name = inputScanner.nextLine();
                                    System.out.print("Enter book author: ");
                                    String author = inputScanner.nextLine();
                                    NodoBook newBook = new NodoBook(id, name, author);
                                    rootBooks = insertBook(rootBooks, newBook);
                                    System.out.println("Book added successfully!");
                                }
                            case 2:
                                System.out.println("=== Delete a Book ===");
                                System.out.print("Enter book ID to delete: ");
                                String idD = inputScanner.nextLine();
                                if (!searchBook(rootBooks, idD)) {
                                    System.out.println("Book with id " + idD + " does not exist.");
                                    return;
                                }
                                rootBooks = deleteBook(rootBooks, idD);
                                System.out.println("Book with id " + idD + " deleted successfully.");
                            case 3:
                                System.out.println("=== Show all Books ===");
                                if (rootBooks == null) {
                                    System.out.println("No books available.");
                                } else {
                                    showAllBooks(rootBooks);
                                }

                                
                            default:
                            System.out.println("Invalid option, please try again.");
                            break;
                        }
                        
                    }while(opcBook != 4);
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
                    showAvailableBooks(rootBooks);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (opc != 0 || opc != 7);
        inputScanner.close();
    }
    
    private static boolean searchBook(NodoBook root, String id) {
        if (root == null) {
            return false;
        }
        if (root.id.equals(id)) {
            return true;
        }
        return searchBook(root.left, id) || searchBook(root.right, id);
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

    private static void showAllBooks(NodoBook node) {
        if (node != null) {
            showAllBooks(node.left);
            System.out.println("ID: " + node.id + ", Name: " + node.name + ", Author: " + node.autor);
            showAllBooks(node.right);
        }
    }
    
    
