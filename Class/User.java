package Class;

import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private static User[] users = new User[10];
    private static int userCount = 0;

    public User(String username, String password, String name, String address, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public User(){};

    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registration:");
        System.out.print("Enter username: ");
        username = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        System.out.print("Enter name: ");
        name = scanner.nextLine();

        System.out.print("Enter address: ");
        address = scanner.nextLine();

        System.out.print("Enter phone number: ");
        phoneNumber = scanner.nextLine();

        users[userCount] = new User(username, password, name, address, phoneNumber);
        userCount++;

        System.out.println("Registration successful!");
    }

    public User login() {
    	Scanner scanner = new Scanner(System.in);
    	String enteredUsername;
    	String enteredPassword;
    	System.out.print("Enter username: ");
    	enteredUsername = scanner.nextLine();
    	System.out.print("Enter Password: ");
    	enteredPassword = scanner.nextLine();
    	
    	for (int i = 0; i < userCount; i++) {
            User user = users[i];
            if (enteredUsername.equals(user.getUsername()) && enteredPassword.equals(user.getPassword())) {
                System.out.println("Login successful!");
                return user;
            }
        }
        System.out.println("Invalid username or password!");
        return null;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}