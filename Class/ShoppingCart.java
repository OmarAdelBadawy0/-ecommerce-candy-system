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
    
    
}
