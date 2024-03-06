package modules.algorithmic_toolbox.week_2.greatest_common_divisor.assignments.challanges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NaiveGreatestCommonDivisorTest {

    private NaiveGreatestCommonDivisor naiveGreatestCommonDivisorSolver;

    @BeforeEach
    void setUp() {
        naiveGreatestCommonDivisorSolver = new NaiveGreatestCommonDivisor();
    }

    @Test
    public void can_find_gcd_when_one_of_the_numbers_is_zero() {
        Assertions.assertEquals(4, naiveGreatestCommonDivisorSolver.naiveGCDFinder(4, 0));
    }

    @Test
    public void can_find_gcd_when_two_of_the_numbers_are_zero() {
        Assertions.assertEquals(0, naiveGreatestCommonDivisorSolver.naiveGCDFinder(0, 0));
    }

    @Test
    public void can_find_gcd_when_of_two_positive_even_numbers() {
        Assertions.assertEquals(2, naiveGreatestCommonDivisorSolver.naiveGCDFinder(10, 6));
    }

    @Test
    public void can_find_gcd_when_of_two_positive_numbers_where_one_is_odd_and_one_even() {
        Assertions.assertEquals(1, naiveGreatestCommonDivisorSolver.naiveGCDFinder(10, 7));
    }

    @Test
    public void can_handle_negative_inputs_for_gcd_method_for_first_parameter() {
        try {
            naiveGreatestCommonDivisorSolver.naiveGCDFinder(-5, 5);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }

    @Test
    public void can_handle_negative_inputs_for_gcd_method_for_second_parameter() {
        try {
            naiveGreatestCommonDivisorSolver.naiveGCDFinder(231, -21);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }
}