package modules.algorithmic_toolbox.week_2.assignments.least_common_multiple.assignments.challanges;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.least_common_multiple.assignments.challanges.GreatestCommonFactorLeastCommonMultiple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class GreatestCommonFactorLeastCommonMultipleTest {
    private GreatestCommonFactorLeastCommonMultiple greatestCommonFactorLeastCommonMultipleSolver;

    @BeforeEach
    public void setUp() {
        greatestCommonFactorLeastCommonMultipleSolver = new GreatestCommonFactorLeastCommonMultiple();
    }

    @Test
    public void can_find_lcm_of_two_positive_equal_numbers_with_listing_multiples_method() {
        BigInteger a = new BigInteger("256");

        Assertions.assertEquals(a, greatestCommonFactorLeastCommonMultipleSolver.findLCMWithGreatestCommonFactor(a, a));
    }

    @Test
    public void can_find_lcm_when_on_of_the_numbers_is_one_with_listing_multiples_method() {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger("55613212");

        Assertions.assertEquals(b, greatestCommonFactorLeastCommonMultipleSolver.findLCMWithGreatestCommonFactor(a, b));
    }

    @Test
    public void can_find_lcm_with_two_large_numbers_with_greatest_common_factor_method() {
        BigInteger a = new BigInteger("21551510387081829975861502260312071903172086094081298321581077282");
        BigInteger b = new BigInteger("43466557686937456435322725523428567434212688527675");

        Assertions.assertEquals(new BigInteger("936769969480724153951522400397268513236862629833859590958612028172736800486476395785313870471471962393248970779350"), greatestCommonFactorLeastCommonMultipleSolver.findLCMWithGreatestCommonFactor(a, b));
    }

    @Test
    public void can_handle_negative_input_in_greatest_common_factor_lcm_method() {
        BigInteger a = new BigInteger("256");
        BigInteger b = new BigInteger("-12");

        try {
            greatestCommonFactorLeastCommonMultipleSolver.findLCMWithGreatestCommonFactor(a, b);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(0), e.getMessage());
        }
    }

    @Test
    public void can_handle_null_input_in_greatest_common_factor_lcm_method() {
        BigInteger b = new BigInteger("23");

        try {
            greatestCommonFactorLeastCommonMultipleSolver.findLCMWithGreatestCommonFactor(null, b);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void can_handle_zero_input_for_both_parameters_in_greatest_common_factor_lcm_method() {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ZERO;

        try {
            greatestCommonFactorLeastCommonMultipleSolver.findLCMWithGreatestCommonFactor(a, b);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }
}
