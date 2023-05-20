package Class;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public User(){};
    public Scanner scanner = new Scanner(System.in);
    public void register() {

//        Scanner scanner = new Scanner(System.in);
        System.out.println("Registration:");
        //ragex to add valid @gmail.com
        boolean valid = false;
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"); // regex pattern to validate email
        Matcher matcher;
        while (!valid) {
            System.out.print("Enter your email: ");
            username = scanner.nextLine();
            matcher = pattern.matcher(username);

            if (matcher.matches()) {
                valid = true;
                System.out.println("Valid email entered: " + username);
            } else {
                System.out.println("Invalid email entered. Please try again.");
            }
        }
        OTPSender otpSender = new OTPSender();
        otpSender.sendOTP(username);

        System.out.print("Enter password: ");
        password = scanner.nextLine();
        while (password.length() < 8){
            System.out.println("Password should contain 8 Char or more");
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }

        while(true){
            System.out.print("Enter name: ");
            try {
                name = scanner.nextLine();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("pls Enter valid email, try again");
                scanner.nextLine();
            }
        }

        while(true){
            System.out.print("Enter address: ");
            try {
                address = scanner.nextLine();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("pls Enter valid address, try again");
                scanner.nextLine();
            }
        }
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
//    	Scanner scanner1 = new Scanner(System.in);
    	String enteredUsername;
    	String enteredPassword;
        

    	System.out.print("Enter username: ");
    	enteredUsername = scanner.nextLine();
    	System.out.print("Enter Password: ");
    	enteredPassword = scanner.nextLine();


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