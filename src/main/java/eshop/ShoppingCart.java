package eshop;

import java.util.Iterator;

/**
 * ShoppingCarts contain up to 100 products.
 * Products can be placed in any number of shopping carts at any given time.
 *
 * Each customer has exactly one shopping cart.
 * Similarly, each shopping cart belongs to exactly one customer.
 * If the customer's profile is deleted, their shopping cart is deleted as well.
 */
public class ShoppingCart implements Iterator<Product> {
    private final int MAXSIZE = 100;
    private Product[] contents;
    private int[] amounts;
    public ShoppingCart() {
        contents = new Product[MAXSIZE];
        amounts = new int[MAXSIZE];
    }
    public boolean addProduct(Product item,int amount) {
        if(item.getStock() < amount) return false;

        int nullIndex = -1;
        for(int i = 0; i < MAXSIZE; i++) {
            if(contents[i] == null && nullIndex == -1) {
                nullIndex = i;
            }else if(contents[i] != null && item.equals(contents[i])) {
                this.amounts[i] += amount;
                return true;
            }
        }
        contents[nullIndex] = item;
        amounts[nullIndex] += amount;
        return true;
    }
    public boolean removeItem(Product item) {
        for(int i = 0; i < MAXSIZE; i++) {
            if(contents[i] != null && contents[i].getId() == item.getId()) {
                this.contents[i] = null;
                this.amounts[i] = 0;
                return true;
            }
        }
        return false;
    }
    public double getTotalPirce(){
        double total = 0;
        for(int i = 0; i < MAXSIZE; i++) {
            if(contents[i] != null && amounts[i] > 0) {
                total += this.contents[i].getPrice() * this.amounts[i];
            }
        }
        return total;
    }
    public void clear(){
        for(int i = 0; i < MAXSIZE; i++) {
            contents[i] = null;
            amounts[i] = 0;
        }
    }

    /**
     * JSON
     * produce: {name:produce name, price: produce price, amount: amount for the item in shopping cart}
     * total: total price
     * @return {produces:[],total:0}
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{produces:[");
        boolean isEmpty = true;
        for(int i = 0; i < MAXSIZE; i++) {
            if(contents[i] != null) {
                isEmpty = false;
                sb.append("{name:").append(contents[i].getName())
                        .append(",price:").append(contents[i].getPrice())
                        .append("amount:").append(amounts[i])
                        .append("},");
            }
        }
        if(isEmpty) {
            sb.append("]");
        }else{
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("],total").append(getTotalPirce()).append("}");
        return sb.toString();
    }
    int current;
    @Override
    public boolean hasNext() {
        for (int i = current+1; i < MAXSIZE; i++) {
            if(contents[i] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Product next() {
        Product item= null;
        for (int i = current+1; i < MAXSIZE; i++) {
            if(contents[i] != null) {
                current = i;
                item = contents[i];
                break;
            }
        }
        return item;
    }
}
