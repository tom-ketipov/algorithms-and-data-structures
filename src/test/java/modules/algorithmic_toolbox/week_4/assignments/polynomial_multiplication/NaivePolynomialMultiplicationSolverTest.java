package modules.algorithmic_toolbox.week_4.assignments.polynomial_multiplication;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NaivePolynomialMultiplicationSolverTest {
    private NaivePolynomialMultiplicationSolver naivePolynomialMultiplicationSolver;

    @BeforeEach
    public void setUp() {
        naivePolynomialMultiplicationSolver = new NaivePolynomialMultiplicationSolver();
    }

    @Test
    public void should_return_correct_result_for_two_third_degree_polynomials_using_naive_approach() {
        int[] polynomialA = {4, 3, 6};
        int[] polynomialB = {5, 0, 3};
        int degree = 3;

        int[] productPolynomial = naivePolynomialMultiplicationSolver.multiply(degree, polynomialA, polynomialB);
        Assertions.assertArrayEquals(new int[]{20, 15, 42, 9, 18}, productPolynomial);
    }

    @Test
    public void should_return_correct_result_for_two_different_degree_polynomials_using_naive_approach() {
        int[] polynomialA = {4, 3, 6};
        int[] polynomialB = {0, 0, 3};
        int degree = 3;

        int[] productPolynomial = naivePolynomialMultiplicationSolver.multiply(degree, polynomialA, polynomialB);
        Assertions.assertArrayEquals(new int[]{12, 9, 18}, productPolynomial);
    }

    @Test
    public void should_return_correct_result_for_two_first_degree_polynomials_using_naive_approach() {
        int[] polynomialA = {36};
        int[] polynomialB = {2};
        int degree = 1;

        int[] productPolynomial = naivePolynomialMultiplicationSolver.multiply(degree, polynomialA, polynomialB);
        Assertions.assertArrayEquals(new int[]{72}, productPolynomial);
    }

    @Test
    public void throws_illegal_argument_exception_for_zero_degree_input() {
        int[] polynomialA = {4, 3, 6};
        int[] polynomialB = {5, 0, 3};
        int degree = 0;

        try {
            naivePolynomialMultiplicationSolver.multiply(degree, polynomialA, polynomialB);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void throws_null_pointer_exception_for_null_input_of_first_polynomial() {
        int[] polynomialB = {5, 0, 3};
        int degree = 3;

        try {
            naivePolynomialMultiplicationSolver.multiply(degree, null, polynomialB);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void throws_null_pointer_exception_for_null_input_of_second_polynomial() {
        int[] polynomialA = {5, 0, 3};
        int degree = 3;

        try {
            naivePolynomialMultiplicationSolver.multiply(degree, polynomialA, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}
