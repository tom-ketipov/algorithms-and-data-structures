package modules.algorithmic_toolbox.week_2.assignments.least_common_multiple.assignments.challanges;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.least_common_multiple.LeastCommonMultipleListingMultiplesSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class LeastCommonMultipleListingMultiplesSolverTest {
    private LeastCommonMultipleListingMultiplesSolver leastCommonMultipleListingMultiplesSolverSolver;

    @BeforeEach
    public void setUp() {
        leastCommonMultipleListingMultiplesSolverSolver = new LeastCommonMultipleListingMultiplesSolver();
    }

    @Test
    public void can_find_lcm_of_two_positive_equal_numbers_with_listing_multiples_method() {
        Assertions.assertEquals(new BigInteger("256"), leastCommonMultipleListingMultiplesSolverSolver.findLCMWithListingMultiples(256, 256));
    }

    @Test
    public void can_find_lcm_when_on_of_the_numbers_is_one_with_listing_multiples_method() {
        Assertions.assertEquals(new BigInteger("55613212"), leastCommonMultipleListingMultiplesSolverSolver.findLCMWithListingMultiples(1, 55613212));
    }

    @Test
    public void can_find_lcm_with_two_larger_numbers_with_listing_multiples_method() {
        Assertions.assertEquals(new BigInteger("974085160802488"), leastCommonMultipleListingMultiplesSolverSolver.findLCMWithListingMultiples(12345623, 78901256));
    }

    @Test
    public void findLCMWithListingMultiples_throws_illegal_argument_exception_for_negative_input() {
        try {
            leastCommonMultipleListingMultiplesSolverSolver.findLCMWithListingMultiples(-1, 256);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void findLCMWithListingMultiples_throws_illegal_argument_exception_for_zero_input() {
        try {
            leastCommonMultipleListingMultiplesSolverSolver.findLCMWithListingMultiples(14, 0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }
}
