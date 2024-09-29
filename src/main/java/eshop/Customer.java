package eshop;

public class Customer {
    String email;
    String password;
    protected ShoppingCart cart;
    PaymentInfo paymentInfo;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
        cart = new ShoppingCart();
//       paymentInfo = PaymentInfo.promptForInfo();
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    ShoppingCart getCart() {
        return cart;
    }

    public boolean addItemToCart(Product product, int quantity) {
        return cart.addProduct(product, quantity);
    }

    public boolean removeItemFromCart(Product product) {
        return cart.removeItem(product);
    }

    public void viewCart() {
        System.out.println(cart);
    }

    public void checkout() {
        if (paymentInfo != null) {
            paymentInfo = PaymentInfo.promptForInfo();
        }
        throw new RuntimeException("The amount inside the shopping cart can't not be changed");
        // can't change the amount inside the cart.
//        this.cart.clear();
    }
}
