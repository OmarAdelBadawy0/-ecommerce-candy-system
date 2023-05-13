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

        System.out.print("Enter password: ");
        password = scanner.nextLine();
        while (password.length() < 8){
            System.out.println("Password should contain 8 Char or more");
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }
        //-----------------OTP--------------------
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        // Set up properties for the email
        Properties props = new Properties();
        props.put("mail.smtp.host", "your-smtp-hostname");
        props.put("mail.smtp.port", "your-smtp-port");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create a session with the email server
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your-email-address", "your-email-password");
            }
        });

        // Create a message to send
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("your-email-address"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("user-email-address"));
        message.setSubject("OTP Verification Code");
        message.setText("Your OTP is: " + otp);

        // Send the message
        Transport.send(message);
        System.out.print("Enter the OTP sent to your email: ");
        int userOtp = scanner.nextInt();

        while (userOtp != otp) {
            System.out.println("OTP is incorrect. Please enter the OTP again.");
            System.out.print("Enter the OTP sent to your email: ");
            userOtp = scanner.nextInt();
        }

        //----------------------------------------
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