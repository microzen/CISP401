package number;

public class IllegalNaturalNumberException extends NumberAccessException{
    public IllegalNaturalNumberException(){
        super("Illegal Natural Number");
    }
    public IllegalNaturalNumberException(String message) {
        super(message);
    }
}
