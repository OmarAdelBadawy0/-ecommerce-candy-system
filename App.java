import Class.*;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //while (true) {
            System.out.println("Welcome to the Shop System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            User currentuser = null;
            ShoppingCart currentCart = new ShoppingCart();
            switch (choice) {
                case 1:
                    User user = new User("", "", "", "", "");
                    user.register();
                    currentuser = user;
                    break;
                case 2:
                    User loggedInUser = new User();
                    
                    if (loggedInUser.login()) {
                        System.out.println("Logged in successfully ");
                    }else{
                        return;
                    }
                    currentuser = loggedInUser;
                    break;
                case 3:
                    System.out.println("Exiting the Shop System");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            dataBase DataBase = new dataBase();
            System.out.println("1-Show Items");
            System.out.println("2-Exit");
            int choice1 = scanner.nextInt();
            
            switch (choice1){
                case 1 :
                    Item item1 = DataBase.viewItems();
                    System.out.print("Enter the quantity you want to this item: ");
                    int choice2 = scanner.nextInt();
                    currentCart.addItem(item1, choice2);
                case 2:
                    System.out.println("Exiting the Shop System");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }


        //}
    }
}