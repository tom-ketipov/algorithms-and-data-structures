package modules.algorithmic_toolbox.week_2.prime;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    public void can_detect_three_as_a_prime_number() {
        Assertions.assertTrue(naivePrimeNumberValidatorSolver.isPrime(3));
    }

    @Test
    public void can_detect_ten_as_a_non_prime_number() {
        Assertions.assertFalse(naivePrimeNumberValidatorSolver.isPrime(10));
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
    public void can_handle_one_as_input_parameter_in_naive_prime_number_validator_method() {
        try {
            naivePrimeNumberValidatorSolver.isPrime(1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }

    @Test
    public void can_handle_zero_as_input_parameter_in_naive_prime_number_validator_method() {
        try {
            naivePrimeNumberValidatorSolver.isPrime(0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }

    @Test
    public void can_handle_negative_input_parameter_in_naive_prime_number_validator_method() {
        try {
            naivePrimeNumberValidatorSolver.isPrime(-230);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }
}