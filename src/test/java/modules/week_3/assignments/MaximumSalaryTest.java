package modules.week_3.assignments;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.assignments.MaximumSalary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class MaximumSalaryTest {
    private MaximumSalary maximumSalarySolver;

    @BeforeEach
    void setUp() {
        maximumSalarySolver = new MaximumSalary();
    }

    @Test
    public void maximize_salary_returns_correct_value_with_single_element_input_array() {
        int[] digits = {578};

        Assertions.assertEquals(new BigInteger("578"), maximumSalarySolver.maximizeSalary(digits));
    }

    @Test
    public void maximize_salary_returns_correct_value_with_single_zero_element_input_array() {
        int[] digits = {0};

        Assertions.assertEquals(BigInteger.ZERO, maximumSalarySolver.maximizeSalary(digits));
    }

    @Test
    public void maximize_salary_returns_correct_value_with_multiple_zero_elements_input_array() {
        int[] digits = {0, 0, 0, 0, 0, 0};

        Assertions.assertEquals(BigInteger.ZERO, maximumSalarySolver.maximizeSalary(digits));
    }

    @Test
    public void maximize_salary_returns_correct_value_with_only_single_digit_inputs() {
        int[] digits = {5, 7, 8, 9, 2, 1};

        Assertions.assertEquals(new BigInteger("987521"), maximumSalarySolver.maximizeSalary(digits));
    }

    @Test
    public void maximize_salary_returns_correct_value_with_varied_length_digits_in_input_array() {
        int[] digits = {5, 52, 57, 517, 532, 569, 581, 234, 2212, 5513242, 21, 1};

        Assertions.assertEquals(new BigInteger("5815756955513242532525172342212211"), maximumSalarySolver.maximizeSalary(digits));
    }

    @Test
    public void maximize_salary_throws_null_pointer_exception_with_null_input_parameters() {
        try {
            maximumSalarySolver.maximizeSalary(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void maximize_salary_throws_illegal_argument_exception_for_negative_values_in_the_input_array() {
        int[] digits = {8, 123, -5, 12};

        try {
            maximumSalarySolver.maximizeSalary(digits);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }
}