
public class MarkupSale extends Sale {
	private double markup;	// a percent of the price to be increased by, given as a decimal
	
	public MarkupSale(String name, double price, double markup) throws IllegalSaleValueException{
		super(name, price);
		setMarkup(markup);
	}
	
	public double getMarkup() {
		return markup;
	}
	
	// discount can't be less than 0 (0% discounted) or greater than 1 (100% discounted)
	public void setMarkup(double newMarkup) throws IllegalSaleValueException {
		if (newMarkup < 0 || newMarkup > 1) {
			throw new IllegalSaleValueException("Discount must be between 0 and 1");
		}
		markup = newMarkup;
	}
	
	@Override
	public double bill() {
		return getPrice() * (1 + getMarkup());
	}
}
