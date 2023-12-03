package week_4.lectures;

import java.util.Arrays;

public class PolynomialMultiplication {

    /**
     * Multiplies two polynomials using the naive or brute-force approach.
     * The coefficients of the polynomials are represented as arrays, where the index
     * of the array corresponds to the degree of the term, and the value at that index
     * is the coefficient of the term. The resulting polynomial is represented by the
     * multipliedCoefficients array.
     * <p>
     * The naive approach involves iterating through each term in the first polynomial
     * and each term in the second polynomial, multiplying the corresponding coefficients,
     * and accumulating the results in the appropriate positions of the product polynomial.
     *
     * @param coefficientsA The coefficients of the first polynomial.
     * @param coefficientsB The coefficients of the second polynomial.
     * @return The coefficients of the product polynomial.
     * @throws IllegalArgumentException if either coefficientsA or coefficientsB is null.
     *                                  Time complexity: O(n^2)
     */
    public int[] multiplyPolynomialsNaive(int[] coefficientsA, int[] coefficientsB) {
        // Validate input parameters
        if (coefficientsA == null || coefficientsB == null) {
            throw new IllegalArgumentException("Coefficients cannot be null.");
        }

        int[] multipliedCoefficients = new int[coefficientsA.length + coefficientsB.length - 1];

        for (int i = 0; i < coefficientsA.length; i++) {
            for (int j = 0; j < coefficientsB.length; j++) {
                multipliedCoefficients[i + j] += coefficientsA[i] * coefficientsB[j];
            }
        }
        return multipliedCoefficients;
    }

    /**
     * Multiplies two polynomials using the Divide and Conquer algorithm.
     * The coefficients of the polynomials are represented as arrays, where the index
     * of the array corresponds to the degree of the term, and the value at that index
     * is the coefficient of the term. The resulting polynomial is represented by the
     * product array.
     *
     * @param coefficientsA The coefficients of the first polynomial.
     * @param coefficientsB The coefficients of the second polynomial.
     * @return The coefficients of the product polynomial.
     * @throws IllegalArgumentException if either coefficientsA or coefficientsB is null.
     *                                  <p>
     *                                  Time complexity: O(n^2)
     */
    public int[] multiplyPolynomialsDivideAndConquer(int[] coefficientsA, int[] coefficientsB) {
        // Validate input parameters
        if (coefficientsA == null || coefficientsB == null) {
            throw new IllegalArgumentException("Coefficients cannot be null.");
        }

        int degree = coefficientsA.length + coefficientsB.length - 1;
        int[] product = new int[degree];

        // Base case: If the polynomial has only one term
        if (degree == 1) {
            product[0] = coefficientsA[0] * coefficientsB[0];
            return product;
        }

        // Equalize the coefficients length
        int maxDegree = Math.max(coefficientsA.length, coefficientsB.length);
        coefficientsA = Arrays.copyOf(coefficientsA, maxDegree);
        coefficientsB = Arrays.copyOf(coefficientsB, maxDegree);

        // Divide the coefficient arrays into 4 parts (A1, A0, B1, B0)
        int halfLength = maxDegree / 2;
        int[] a0 = Arrays.stream(coefficientsA, 0, halfLength).toArray();
        int[] a1 = Arrays.stream(coefficientsA, halfLength, maxDegree).toArray();
        int[] b0 = Arrays.stream(coefficientsB, 0, halfLength).toArray();
        int[] b1 = Arrays.stream(coefficientsB, halfLength, maxDegree).toArray();

        // Construct the new coefficient arrays by multiplying the halves
        int[] a1b1 = multiplyPolynomialsDivideAndConquer(a1, b1);
        int[] a1b0 = multiplyPolynomialsDivideAndConquer(a1, b0);
        int[] a0b1 = multiplyPolynomialsDivideAndConquer(a0, b1);
        int[] a0b0 = multiplyPolynomialsDivideAndConquer(a0, b0);


        // Construct the middle array by adding (A1B0 + A0B1)
        int[] middle = addArrays(a1b0, a0b1);

        // Construct the product
        for (int i = 0; i < degree; i++) {
            // Term from a0b0
            if (i < a0b0.length) {
                product[i] += a0b0[i];
            }

            // Term from middle array
            int middleIndex = i + halfLength;
            if (middleIndex < product.length && i < middle.length) {
                product[middleIndex] += middle[i];
            }

            // Term from a1b1
            int a1b1Index = (maxDegree % 2 == 1) ? (i + maxDegree - 1) : (i + maxDegree);
            if (a1b1Index < product.length && i < a1b1.length) {
                product[a1b1Index] += a1b1[i];
            }
        }
        return product;
    }

    /**
     * Adds corresponding elements of two arrays element-wise and returns the result as a new array.
     *
     * @param A The first input array.
     * @param B The second input array.
     * @return A new array containing the element-wise sum of {@code array1} and {@code array2}.
     * @throws IllegalArgumentException If the input arrays have different lengths.
     */
    private static int[] addArrays(int[] A, int[] B) {
        int[] result = new int[Math.max(A.length, B.length)];

        for (int i = 0; i < A.length; i++) {
            result[i] += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            result[i] += B[i];
        }

        return result;
    }
}

