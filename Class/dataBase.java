package Class;
import java.util.*;

public class dataBase {
    public List<User> users = new ArrayList<>();
    public List<Item> items = new ArrayList<>();
    
    User user1 = new User("mohamed", "password1", "mohamed", "123 Main St", "01012345678");
    User user2 = new User("omar", "password2", "Jane Smith", "456 Maple Ave", "01112345678");
    User user3 = new User("yousif", "password3", "Bob Doe", "789 Oak St", "01212345678");

    Item item1 = new Item("Sour Patch Kids", "Salt-Candy", "Sour then sweet", "Cadbury", 1.99, 0.10);
    Item item2 = new Item("M&M's", "Sour-Candy", "Melts in your mouth, not in your hands", "Mars, Inc.", 2.49, 0.15);
    Item item3 = new Item("Skittles", "M&M's", "Taste the rainbow", "Wrigley Company", 1.79, 0.05);
    Item item4 = new Item("Twix", "Jelly Beans", "Two for me, none for you", "Mars, Inc.", 1.49, 0.10);
    Item item5 = new Item("Reese's Pieces", "Gum", "Perfect for E.T.", "The Hershey Company", 2.99, 0.20);
    Item item6 = new Item("Haribo Goldbears", "Jelly Beans", "Kids and grown-ups love it so, the happy world of Haribo", "Haribo", 1.29, 0.05);


    public dataBase(){
        users.add(user1);
        users.add(user2);
        users.add(user3);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
    }
    
    // print all saved users
    public void printUsers() {
        System.out.println("X-----------------Users---------------------X");
        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Name: " + user.getName());
            System.out.println("Address: " + user.getAddress());
            System.out.println("Phone Number: " + user.getPhoneNumber());
            System.out.println();
        }
    }

    // view the catalog
    public Item viewItems(){
        Scanner scanner = new Scanner(System.in);
        int counter = 0;


        System.out.println("-----------------Items------------------");
        for (Item item : items) {
            System.out.println("Item NO: " + counter++ +"\nName: " + item.getName());
            System.out.println("Price: " + item.getPrice());
            System.out.println();

        }
        System.out.print("Enter the NO of item to select it: ");    // choose item from catalog then return it
        int selectedItem = scanner.nextInt();
        Item choosenitem = items.get(selectedItem);
        choosenitem.showitem();
        scanner.close();
        return items.get(selectedItem);
    }

    public boolean validLogin(String userName, String pass){
        for (User user : users) {

            if (user.getUsername().equals(userName)) {       // search of the user
                if (user.getPassword().equals(pass)) {       // check if the password is correct
                    return true;
                }else{
                    break;
                }
            }
        }
        System.out.println("Username or password is incorrect!!");
        return false;
    }

    public void addUser(String username, String password, String name, String address, String PNum){
        User newuser = new User(username, password, name, address, PNum);
        users.add(newuser);
    }

}
