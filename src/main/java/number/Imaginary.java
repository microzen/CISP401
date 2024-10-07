package number;

public class Imaginary extends Complex {
    public Imaginary(int num, int den) {
        super(0, 1, num, den);
    }

    public Imaginary(Imaginary copy) {
        super(copy);
    }

    public int getNumerator() {
        return super.getImaginaryNumerator();
    }

    public void setNumerator(int numerator) {
        super.setImaginaryNumerator(numerator);
    }

    public int getDenominator() {
        return super.getImaginaryDenominator();
    }

    public void setDenominator(int denominator) {
        super.setImaginaryDenominator(denominator);
    }

    @Override
    public void setRealNumerator(int realNumerator) {

    }

    @Override
    public void setRealDenominator(int realDenominator) {

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
