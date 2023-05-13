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
    /*
    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("Items in your cart:");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Item Name", "Price", "Quantity", "Total");
        for (ItemInCart item : items) {
            double totalPrice = item.getQuantity() * item.getItem().getPrice();
            System.out.printf("%-20s $%-9.2f %-10d $%-9.2f%n", item.getItem().getName(), item.getItem().getPrice(), item.getQuantity(), totalPrice);
        }
    }
    */
}
