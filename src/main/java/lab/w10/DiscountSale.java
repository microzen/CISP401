package lab.w10;

public class DiscountSale extends Sale {
	private double discount;	// a percent of the price to be discounted, given as a decimal

	public DiscountSale(String name, double price, double discount) throws IllegalSaleValueException{
		super(name, price);
		setDiscount(discount);
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double newDiscount) throws IllegalSaleValueException {
		if (newDiscount < 0 || newDiscount > 1) {
			throw new IllegalSaleValueException("Discount must be between 0 and 1");
		}
		discount = newDiscount;
	}

	@Override
	public double bill() {
		return getPrice() * (1 - getDiscount());
	}
}
