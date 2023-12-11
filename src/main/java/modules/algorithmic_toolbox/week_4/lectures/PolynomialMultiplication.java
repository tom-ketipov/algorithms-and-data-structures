package modules.algorithmic_toolbox.week_4.lectures;

import java.util.Arrays;

import static services.ValidationService.validateNotEmpty;
import static services.ValidationService.validateNotNull;

public class PolynomialMultiplication {
    public final static String NON_NULL_COEFFICIENT_A_EXCEPTION_MESSAGE = "The input array of coefficientsA must not be null.";
    public final static String NON_EMPTY_COEFFICIENT_A_EXCEPTION_MESSAGE = "The input array of coefficientsA must not be empty.";
    public final static String NON_NULL_COEFFICIENT_B_EXCEPTION_MESSAGE = "The input array of coefficientsB must not be null.";
    public final static String NON_EMPTY_COEFFICIENT_B_EXCEPTION_MESSAGE = "The input array of coefficientsB must not be empty.";
    public final static String NON_NULL_A_EXCEPTION_MESSAGE = "The input array of a must not be null.";
    public final static String NON_NULL_B_EXCEPTION_MESSAGE = "The input array of b must not be null.";


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
        validateNotNull(coefficientsA, NON_NULL_COEFFICIENT_A_EXCEPTION_MESSAGE);
        validateNotNull(coefficientsB, NON_NULL_COEFFICIENT_B_EXCEPTION_MESSAGE);
        validateNotEmpty(coefficientsA, NON_EMPTY_COEFFICIENT_A_EXCEPTION_MESSAGE);
        validateNotEmpty(coefficientsB, NON_EMPTY_COEFFICIENT_B_EXCEPTION_MESSAGE);

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
        validateNotNull(coefficientsA, NON_NULL_COEFFICIENT_A_EXCEPTION_MESSAGE);
        validateNotNull(coefficientsB, NON_NULL_COEFFICIENT_B_EXCEPTION_MESSAGE);
        validateNotEmpty(coefficientsA, NON_EMPTY_COEFFICIENT_A_EXCEPTION_MESSAGE);
        validateNotEmpty(coefficientsB, NON_EMPTY_COEFFICIENT_B_EXCEPTION_MESSAGE);


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
     * Multiplies two polynomials using the Karatsuba algorithm.
     * The time complexity of this algorithm is O(n^1.585), providing a
     * more efficient multiplication for large polynomials compared to
     * the naive divide-and-conquer approach (O(n^2)).
     *
     * @param coefficientsA The coefficients of the first polynomial.
     * @param coefficientsB The coefficients of the second polynomial.
     * @return The coefficients of the product polynomial.
     * @throws IllegalArgumentException If either coefficientsA or coefficientsB is null.
     *                                  Time complexity: O(n^1.585)
     */
    public int[] multiplyPolynomialsKaratsuba(int[] coefficientsA, int[] coefficientsB) {
        validateNotNull(coefficientsA, NON_NULL_COEFFICIENT_A_EXCEPTION_MESSAGE);
        validateNotNull(coefficientsB, NON_NULL_COEFFICIENT_B_EXCEPTION_MESSAGE);
        validateNotEmpty(coefficientsA, NON_EMPTY_COEFFICIENT_A_EXCEPTION_MESSAGE);
        validateNotEmpty(coefficientsB, NON_EMPTY_COEFFICIENT_B_EXCEPTION_MESSAGE);

        int degree = coefficientsA.length + coefficientsB.length - 1;
        int[] product = new int[degree];

        // Base case: If the polynomial has only one term
        if (coefficientsA.length == 1) {
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
        int[] a0b0 = multiplyPolynomialsDivideAndConquer(a0, b0);

        // Compute (A1 + A0) and (B1 + B0)
        int[] a1a0 = addArrays(a1, a0);
        int[] b1b0 = addArrays(b1, b0);

        // Recursive call for (A1 + A0)(B1 + B0)
        int[] middle = multiplyPolynomialsDivideAndConquer(a1a0, b1b0);

        // Subtract (A1B1 + A0B0) from (A1 + A0)(B1 + B0)
        middle = subtractArrays(middle, a1b1);
        middle = subtractArrays(middle, a0b0);

        // Construct the product
        for (int i = 0; i <= degree; i++) {
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
            if (a1b1Index < product.length && i < a1b1.length && a1b1[i] != 0) {
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
    private int[] addArrays(int[] A, int[] B) {
        validateNotNull(A, NON_NULL_A_EXCEPTION_MESSAGE);
        validateNotNull(B, NON_NULL_B_EXCEPTION_MESSAGE);

        int[] result = new int[Math.max(A.length, B.length)];
        for (int i = 0; i < A.length; i++) {
            result[i] += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            result[i] += B[i];
        }

        return result;
    }

    /**
     * Subtracts the elements of array B from array A.
     *
     * @param A The first array.
     * @param B The second array to subtract from the first array.
     * @return A new array containing the result of the subtraction.
     * @throws IllegalArgumentException If either A or B is null.
     */
    private int[] subtractArrays(int[] A, int[] B) {
        validateNotNull(A, NON_NULL_A_EXCEPTION_MESSAGE);
        validateNotNull(B, NON_NULL_B_EXCEPTION_MESSAGE);

        int[] result = new int[Math.max(A.length, B.length)];
        for (int i = 0; i < A.length; i++) {
            result[i] += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            result[i] -= B[i];
        }
        return result;
    }
}

