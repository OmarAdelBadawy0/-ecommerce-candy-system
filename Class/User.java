package Class;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String name;
    private String address;
    private String PNum;

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
        System.out.print("Enter Email: ");
        username = scanner.nextLine();
        OTPSender otpSender = new OTPSender();
        otpSender.sendOTP(username);

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
        scanner.close();

        dataBase makeuser = new dataBase();
        makeuser.addUser(username, password, name, address, PNum);

        System.out.println("Registration successful!");
    }

    public boolean login() {
    	Scanner scanner = new Scanner(System.in);
    	String enteredUsername;
    	String enteredPassword;
        

    	System.out.print("Enter username: ");
    	enteredUsername = scanner.nextLine();
    	System.out.print("Enter Password: ");
    	enteredPassword = scanner.nextLine();
    	scanner.close();

        dataBase checkLogin = new dataBase();
        return(checkLogin.validLogin(enteredUsername, enteredPassword));

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