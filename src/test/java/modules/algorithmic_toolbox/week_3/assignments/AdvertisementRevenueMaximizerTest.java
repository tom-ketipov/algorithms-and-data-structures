package modules.algorithmic_toolbox.week_3.assignments;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.assignments.AdvertisementRevenueMaximizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdvertisementRevenueMaximizerTest {

    private AdvertisementRevenueMaximizer advertisementRevenueMaximizerSolver;

    @BeforeEach
    void setUp() {
        advertisementRevenueMaximizerSolver = new AdvertisementRevenueMaximizer();
    }

    @Test
    public void can_calculate_maximum_advertisement_revenue_correctly_for_valid_advertisement_slots_with_equal_prices_and_clicks() {
        int advertisementSlots = 3;
        int[] prices = {5, 3, 9};
        int[] clicks = {1, 4, 7};

        Assertions.assertEquals(86, advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, prices, clicks));
    }

    @Test
    public void can_calculate_maximum_advertisement_revenue_correctly_for_single_advertisement_slot_with_equal_prices_and_clicks_that_are_more_than_the_available_slots() {
        int advertisementSlots = 1;
        int[] prices = {5, 3, 9};
        int[] clicks = {1, 4, 7};

        Assertions.assertEquals(63, advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, prices, clicks));
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_zero_advertisement_slot_input() {
        int advertisementSlots = 0;
        int[] prices = {5, 3, 9};
        int[] clicks = {1, 4, 7};

        try {
            advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, prices, clicks);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_negative_advertisement_slot_input() {
        int advertisementSlots = -9;
        int[] prices = {5, 3, 9};
        int[] clicks = {1, 4, 7};

        try {
            advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, prices, clicks);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_above_maximum_advertisement_slot_input() {
        int advertisementSlots = 1001;
        int[] prices = {5, 3, 9};
        int[] clicks = {1, 4, 7};

        try {
            advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, prices, clicks);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_unequal_prices_and_clicks_lengths() {
        int advertisementSlots = 3;
        int[] prices = {5, 3, 9, 2};
        int[] clicks = {1, 4, 7};

        try {
            advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, prices, clicks);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_smaller_prices_and_clicks_lengths_than_the_available_advertiser_slots() {
        int advertisementSlots = 33;
        int[] prices = {5, 3, 9};
        int[] clicks = {1, 4, 7};

        try {
            advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, prices, clicks);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("The validated expression is false", e.getMessage());
        }
    }

    @Test
    public void null_pointer_exception_is_thrown_for_null_prices_input() {
        int advertisementSlots = 3;
        int[] clicks = {1, 4, 7};

        try {
            advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, null, clicks);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void null_pointer_exception_is_thrown_for_null_clicks_input() {
        int advertisementSlots = 3;
        int[] prices = {5, 3, 9};

        try {
            advertisementRevenueMaximizerSolver.calculateMaxAdvertisementRevenue(advertisementSlots, prices, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}