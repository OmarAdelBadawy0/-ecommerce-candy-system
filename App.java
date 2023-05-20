import Class.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;
        ShoppingCart currentCart = new ShoppingCart();

        System.out.println("Welcome to the Shop System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        while (true) {
            String choice = scanner.nextLine();


            if (choice.trim().equals("1")) {
                User user = new User("", "", "", "", "");
                user.register();
                currentUser = user;
            } else if (choice.trim().equals("2")) {
                int counter = 3;
                while(counter > 0) {
                    User loggedInUser = new User();
                    if (loggedInUser.login()) {
                        System.out.println("Logged in successfully");
                        currentUser = loggedInUser;
                        break;
                    } else {
                        System.out.println("you have "+ (counter -1) +" tries");
                        counter--;
                    }
                    if(counter == 0)
                        System.exit(0);
                }
            } else if (choice.trim().equals("3")) {
                System.out.println("Exiting the Shop System");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("1. Show Cart");
            System.out.println("2. View Items");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice2 = scanner.nextLine();

            if (choice2.trim().equals("1")) {
                currentCart.showCart(currentCart, currentUser);
            } else if (choice2.trim().equals("2")) {
                dataBase database = new dataBase();
                Item item1 = database.viewItems();
                System.out.print("Enter the quantity you want for this item: ");
                int quantity = scanner.nextInt();
                currentCart.addItem(item1, quantity);
            } else if (choice2.trim().equals("3")) {
                System.out.println("Exiting the Shop System");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

        }
    }
}





    


