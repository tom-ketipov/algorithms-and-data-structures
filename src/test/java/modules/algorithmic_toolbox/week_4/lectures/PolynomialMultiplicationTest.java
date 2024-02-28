package modules.algorithmic_toolbox.week_4.lectures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolynomialMultiplicationTest {
    private PolynomialMultiplication polynomialMultiplicationSolver;

    @BeforeEach
    public void setUp() {
        polynomialMultiplicationSolver = new PolynomialMultiplication();
    }

    // Naive -> Linear approach
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

    @Test
    public void naive_method_throws_exception_for_null_input() {
        int[] coefficientsA = {3, 2, 2};

        try {
            polynomialMultiplicationSolver.multiplyPolynomialsDivideAndConquer(coefficientsA, null);
        } catch (NullPointerException e) {
            assertEquals("The array must not be null.", e.getMessage());
        }
    }

    // Divide and Conquer Naive
    @Test
    public void can_multiply_two_polynomials_with_single_coefficient_using_divide_and_conquer() {
        int[] coefficientsA = {4};
        int[] coefficientsB = {50};

        int[] result = polynomialMultiplicationSolver.multiplyPolynomialsDivideAndConquer(coefficientsA, coefficientsB);
        assertArrayEquals(new int[]{200}, result);
    }

    @Test
    public void can_multiply_two_polynomials_with_coefficients_of_equal_even_length_using_divide_and_conquer() {
        int[] coefficientsA = {1, 2, 3, 4};
        int[] coefficientsB = {4, 3, 2, 1};

        int[] result = polynomialMultiplicationSolver.multiplyPolynomialsDivideAndConquer(coefficientsA, coefficientsB);
        assertArrayEquals(new int[]{4, 11, 20, 30, 20, 11, 4}, result);
    }

    @Test
    public void can_multiply_two_polynomials_with_coefficients_of_different_length_using_divide_and_conquer() {
        int[] coefficientsA = {5, 0, 10, 6};
        int[] coefficientsB = {1, 2, 4};

        int[] result = polynomialMultiplicationSolver.multiplyPolynomialsDivideAndConquer(coefficientsA, coefficientsB);
        assertArrayEquals(new int[]{5, 10, 30, 26, 52, 24}, result);
    }

    @Test
    public void can_multiply_two_polynomials_with_coefficients_of_equal_odd_lengths_using_divide_and_conquer() {
        int[] coefficientsA = {1, 2, 3};
        int[] coefficientsB = {3, 2, 2};

        int[] result = polynomialMultiplicationSolver.multiplyPolynomialsDivideAndConquer(coefficientsA, coefficientsB);
        assertArrayEquals(new int[]{3, 8, 15, 10, 6}, result);
    }

    @Test
    public void divide_and_conquer_method_throws_exception_for_null_input() {
        int[] coefficientsB = {3, 2, 2};

        try {
            polynomialMultiplicationSolver.multiplyPolynomialsDivideAndConquer(null, coefficientsB);
        } catch (NullPointerException e) {
            assertEquals("The array must not be null.", e.getMessage());
        }
    }

    @Test
    public void can_multiply_two_polynomials_with_coefficients_of_equal_odd_lengths_using_karatsuba() {
        int[] coefficientsA = {1, 2, 3};
        int[] coefficientsB = {3, 2, 2};

        int[] result = polynomialMultiplicationSolver.multiplyPolynomialsKaratsuba(coefficientsA, coefficientsB);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new int[]{3, 8, 15, 10, 6}, result);
    }
}
