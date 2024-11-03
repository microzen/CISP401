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
}
