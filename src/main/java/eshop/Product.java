package eshop;

/**
 * Relationships
 *
 * ShoppingCarts can contain up to 100 products.
 * Likewise, products can be placed in any number of shopping carts at any given time.
 * Deleting the shopping cart does not remove the products it contained from the store shelves.
 *
 * Customers purchase any number of products,
 * and products are purchased by any number of customers.
 * Customers don't directly contain products, so this relationship is one of association.
 *
 * Suppliers contain any number of products in their list of supplied products.
 * In contrast, products must be provided by exactly one supplier, no more and no less.
 * Even if the supplier disappears,
 * any existing products they had on the market remain available.
 */
public class Product {
    private String id;
    private String name;
    private double price;
    private int inStock;
    public Product(String id, String name, double price, Supplier supplier, int inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }
    public Product(String id, String name, double price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = 0;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return inStock;
    }
    public void setStock(int inStock) {
        if(inStock < 0) throw new IllegalArgumentException("inStock must be greater than zero");
        this.inStock = inStock;
    }
    public void setPrice(double price) {
        if(price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public boolean addStock(int amount) {
        if(amount > this.inStock)
            return false;

        this.inStock += amount;
        return true;
    }
}
