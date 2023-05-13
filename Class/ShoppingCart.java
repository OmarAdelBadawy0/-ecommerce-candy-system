package Class;
import java.util.*;

public class ShoppingCart {
    private List<ItemInCart> items = new ArrayList<>();


    public List<ItemInCart> getItems() {
        return items;
    }

    public void setItems(List<ItemInCart> items) {
        this.items = items;
    }
    
    public void addItem(Item item, int quantity) {
        ItemInCart newitem = new ItemInCart(item, quantity);
        items.add(newitem);
    }
    
    public void removeItem(Item item) {
        for (ItemInCart newitem : items) {
            if (newitem.getItem().equals(item)) {
                items.remove(newitem);
                return;
            }
        }
    }


    public void showCart(ShoppingCart cart, User currentuser) {

            if (items.isEmpty()) {
                System.out.println("Your cart is empty.");
                return;
            }

            System.out.println("------------------Items in your cart-------------------");
            System.out.println("Items in your cart:");
            System.out.printf("%-20s %-10s %-10s %-10s%n", "Item Name", "Price", "Quantity", "Total");
            
            for (ItemInCart item : items) {
                double totalPrice = item.getQuantity() * item.getItem().getPrice();
                System.out.printf("%-20s $%-9.2f %-10d $%-9.2f%n", item.getItem().getName(), item.getItem().getPrice(), item.getQuantity(), totalPrice);
            }
    
            System.out.println("\n1- Remove Item");
            System.out.println("2- Checkout");
            System.out.println("3- Exit");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice3 = scanner.nextInt();
    
            switch (choice3) {
                case 1 -> {
                    System.out.print("Enter the name of the item you want to remove: ");
                    String name = scanner.next();
                    for (ItemInCart item : items) {
                        if (item.getItem().getName().equals(name)) {
                            items.remove(item);
                            System.out.println("Item removed successfully.");
                            return;
                        }
                    }
                    System.out.println("Item not found.");
                }

                case 2 -> {
                    String address = "";
                    System.out.println("are you want same address or new address: ");
                    System.out.println("1- same address");
                    System.out.println("2- new address");
                    int choice4 = scanner.nextInt();

                    if (choice4 == 1) {
                        address = currentuser.getAddress();
                    }else if (choice4 == 2) {
                        System.out.print("Enter your address: ");
                        address = scanner.nextLine();
                    }
    
                    Order neworOrder = new Order(cart,address,currentuser.getPhoneNumber());
                    System.out.println("Total Amount: " + neworOrder.getTotalPrice() + " $");
                    System.out.println("Order placed successfully.");
                    System.out.println("Thank you for shopping with us.");
                    System.out.println("Your order will be delivered to " + address + " within 3 days.");
                    System.exit(0);
    
                }

                case 3 -> {
                    System.out.println("Exiting the Shop System");
                    System.exit(0);
                }
                
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
    }
    

}

