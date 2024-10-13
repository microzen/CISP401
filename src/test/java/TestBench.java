import number.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBench {
    @Test
    public void main() throws NumberAccessException {

        // Constructor
        Complex complex = new Complex(6, 2, 4, 5);

        Assertions.assertEquals(6, complex.getRealNumerator());
        Assertions.assertEquals(2, complex.getRealDenominator());
        Assertions.assertEquals(4, complex.getImaginaryNumerator());
        Assertions.assertEquals(5, complex.getImaginaryDenominator());

        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            new Complex(1, 0, 1, 1);
        });
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            new Complex(1, 1, 1, 0);
        });

        // Copy constructor
        Complex copy = new Complex(complex);
        Assertions.assertEquals(6, copy.getRealNumerator());
        Assertions.assertEquals(2, copy.getRealDenominator());
        Assertions.assertEquals(4, copy.getImaginaryNumerator());
        Assertions.assertEquals(5, copy.getImaginaryDenominator());

        // Mutators test
        Assertions.assertDoesNotThrow(() -> {
            complex.setRealNumerator(3);
            complex.setRealDenominator(5);
            complex.setImaginaryNumerator(6);
            complex.setImaginaryDenominator(7);
        });

        // Accessors test
        Assertions.assertEquals(3, complex.getRealNumerator(),
                "The real numerator should be 3 by new Complex(3,5,6,7)");
        Assertions.assertEquals(5, complex.getRealDenominator(),
                "The real denominator should be 5 by new Complex(3,5,6,7)");
        Assertions.assertEquals(6, complex.getImaginaryNumerator(),
                "The image numerator should be 6 by new Complex(3,5,6,7)");
        Assertions.assertEquals(7, complex.getImaginaryDenominator(),
                "The image denominator should be 7 by new Complex(3,5,6,7)");

        // Method throws an exception when denominator is set to 0
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            complex.setRealDenominator(0);
            complex.setImaginaryDenominator(0);
        });

        complex.setRealNumerator(6);
        complex.setRealDenominator(2);
        complex.setImaginaryNumerator(4);
        complex.setImaginaryDenominator(5);

        // ToString
        Assertions.assertEquals("3/1+4/5i", complex.toString());
        // Simplify
        complex.simplify();
        Assertions.assertEquals(3, complex.getRealNumerator());
        Assertions.assertEquals(1, complex.getRealDenominator());
        Assertions.assertEquals(4, complex.getImaginaryNumerator());
        Assertions.assertEquals(5, complex.getImaginaryDenominator());

        // ToString and simplify in real denominators are no longer negative.
        complex.setRealDenominator(Math.negateExact(complex.getRealDenominator()));
        Assertions.assertEquals("-3/1+4/5i", complex.toString());
        complex.simplify();
        Assertions.assertEquals(-3, complex.getRealNumerator());
        Assertions.assertEquals(1, complex.getRealDenominator());

        // ToString and simplify in imaginary denominators are no longer negative.
        complex.setImaginaryDenominator(Math.negateExact(complex.getImaginaryDenominator()));
        Assertions.assertEquals("-3/1-4/5i", complex.toString());
        complex.simplify();
        Assertions.assertEquals(-4, complex.getImaginaryNumerator());
        Assertions.assertEquals(5, complex.getImaginaryDenominator());

        // Method works correctly for different Complex objects and string in false
        Complex complex2 = new Complex(9, 3, 8, 10);
        Assertions.assertFalse(complex.equals( complex2));
        Assertions.assertFalse(complex.toString() == complex2.toString());

        Assertions.assertNotEquals(complex.hashCode(), complex2.hashCode());
        // Equals in true
        complex2.setRealDenominator(Math.negateExact(complex2.getRealDenominator()));
        complex2.setImaginaryDenominator(Math.negateExact(complex2.getImaginaryDenominator()));

        Assertions.assertTrue(complex.equals(complex2));
        Assertions.assertEquals(complex.toString(), complex2.toString());
    }

}
