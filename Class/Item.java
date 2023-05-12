package Class;

public class Item {
    private String name;
    private String category;
    private String description;
    private String brand;
    private double price;
    private double discount;
    
    public Item (String name, String category,String description, String brand, double price, double discount){

        this.name = name;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
    }
    public void showitem(){
        System.out.println("   " + name);
        System.out.println("   " + price);
        System.out.println("Category : " + category);
        System.out.print("Description : ");
        System.out.println(description);
        System.out.println(brand);
    }


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}