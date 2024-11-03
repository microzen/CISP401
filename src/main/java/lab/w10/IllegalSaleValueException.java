package lab.w10;

public class IllegalSaleValueException extends Exception {

	public IllegalSaleValueException() {
		super("IllegalSaleValueException");
	}
	
	public IllegalSaleValueException(String message) {
		super(message);
	}
}
