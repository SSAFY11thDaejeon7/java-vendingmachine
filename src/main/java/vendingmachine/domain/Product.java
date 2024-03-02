package vendingmachine.domain;

public class Product {

    private static final int QUANTITY_ZERO = 0;

    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isEqualToName(String name) {
        return this.name.equals(name);
    }

    public boolean reduceQuantity() {
        quantity--;

        if (quantity == QUANTITY_ZERO) {
            return true;
        }
        return false;
    }
}
