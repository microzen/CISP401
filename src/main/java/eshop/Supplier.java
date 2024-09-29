package eshop;

public class Supplier {
    String name;
    Product products[];

    public Supplier(String name, Product[] products) {
        this.name = name;
        this.products = products;
    }

    public Supplier(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public Product[] getProducts() {
        return products;
    }
}
