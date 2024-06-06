package modules.algorithmic_toolbox.week_2.assignments.prime;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.prime.NaivePrimeNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class NaivePrimeNumberValidatorTest {
    private NaivePrimeNumberValidator naivePrimeNumberValidatorSolver;

    @BeforeEach
    public void setUp() {
        naivePrimeNumberValidatorSolver = new NaivePrimeNumberValidator();
    }

    @Test
    public void can_detect_two_as_a_prime_number() {
        Assertions.assertTrue(naivePrimeNumberValidatorSolver.isPrime(2));
    }

    @Test
    public void can_detect_four_as_a_non_prime_number() {
        Assertions.assertFalse(naivePrimeNumberValidatorSolver.isPrime(4));
    }

    @Test
    public void can_detect_max_integer_as_a_prime_number() {
        Assertions.assertTrue(naivePrimeNumberValidatorSolver.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void can_detect_larger_value_as_a_non_prime_number() {
        Assertions.assertFalse(naivePrimeNumberValidatorSolver.isPrime(244646864));
    }

    @Test
    public void can_detect_larger_value_prime_number() {
        Assertions.assertTrue(naivePrimeNumberValidatorSolver.isPrime(19999999));
    }

    @Test
    public void throws_illegal_argument_exception_for_input_values_that_are_less_than_two() {
        try {
            naivePrimeNumberValidatorSolver.isPrime(1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }
}