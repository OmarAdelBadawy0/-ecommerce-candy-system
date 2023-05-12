package Class;

import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String name;
    private String address;
    private String PNum;
    private static User[] users = new User[10];
    private static int userCount = 0;

    public User(String username, String password, String name, String address, String PNum) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.PNum = PNum;
    }
    public User(){}

    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registration:");
        System.out.print("Enter username: ");
        username = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();
        while (password.length() < 8){
            System.out.println("Password should contain 8 Char or more");
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }

        System.out.print("Enter name: ");
        name = scanner.nextLine();

        System.out.print("Enter address: ");
        address = scanner.nextLine();

        System.out.print("Enter phone number: ");
        PNum = scanner.nextLine();

        while(true) {
            if((PNum.length() == 11) && (PNum.charAt(0) == '0') && (PNum.charAt(1) == '1') && (PNum.charAt(2) == '0' || PNum.charAt(2) == '1' || PNum.charAt(2) == '2' || PNum.charAt(2) == '5'))
                break;
            System.out.println("please Enter a valid phone number");
            System.out.print("Enter phone number: ");
            PNum = scanner.nextLine();
        }


        users[userCount] = new User(username, password, name, address, PNum);
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
        return PNum;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PNum = phoneNumber;
    }

}