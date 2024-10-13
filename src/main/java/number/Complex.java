package number;

public class Complex {
//    protected final boolean DEBUG = System.getProperty("DEBUG") != null;
    protected int realNumerator;
    protected int realDenominator;
    protected int imaginaryNumerator;
    protected int imaginaryDenominator;

    public Complex(int realNum, int realDen, int imagNum, int imagDen) throws ArithmeticException {
        if(realDen == 0) throw new ArithmeticException("The real denominator cannot be zero");
        if(imagDen == 0) throw new ArithmeticException("The image denominator cannot be zero");
        this.realNumerator = realNum;
        this.realDenominator = realDen == 0 ? 1 : realDen;
        this.imaginaryNumerator = imagNum;
        this.imaginaryDenominator = imagDen == 0 ? 1 : imagDen;
    }

    public Complex(Complex copy) {
        if(copy.realDenominator == 0) throw new ArithmeticException("The real denominator cannot be zero");
        if(copy.imaginaryDenominator == 0) throw new ArithmeticException("The image denominator cannot be zero");
        this.realNumerator = copy.realNumerator;
        this.realDenominator = copy.realDenominator;
        this.imaginaryNumerator = copy.imaginaryNumerator;
        this.imaginaryDenominator = copy.imaginaryDenominator;
    }

    public int getRealNumerator() {
        return realNumerator;
    }

    public int getRealDenominator() {
        return realDenominator;
    }

    public int getImaginaryNumerator() {
        return imaginaryNumerator;
    }

    public int getImaginaryDenominator() {
        return imaginaryDenominator;
    }

    public void setRealNumerator(int realNumerator) throws NumberAccessException {
        this.realNumerator = realNumerator;
    }

    public void setRealDenominator(int realDenominator) throws NumberAccessException , ArithmeticException {
        if(realDenominator == 0) throw new ArithmeticException("The real denominator cannot be zero");
        this.realDenominator = realDenominator;
    }

    public void setImaginaryNumerator(int imaginaryNumerator) throws NumberAccessException {
        this.imaginaryNumerator = imaginaryNumerator;
    }

    public void setImaginaryDenominator(int imaginaryDenominator) throws NumberAccessException, ArithmeticException {
        if(imaginaryDenominator == 0) throw new ArithmeticException("The image denominator cannot be zero");
        this.imaginaryDenominator = imaginaryDenominator;
    }

    public void simplify() {
        int realGCD = findGCD(realNumerator, realDenominator);
        if (realGCD != 1) {
            this.realNumerator /= realGCD;
            this.realDenominator /= realGCD;
        }
        if (this.realDenominator < 0) {
            this.realNumerator *= -1;
            this.realDenominator *= -1;
        }

        int imgGCD = findGCD(imaginaryNumerator, imaginaryDenominator);
        if (imgGCD != 1) {
            this.imaginaryNumerator /= imgGCD;
            this.imaginaryDenominator /= imgGCD;
        }
        if (this.imaginaryDenominator < 0) {
            this.imaginaryNumerator *= -1;
            this.imaginaryDenominator *= -1;
        }
    }

    private int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }

    @Override
    public String toString() {
        Complex other = new Complex(this);
        other.simplify();
        StringBuilder sb = new StringBuilder();
        sb.append(other.getRealNumerator());
        sb.append("/");
        sb.append(other.getRealDenominator());
        if ((other.getImaginaryNumerator() > 0)) {
            sb.append("+");
        }
        sb.append(other.getImaginaryNumerator());
        sb.append("/");
        sb.append(other.getImaginaryDenominator());
        sb.append("i");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Complex) {
            Complex thisComplex = new Complex(this);
            Complex other = new Complex((Complex) obj);
            thisComplex.simplify();
            other.simplify();

            result = other.getRealNumerator() == thisComplex.getRealNumerator();
            result = result && other.getRealDenominator() == thisComplex.getRealDenominator();
            result = result && other.getImaginaryNumerator() == thisComplex.getImaginaryNumerator();
            result = result && other.getImaginaryDenominator() == thisComplex.getImaginaryDenominator();
        }
        return result;
    }

}
