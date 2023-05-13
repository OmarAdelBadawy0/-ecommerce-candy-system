import Class.*;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Shop System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        

        User currentuser = null;
        ShoppingCart currentCart = new ShoppingCart();
        
        switch (choice) {
            case 1 -> {
                User user = new User("", "", "", "", "");
                user.register();
                currentuser = user;
            }
            case 2 -> {
                User loggedInUser = new User();
                if (loggedInUser.login()) {
                    System.out.println("Logged in successfully ");
                } else {
                    return;
                }
                currentuser = loggedInUser;
            }
            case 3 -> System.out.println("Exiting the Shop System");
            default -> System.out.println("Invalid choice. Please try again.");
        }

        dataBase DataBase = new dataBase();

        while (true) {
            
            System.out.println("1- Show Cart");
            System.out.println("2- View Items");
            System.out.println("3- Exit");
            int choice2 = scanner.nextInt();
            scanner.nextLine();

            switch (choice2) {
                case 1 -> {
                    currentCart.showCart(currentCart, currentuser);
                    break;
                }
                case 2 -> {
                    Item item1 = DataBase.viewItems();
                    System.out.print("Enter the quantity you want to this item: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (quantity < 0 || !scanner.hasNextInt()) {
                        throw new IllegalArgumentException("Invalid quantity. Please enter a positive integer.");
                    }
                    currentCart.addItem(item1, quantity);
                    break;    
                }
                case 3 -> {
                    System.out.println("Exiting the Shop System");
                    System.exit(0);
                    break;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                    System.exit(0);
                }
            }
        }


    }




    
}


    


