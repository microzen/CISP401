package lab.w10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Sale {
	private String itemName;	// a nonempty string for the name of the item being sold
	private double price;		// a non-negative price
	
	public Sale(String name, double price) throws IllegalSaleValueException {
		setName(name);
		setPrice(price);
	}
	
	public double getPrice() {
		return price;
	}
	
	// price can't be negative
	public void setPrice(double newPrice) throws IllegalSaleValueException {
		if (newPrice < 0) throw new IllegalSaleValueException("Price cannot be negative");
		price = newPrice;
	}
	
	public String getName() {
		return itemName;
	}
	
	// name can't be empty or null
	public void setName(String newName) throws IllegalSaleValueException {
		if (newName == null || newName.equals("")) throw new IllegalSaleValueException("Name can't be empty");
		itemName = newName;
	}
	
	// returns the total price of the item
	public double bill() {
		return getPrice();
	}
	
	// returns true if the bill for this sale is less than the bill for otherSale
	// returns false otherwise, or if otherSale is null
	public boolean lessThan(Sale otherSale) {
		if (otherSale == null) return false;
		return bill() < otherSale.bill();
	}

	public static void main(String[] args) throws IllegalSaleValueException {

		System.out.println("Part 1:");

		Sale normalSale = new Sale("Power cord adapter", 12.99);
		Sale discountedSale = new DiscountSale("T-shirt", 16.99, 0.3);
		Sale markedupSale = new MarkupSale("Toilet Paper", 8.99, 0.5);

		System.out.println("Normal Sale: " + normalSale.bill());
		System.out.println("Discount Sale: " + discountedSale.bill());
		System.out.println("Markup Sale: " + markedupSale.bill());

		ArrayList<Sale> arrayList = new ArrayList<>();
		arrayList.add(normalSale);
		arrayList.add(discountedSale);
		arrayList.add(markedupSale);
		arrayList.add(new DiscountSale("Textbook", 200, 0.9));
		arrayList.add(new MarkupSale("Souvenir Magnet", 2, 1));
		arrayList.add(new Sale("Hamburger Meal", 10.5));
		arrayList.add(new DiscountSale("Blu-ray Movie", 15.9, 0.75));

		Sale less = arrayList.get(0);
		for (int i = 1; i < arrayList.size(); i++) {
			if (arrayList.get(i).lessThan(less)) less = arrayList.get(i);
		}
		System.out.format("The cheapest: %s, price: %f", less.getName(),less.bill());
	}
}
