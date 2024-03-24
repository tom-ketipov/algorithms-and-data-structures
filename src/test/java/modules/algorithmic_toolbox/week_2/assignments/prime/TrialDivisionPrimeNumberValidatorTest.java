package modules.algorithmic_toolbox.week_2.assignments.prime;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.prime.TrialDivisionPrimeNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrialDivisionPrimeNumberValidatorTest {
    private TrialDivisionPrimeNumberValidator trialDivisionPrimeNumberValidator;

    @BeforeEach
    public void setUp() {
        trialDivisionPrimeNumberValidator = new TrialDivisionPrimeNumberValidator();
    }

    @Test
    public void can_detect_min_prime_with_trial_division_solution() {
        Assertions.assertTrue(trialDivisionPrimeNumberValidator.isPrime(2));
    }

    @Test
    public void can_detect_max_int_type_prime_with_trial_division_solution() {
        Assertions.assertTrue(trialDivisionPrimeNumberValidator.isPrime(2147483629));
    }

    @Test
    public void can_detect_max_int_type_non_prime_with_trial_division_solution() {
        Assertions.assertFalse(trialDivisionPrimeNumberValidator.isPrime(2147483628));
    }

    @Test
    public void can_handle_one_as_input_parameter_in_trial_division__prime_number_validator_method() {
        try {
            trialDivisionPrimeNumberValidator.isPrime(1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }

    @Test
    public void can_handle_zero_as_input_parameter_in_naive_prime_number_validator_method() {
        try {
            trialDivisionPrimeNumberValidator.isPrime(0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }

    @Test
    public void can_handle_negative_input_parameter_in_naive_prime_number_validator_method() {
        try {
            trialDivisionPrimeNumberValidator.isPrime(-230);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }
}
