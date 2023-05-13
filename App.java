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
        int choice ;
        while(true){
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();

                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("pls Enter numbers from 1 - 3 , try again");
                scanner.nextLine();
            }
        }
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
            case 3 -> {
                System.out.println("Exiting the Shop System");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                main(args);
            }
        }
        scanner.close();
        dataBase DataBase = new dataBase();
        while (true) {
            
            System.out.println("1- Show Cart");
            System.out.println("2- View Items");
            System.out.println("3- Exit");
            Scanner scanner2 = new Scanner(System.in);
            int choice2 ;
            choice2 = scanner2.nextInt();
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


    


