import Class.*;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Shop System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    User user = new User("", "", "", "", "");
                    user.register();
                    break;
                case 2:
                    User loggedInUser = new User();
                    loggedInUser = loggedInUser.login();
                    if (loggedInUser != null) {
                        System.out.println("Logged in as " + loggedInUser.getName());
                    }
                    break;
                case 3:
                    System.out.println("Exiting the Shop System");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}