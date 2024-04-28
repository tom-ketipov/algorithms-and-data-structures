package modules.algorithmic_toolbox.week_4.assignments.polynomial_multiplication;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;

public class NaiveDivideAndConquerPolynomialMultiplicationSolver {

    /**
     * Multiplies two polynomials and returns the product polynomial.
     *
     * @param polynomialA The first polynomial to be multiplied.
     * @param polynomialB The second polynomial to be multiplied.
     * @return The product polynomial resulting from the multiplication of the input polynomials.
     * @throws NullPointerException If either of the input polynomials is null.
     */
    public int[] multiply(int[] polynomialA, int[] polynomialB) {
        Validate.notNull(polynomialA, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.notNull(polynomialB, ValidationMessageType.NULL_VALUE_ERROR.getMessage());

        int degree = Math.max(polynomialA.length, polynomialB.length);
        int[] product = new int[2 * degree - 1];

        if (degree == 1) {
            if (polynomialA.length == 0 || polynomialB.length == 0) {
                return product; // return empty product for empty polynomials
            }

            product[0] = polynomialA[0] * polynomialB[0];
            return product;
        }

        int halfDegree = (degree + 1) / 2;
        int[] d1 = Arrays.copyOfRange(polynomialA, 0, Math.min(halfDegree, polynomialA.length));
        int[] d0 = Arrays.copyOfRange(polynomialA, halfDegree, polynomialA.length);
        int[] e1 = Arrays.copyOfRange(polynomialB, 0, Math.min(halfDegree, polynomialB.length));
        int[] e0 = Arrays.copyOfRange(polynomialB, halfDegree, polynomialB.length);

        int[] d1e1 = multiply(d1, e1);
        int[] d1e0 = multiply(d1, e0);
        int[] d0e1 = multiply(d0, e1);
        int[] d0e0 = multiply(d0, e0);

        addPolynomialTerms(product, d1e1, 0);
        addPolynomialTerms(product, d1e0, halfDegree);
        addPolynomialTerms(product, d0e1, halfDegree);
        addPolynomialTerms(product, d0e0, 2 * halfDegree);

        return product;
    }

    /**
     * Adds the terms of a polynomial to the product polynomial.
     *
     * @param product    The product polynomial to which the terms are added.
     * @param polynomial The polynomial whose terms are added to the product polynomial.
     * @param startIndex The index in the product polynomial where the addition starts.
     */
    private void addPolynomialTerms(int[] product, int[] polynomial, int startIndex) {
        for (int i = 0; i < polynomial.length; i++) {
            if (i + startIndex < product.length) {
                product[i + startIndex] += polynomial[i];
            }
        }
    }
}