package modules.algorithmic_toolbox.week_3.maximum_advertisement_revenue;

import org.junit.jupiter.api.Test;

import static modules.algorithmic_toolbox.week_3.maximum_advertisement_revenue.DotProducts.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumAdvertiserRevenueTest {
    private DotProducts dotProductsSolver;

    @Test
    public void can_calculate_maximum_advertiser_revenue() {
        dotProductsSolver = new DotProducts();

        int[] prices = {2, 3, 9};
        int[] clicks = {7, 4, 2};
        assertEquals(79, dotProductsSolver.maxDotProduct(prices, clicks));
    }

    @Test
    public void can_calculate_maximum_advertiser_for_single_value_arrays() {
        dotProductsSolver = new DotProducts();

        int[] prices = {23};
        int[] clicks = {39};
        assertEquals(897, dotProductsSolver.maxDotProduct(prices, clicks));
    }

    @Test
    public void throws_exception_for_null_prices_input_parameter() {
        dotProductsSolver = new DotProducts();

        int[] clicks = {39};
        try {
            dotProductsSolver.maxDotProduct(null, clicks);
        } catch (IllegalArgumentException e) {
            assertEquals(NON_NULL_PRICES_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_null_clicks_input_parameter() {
        dotProductsSolver = new DotProducts();

        int[] prices = {23};
        try {
            dotProductsSolver.maxDotProduct(prices, null);
        } catch (IllegalArgumentException e) {
            assertEquals(NON_NULL_CLICKS_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_prices_input_parameter() {
        dotProductsSolver = new DotProducts();

        int[] prices = {};
        int[] clicks = {39};
        try {
            dotProductsSolver.maxDotProduct(prices, clicks);
        } catch (IllegalArgumentException e) {
            assertEquals(NON_EMPTY_PRICES_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_clicks_input_parameter() {
        dotProductsSolver = new DotProducts();

        int[] prices = {23};
        int[] clicks = {};
        try {
            dotProductsSolver.maxDotProduct(prices, clicks);
        } catch (IllegalArgumentException e) {
            assertEquals(NON_EMPTY_CLICKS_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}
