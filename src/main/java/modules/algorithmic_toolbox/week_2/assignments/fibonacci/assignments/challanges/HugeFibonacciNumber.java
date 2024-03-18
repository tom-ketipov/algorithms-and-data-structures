package modules.algorithmic_toolbox.week_2.assignments.fibonacci.assignments.challanges;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.math.BigInteger;

public class HugeFibonacciNumber {
    /**
     * Calculates the nth Fibonacci number modulo a given value, ensuring both parameters are within specific bounds.
     *
     * @param index  The position in the Fibonacci sequence of the number to be calculated
     * @param modulo The modulus value for the Fibonacci number
     * @return The int value representing the nth Fibonacci number modulo the specified value, ensuring results are within integer bounds.
     * @throws IllegalArgumentException if 'index' is outside the range [1, Integer.MAX_VALUE] or 'modulo' is outside the range [2, 1000].
     */
    public int getFibonacciNumberMod(int index, int modulo) {
        int minAllowed = 1;
        int maxAllowed = Integer.MAX_VALUE;
        Validate.inclusiveBetween(minAllowed, maxAllowed, index, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(minAllowed, maxAllowed));

        minAllowed = 2;
        maxAllowed = 1000;
        Validate.inclusiveBetween(minAllowed, maxAllowed, modulo, ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(minAllowed, maxAllowed));

        return findFibonacciNumber(index).mod(BigInteger.valueOf(modulo)).intValue();
    }

    /**
     * Calculates the nth Fibonacci number by exponentiating the base Fibonacci matrix to the (n-1)th power.
     *
     * @param index The position in the Fibonacci sequence of the number to be calculated.
     * @return The BigInteger representation of the nth Fibonacci number.
     * @implNote Time Complexity: O(log n)
     */
    public BigInteger findFibonacciNumber(int index) {
        BigInteger[][] baseMatrix = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        powerMatrix(baseMatrix, index - 1);

        return baseMatrix[0][0];
    }

    /**
     * Raises a given matrix to a specified power, modifying the matrix in place.
     * This method applies the exponentiation by squaring technique, which is efficient for large exponents.
     * It is particularly useful for algorithms requiring fast computation of large powers of matrices,
     * such as those found in Fibonacci number calculations or other mathematical sequences and transformations.
     *
     * @param matrix The 2x2 matrix to be exponentiated, represented as a two-dimensional BigInteger array.
     *               This matrix will be updated in-place to represent the matrix raised to the specified power.
     *               Initially, it should contain the base matrix for the operation (e.g., the Fibonacci base matrix).
     * @param power  The exponent to which the matrix is to be raised. This value should be a non-negative integer.
     *               If the power is 0, the method will leave the matrix unchanged, reflecting the identity matrix's effect.
     *               If the power is 1, the method also leaves the matrix unchanged, as any matrix to the power of 1 is itself.
     *               <p>
     *               The method follows these steps:
     *               1. Base Case Handling: If the power is 0 or 1, the method terminates early as no changes are needed to the matrix.
     *               This corresponds to the mathematical principles that any matrix to the power of 0 is the identity matrix,
     *               and any matrix to the power of 1 is itself.
     *               <p>
     *               2. Recursive Reduction: The method recursively calls itself with the power halved, effectively reducing the problem size.
     *               This corresponds to breaking down the matrix exponentiation into smaller, more manageable pieces.
     *               <p>
     *               3. Squaring the Matrix: After the recursive call returns, the method multiplies the matrix by itself,
     *               effectively squaring it. This step is crucial as it builds up the power of the matrix by exponentiation by squaring,
     *               which is much more efficient than sequential multiplication for large powers.
     *               <p>
     *               4. Handling Odd Powers: If the original power was odd, the method multiplies the matrix by the base matrix one more time.
     *               This is necessary because the squaring process only accounts for even powers. By multiplying by the base matrix once more,
     *               the method corrects for the fact that we initially reduced the power by integer division, which truncates any decimal.
     *               <p>
     *               Note: This method modifies the input matrix in-place, meaning the original content of the matrix will be lost.
     *               Users should make a copy of the original matrix beforehand if it needs to be preserved.
     */
    private void powerMatrix(BigInteger[][] matrix, int power) {
        if (power == 0 || power == 1) return;

        BigInteger[][] baseMatrix = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        powerMatrix(matrix, power / 2);
        multiplyMatrices(matrix, matrix);

        if (power % 2 == 1) multiplyMatrices(matrix, baseMatrix);
    }

    /**
     * Multiplies two 2x2 matrices and updates the first matrix with the result.
     * This method is used for matrix multiplication in the context of mathematical operations,
     * particularly useful in algorithms requiring matrix exponentiation like calculating Fibonacci numbers.
     *
     * @param matrixA The first 2x2 matrix represented as a two-dimensional BigInteger array.
     *                This matrix will be updated to store the result of the multiplication.
     * @param matrixB The second 2x2 matrix represented as a two-dimensional BigInteger array.
     *                This matrix remains unchanged after the method execution.
     *                <p>
     *                The multiplication is performed according to the standard rules of matrix multiplication.
     *                If we consider matrixA as A and matrixB as B, where:
     *                A = | a11 a12 |
     *                | a21 a22 |
     *                and
     *                B = | b11 b12 |
     *                | b21 b22 |,
     *                then the result of the multiplication A * B will be:
     *                | a11*b11 + a12*b21, a11*b12 + a12*b22 |
     *                | a21*b11 + a22*b21, a21*b12 + a22*b22 |.
     *                <p>
     *                Detailed Steps:
     *                1. Calculate the top-left element of the resulting matrix (new a11):
     *                a = a11 * b11 + a12 * b21, where a11, a12 are elements from matrixA, and b11, b21 are elements from matrixB.
     *                2. Calculate the top-right element of the resulting matrix (new a12):
     *                b = a11 * b12 + a12 * b22, following the similar convention as above.
     *                3. Calculate the bottom-left element of the resulting matrix (new a21):
     *                c = a21 * b11 + a22 * b21, following the similar convention as above.
     *                4. Calculate the bottom-right element of the resulting matrix (new a22):
     *                d = a21 * b12 + a22 * b22, following the similar convention as above.
     *                <p>
     *                After these calculations, matrixA is updated in-place to hold the resulting matrix of the multiplication:
     *                matrixA becomes:
     *                | a, b |
     *                | c, d |,
     *                where a, b, c, d are the newly calculated BigInteger values.
     *                <p>
     *                Note: This method directly modifies the content of matrixA to store the result of the multiplication,
     *                making the original content of matrixA no longer available after the method execution.
     */
    private void multiplyMatrices(BigInteger[][] matrixA, BigInteger[][] matrixB) {
        BigInteger a = matrixA[0][0].multiply(matrixB[0][0]).add(matrixA[0][1].multiply(matrixB[1][0]));
        BigInteger b = matrixA[0][0].multiply(matrixB[0][1]).add(matrixA[0][1].multiply(matrixB[1][1]));
        BigInteger c = matrixA[1][0].multiply(matrixB[0][0]).add(matrixA[1][1].multiply(matrixB[1][0]));
        BigInteger d = matrixA[1][0].multiply(matrixB[0][1]).add(matrixA[1][1].multiply(matrixB[1][1]));

        matrixA[0][0] = a;
        matrixA[0][1] = b;
        matrixA[1][0] = c;
        matrixA[1][1] = d;
    }
}
