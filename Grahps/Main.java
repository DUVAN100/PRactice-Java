package library;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        AVLTree<Integer> users = new AVLTree<>();
        AVLTree<Integer> books = new AVLTree<>();
        GraphsLibrary graph = new GraphsLibrary();

        boolean exit = false;
        while (!exit) {
            menu.getOptionMenuMain();
            int option = menu.getOption();
            switch (option) {
                case 1 -> managementMenuBooks(menu, books);
                case 2 -> managementMenuUsers(menu, users);
                case 3 -> managementMenuRelations(menu, graph, users, books);
                case 0 -> exit = true;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        private static void managementMenuBooks(Menu menu, AVLTree<String> books){
            boolean exit = false;
            while (!exit) {
                menu.showMenuLibrary();
                int option = menu.getOption();
                switch (option) {
                    case 1 -> {
                        System.out.println("type the code of book");
                        String code = menu.scanner.nextLine();
                        System.out.println("type the title of book");
                        String title = menu.scanner.nextLine();
                        System.out.println("type the author of book");
                        String author = menu.scanner.nextLine();
                        books.insert(code, new Book(author, title, author));
                        
                    }
                    case 4 -> {
                        
                    };
                    case 0 -> exit = true;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }
            
        }

        private static void managementMenuUsers(Menu menu, AVLTree<String> users){
            boolean exit = false;
            while (!exit) {
                menu.showMenuUser();
                int option = menu.getOption();
                switch (option) {
                    case 1 -> menu.addUser(users);
                    // case 2 -> menu.deleteUser(users);
                    // case 3 -> menu.searchUser(users);
                    case 4 -> menu.listAllUsers(users);
                    case 0 -> exit = true;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }
            
        }
        
        private static void managementMenuRelations(Menu menu, GraphsLibrary graph, AVLTree<String> users, AVLTree<String> books){
            boolean exit = false;
            while (!exit) {
                menu.showMenuManagementRelations();
                int option = menu.getOption();
                switch (option) {
                    case 1 -> graph.addUser(users);
                    case 2 -> graph.removeUser(users);
                    case 3 -> graph.addBook(books);
                    case 4 -> graph.removeBook(books);
                    case 5 -> graph.addRelation(users, books);
                    case 6 -> graph.removeRelation(users, books);
                    case 7 -> graph.showBooksByUser(users);
                    case 8 -> graph.showUsersByBook(books);
                    case 0 -> exit = true;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }
            
        }

    }
}