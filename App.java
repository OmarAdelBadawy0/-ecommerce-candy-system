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
            switch (choice) {
                case 1:
                    User user = new User("", "", "", "", "");
                    user.register();
                    currentuser = user;
                    break;
                case 2:
                    User loggedInUser = new User();
                    loggedInUser = loggedInUser.login();
                    if (loggedInUser != null) {
                        System.out.println("Logged in as " + loggedInUser.getName());
                    }
                    currentuser = loggedInUser;
                    break;
                case 3:
                    Exit:
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
                case 2:
                    Exit:
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