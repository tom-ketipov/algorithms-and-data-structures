package modules.algorithmic_toolbox.week_2.least_common_multiple.assignments.challanges;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class ListingMultiplesLeastCommonMultipleTest {
    private ListingMultiplesLeastCommonMultiple listingMultiplesLeastCommonMultipleSolver;

    @BeforeEach
    public void setUp() {
        listingMultiplesLeastCommonMultipleSolver = new ListingMultiplesLeastCommonMultiple();
    }

    @Test
    public void can_find_lcm_of_two_positive_equal_numbers_with_listing_multiples_method() {
        Assertions.assertEquals(new BigInteger("256"), listingMultiplesLeastCommonMultipleSolver.findLCMWithListingMultiples(256, 256));
    }

    @Test
    public void can_find_lcm_when_on_of_the_numbers_is_one_with_listing_multiples_method() {
        Assertions.assertEquals(new BigInteger("55613212"), listingMultiplesLeastCommonMultipleSolver.findLCMWithListingMultiples(1, 55613212));
    }

    @Test
    public void can_find_lcm_with_two_larger_numbers_with_listing_multiples_method() {
        Assertions.assertEquals(new BigInteger("974085160802488"), listingMultiplesLeastCommonMultipleSolver.findLCMWithListingMultiples(12345623, 78901256));
    }

    @Test
    public void can_handle_negative_input_parameters_in_lcm_listing_multiples_method() {
        try {
            listingMultiplesLeastCommonMultipleSolver.findLCMWithListingMultiples(-1, 256);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }

    @Test
    public void can_handle_zero_input_for_both_parameters_in_lcm_listing_multiples_method() {
        try {
            listingMultiplesLeastCommonMultipleSolver.findLCMWithListingMultiples(0, 0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(1), e.getMessage());
        }
    }
}
