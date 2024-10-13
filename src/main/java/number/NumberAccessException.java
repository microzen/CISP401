package number;

public class NumberAccessException extends Exception{
    public NumberAccessException(){
        super("Number access Error");
    }
    public NumberAccessException(String message) {
        super(message);
    }
}
