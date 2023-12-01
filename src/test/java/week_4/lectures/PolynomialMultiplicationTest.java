package week_4.lectures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PolynomialMultiplicationTest {
    private PolynomialMultiplication polynomialMultiplicationSolver;

    @BeforeEach
    public void setUp() {
        polynomialMultiplicationSolver = new PolynomialMultiplication();
    }

    @Test
    public void can_multiply_two_polynomials_with_coefficients_of_equal_length() {
        int[] coefficientsA = {1, 2, 3, 4};
        int[] coefficientsB = {4, 3, 2, 1};
        int[] result = polynomialMultiplicationSolver.multiplyPolynomialsNaive(coefficientsA, coefficientsB);
        assertArrayEquals(new int[]{4, 11, 20, 30, 20, 11, 4}, result);
    }

    @Test
    public void can_multiply_two_polynomials_with_coefficients_of_different_length() {
        int[] coefficientsA = {5, 0, 10, 6};
        int[] coefficientsB = {1, 2, 4};
        int[] result = polynomialMultiplicationSolver.multiplyPolynomialsNaive(coefficientsA, coefficientsB);
        assertArrayEquals(new int[]{5, 10, 30, 26, 52, 24}, result);
    }

    @Test
    public void can_multiply_two_polynomials_with_single_coefficient() {
        int[] coefficientsA = {5};
        int[] coefficientsB = {2};
        int[] result = polynomialMultiplicationSolver.multiplyPolynomialsNaive(coefficientsA, coefficientsB);
        assertArrayEquals(new int[]{10}, result);
    }
}
