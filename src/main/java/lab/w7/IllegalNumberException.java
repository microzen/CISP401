package lab.w7;

public class IllegalNumberException extends Exception{
    public IllegalNumberException() {
        super("Illegal Number Exception");
    }
    public IllegalNumberException(String message) {
        super(message);
    }
}
