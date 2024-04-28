package modules.algorithmic_toolbox.week_4.assignments.polynomial_multiplication;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

public class NaiveIterativePolynomialMultiplicationSolver {

    /**
     * Multiplies two polynomials represented as arrays of coefficients.
     *
     * @param degree      The degree of the polynomials.
     * @param polynomialA The coefficients of the first polynomial.
     * @param polynomialB The coefficients of the second polynomial.
     * @return The coefficients of the product polynomial.
     * @throws IllegalArgumentException if either polynomialA or polynomialB is null,
     *                                  or if the degree is less than or equal to 0.
     * @implNote Time complexity: O(n^2)
     */
    public int[] multiply(int degree, int[] polynomialA, int[] polynomialB) {
        Validate.notNull(polynomialA, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.notNull(polynomialB, ValidationMessageType.NULL_VALUE_ERROR.getMessage());
        Validate.isTrue(degree > 0, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1));

        int[] productPolynomial = new int[2 * degree - 1];

        for (int i = 0; i < degree; i++) {
            for (int j = 0; j < degree; j++) {
                productPolynomial[i + j] += polynomialA[i] * polynomialB[j];
            }
        }
        return trim(productPolynomial);
    }

    /**
     * Trims leading zeroes from the given polynomial.
     *
     * @param polynomial The polynomial to be trimmed.
     * @return The trimmed polynomial.
     */
    private int[] trim(int[] polynomial) {
        int firstNonZeroIndex = 0;

        // Find the index of the first non-zero coefficient
        while (firstNonZeroIndex < polynomial.length && polynomial[firstNonZeroIndex] == 0) {
            firstNonZeroIndex++;
        }

        if (firstNonZeroIndex == polynomial.length) {
            return new int[]{0};
        }

        int trimmedLength = polynomial.length - firstNonZeroIndex;

        int[] trimmedPolynomial = new int[trimmedLength];
        System.arraycopy(polynomial, firstNonZeroIndex, trimmedPolynomial, 0, trimmedLength);

        return trimmedPolynomial;
    }
}
