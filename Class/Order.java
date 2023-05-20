package Class;

public class Order {
    private ShoppingCart cart;
    private String shippingAddress;
    private String phoneNumber;
    private boolean shipped;
    private double totalprice;
    

    public Order(ShoppingCart cart, String adress, String phoneNumber){
        this.cart = cart;
        shippingAddress = adress;
        this.phoneNumber = phoneNumber;
        shipped = false;
        calculateTotalPrice();
    }

    public double calculateTotalPrice(){
        double totalprice = 0;
        for(ItemInCart item: cart.getItems()){
            totalprice += item.getQuantity() * item.getItem().getPrice() - item.getItem().getDiscount();
        }
        return totalprice;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isShipment() {
        return shipped;
    }

    public void setShipped(boolean shipment) {
        this.shipped = shipment;
    }

    public double getTotalPrice(){
        return totalprice;
    }
} 
