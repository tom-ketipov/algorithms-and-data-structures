package modules.algorithmic_toolbox.week_4.assignments.polynomial_multiplication;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NaiveDivideAndConquerPolynomialMultiplicationSolverTest {
    private NaiveDivideAndConquerPolynomialMultiplicationSolver naiveDivideAndConquerPolynomialMultiplicationSolver;

    @BeforeEach
    public void setUp() {
        naiveDivideAndConquerPolynomialMultiplicationSolver = new NaiveDivideAndConquerPolynomialMultiplicationSolver();
    }

    @Test
    public void should_return_correct_result_for_multiplication_of_two_odd_polynomials() {
        int[] polynomialA = {3, 2, 5};
        int[] polynomialB = {5, 1, 2};

        int[] productPolynomial = naiveDivideAndConquerPolynomialMultiplicationSolver.multiply(polynomialA, polynomialB);
        System.out.println(Arrays.toString(productPolynomial));
        Assertions.assertArrayEquals(new int[]{15, 13, 33, 9, 10}, productPolynomial);
    }

    @Test
    public void should_return_correct_result_for_multiplication_of_two_even_polynomials() {
        int[] polynomialA = {4, 3, 2, 1};
        int[] polynomialB = {1, 2, 3, 4};

        int[] productPolynomial = naiveDivideAndConquerPolynomialMultiplicationSolver.multiply(polynomialA, polynomialB);
        Assertions.assertArrayEquals(new int[]{4, 11, 20, 30, 20, 11, 4}, productPolynomial);
    }

    @Test
    public void should_throw_null_pointer_exception_if_polynomialA_is_null() {
        int[] polynomialB = {1, 2, 3, 4};

        try {
            naiveDivideAndConquerPolynomialMultiplicationSolver.multiply(null, polynomialB);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void should_throw_null_pointer_exception_if_polynomialB_is_null() {
        int[] polynomialA = {4, 3, 2, 1};

        try {
            naiveDivideAndConquerPolynomialMultiplicationSolver.multiply(polynomialA, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}
