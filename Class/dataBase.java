package Class;
import java.util.*;

public class dataBase {
    public List<User> users = new ArrayList<>();
    public List<Item> items = new ArrayList<>();
    
    User user1 = new User("johnsmith", "password1", "John Smith", "123 Main St", "555-1234");
    User user2 = new User("janesmith", "password2", "Jane Smith", "456 Maple Ave", "555-5678");
    User user3 = new User("bobdoe", "password3", "Bob Doe", "789 Oak St", "555-9012");

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
}
