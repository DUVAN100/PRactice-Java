import java.util.Scanner;

public class InventoryTrees {
    class Nodo {
        int code;
        String description;
        int stock;
        double price;
        Nodo left, right;
        public Nodo(int code, String description, int stock, double price) {
            this.code = code;
            this.description = description;
            this.stock = stock;
            this.left = null;
            this.right = null;
        }
    }
    private Nodo root;
    public void insertProduct (int code, String description, int stock, double price){
        root = insert(root, code, description, stock, price);
    }
    private Nodo insert(Nodo nodo, int code, String description, int stock, double price){
        if(root == null){
            return new Nodo(code, description, stock, price);
        }
        if (code < nodo.code){
            nodo.left = insert(nodo.left, code, description, stock, price); 
        }else if(code > nodo.code){
            nodo.right = insert(nodo.right, code, description, stock, price); 
        }else{
            nodo.stock += stock;
        }
        return nodo;
    };
    public  Nodo searchProduct(int code){
        return search(root, code);
    }
    private Nodo search(Nodo nodo, int code){
        if(nodo == null || nodo.code == code){
            return nodo;
        }
        if(nodo.code < code){
            return search(nodo.left, code);
        }else{
            return search(nodo.right, code);
        }
        
    };
    
    public void sellProduct(int code, int stock){
        Nodo product = searchProduct(code);
        if(product != null){
            if(product.stock == stock){
                product.stock -= stock;
                double total = stock * product.price;
                System.out.println(String.format("Sell finished: %d\nDescription: %s\nPrice: %.2f", stock, product.description, total));
            }else{
                System.out.println("Stock is insuficient. ");
            }
        }else{
            System.out.println("product not fount.");
        }
    }
    public void showInventory() {
        if (root == null) {
            System.out.println("Inventory is empty.");
        } else {
            showOrdered(root);
        }
    }
    private void showOrdered(Nodo nodo) {
        if (nodo != null) {
            showOrdered(nodo.left);
            System.out.println(String.format("Code: %d | Description: %s | Stock: %d | Price: %.2f",
                nodo.code, nodo.description, nodo.stock, nodo.price));
            showOrdered(nodo.right);
        }
    }
    
public static void main(String[] args) {
        InventoryTrees inventory = new InventoryTrees();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Duvan yesid Vivas Bermudez");
            System.out.println("\nChoose an action:");
            System.out.println("1. Insert product");
            System.out.println("2. Search product");
            System.out.println("3. Sell product");
            System.out.println("4. Show inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();  
            switch (option) {
                case 1: 
                    System.out.print("Enter product code: ");
                    int code = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter product description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter stock quantity: ");
                    int stock = scanner.nextInt();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    inventory.insertProduct(code, description, stock, price);
                    System.out.println("Product inserted successfully.");
                    break;

                case 2: 
                    System.out.print("Enter product code to search: ");
                    code = scanner.nextInt();
                    InventoryTrees.Nodo product = inventory.searchProduct(code);
                    if (product != null) {
                        System.out.println(String.format("Product found:\nCode: %d\nDescription: %s\nStock: %d\nPrice: %.2f",
                                product.code, product.description, product.stock, product.price));
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3: 
                    System.out.print("Enter product code to sell: ");
                    code = scanner.nextInt();
                    System.out.print("Enter quantity to sell: ");
                    stock = scanner.nextInt();
                    inventory.sellProduct(code, stock);
                    break;

                case 4: 
                    System.out.println("Current inventory:");
                    inventory.showInventory();
                    break;

                case 5: 
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
        scanner.close();
    }
}
