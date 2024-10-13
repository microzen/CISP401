package number;

public class Imaginary extends Complex {
    public Imaginary(int num, int den) throws ArithmeticException {
        super(0, 1, num, den);
    }

    public Imaginary(Imaginary copy) throws ArithmeticException {
        this(copy.imaginaryNumerator, copy.imaginaryDenominator);
    }

    public int getNumerator() {
        return this.imaginaryNumerator;
    }

    public void setNumerator(int numerator) throws NumberAccessException {
        this.realNumerator = numerator;
    }

    public int getDenominator() {
        return this.imaginaryDenominator;
    }

    public void setDenominator(int denominator) throws NumberAccessException, ArithmeticException {
        if(denominator==0) throw new ArithmeticException("Denominator could not be zero");
        this.imaginaryDenominator = denominator;
    }

    @Override
    public void setRealNumerator(int realNumerator) throws NumberAccessException {
        throw new NumberAccessException("The real could not be set by the mutators in imaginary");
    }

    @Override
    public void setRealDenominator(int realDenominator) throws NumberAccessException {
        throw new NumberAccessException("The real could not be set by the mutators in imaginary");
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Imaginary copy = new Imaginary(this);
        copy.simplify();
        str.append(copy.getNumerator());
        str.append("/");
        str.append(copy.getDenominator());
        str.append("i");
        return str.toString();
    }
}
