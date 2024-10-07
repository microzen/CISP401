package number;

public class Rational extends Complex {
    public Rational(int numerator, int denominator) {
        super(numerator, denominator, 0, 1);
    }

    public Rational(Rational copy) {
        super(copy);
    }

    public int getNumerator() {
        return super.getRealNumerator();
    }

    public int getDenominator() {
        return super.getRealDenominator();
    }

    public void setNumerator(int numerator) {
        super.setRealNumerator(numerator);
    }

    public void setDenominator(int denominator) {
        super.setRealDenominator(denominator);
    }

    @Override
    public void setImaginaryDenominator(int imaginaryDenominator) {
    }

    @Override
    public void setImaginaryNumerator(int imaginaryNumerator) {
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

    public double addDouble(double num) {
        return (double) this.getNumerator() / this.getDenominator() + num;
    }
}
