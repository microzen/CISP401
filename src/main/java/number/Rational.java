package number;

public class Rational extends Complex {
    public Rational(int numerator, int denominator) throws ArithmeticException {
        super(numerator, denominator, 0, 1);
    }

    public Rational(Rational copy) throws ArithmeticException {
        this(copy.getNumerator(), copy.getDenominator());
    }

    public int getNumerator() {
        return this.realNumerator;
    }

    public int getDenominator() {
        return this.realDenominator;
    }

    public void setNumerator(int numerator) throws NumberAccessException, IllegalNaturalNumberException {
        this.realNumerator = numerator;
    }

    public void setDenominator(int denominator) throws NumberAccessException, ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        this.realDenominator = denominator;
    }

    @Override
    public void setImaginaryDenominator(int imaginaryDenominator) throws NumberAccessException, ArithmeticException {
        throw new NumberAccessException("The imaginary could not be set by the mutators in rational");
    }

    @Override
    public void setImaginaryNumerator(int imaginaryNumerator) throws NumberAccessException {
        throw new NumberAccessException("The imaginary could not be set by the mutators in rational");
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Rational copy = new Rational(this);
        copy.simplify();
        str.append(copy.getNumerator());
        str.append("/");
        str.append(copy.getDenominator());
        return str.toString();
    }

    public double addDouble(double num) throws IllegalNaturalNumberException{
        return (double) this.getNumerator() / this.getDenominator() + num;
    }
}
