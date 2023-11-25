package week_3.maximum_advertisement_revenue;

import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

public class MaximumAdvertiserRevenueTest {
    private DotProducts dotProductsSolver;

    @Test
    public void can_calculate_maximum_advertiser_revenue() {
        dotProductsSolver = new DotProducts();

        int[] prices = {2, 3, 9};
        int[] clicks = {7, 4, 2};
        Assert.assertEquals(79, dotProductsSolver.maxDotProduct(prices, clicks));
    }

    @Test
    public void can_calculate_maximum_advertiser_for_single_value_arrays() {
        dotProductsSolver = new DotProducts();

        int[] prices = {23};
        int[] clicks = {39};
        Assert.assertEquals(897, dotProductsSolver.maxDotProduct(prices, clicks));
    }

    @Test
    public void throws_exception_for_null_prices_input_parameter() {
        dotProductsSolver = new DotProducts();

        int[] clicks = {39};
        try {
            dotProductsSolver.maxDotProduct(null, clicks);
        } catch (InvalidParameterException e) {
            Assert.assertEquals("Input array parameters cannot be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_null_clicks_input_parameter() {
        dotProductsSolver = new DotProducts();

        int[] prices = {23};
        try {
            dotProductsSolver.maxDotProduct(prices, null);
        } catch (InvalidParameterException e) {
            Assert.assertEquals("Input array parameters cannot be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_prices_input_parameter() {
        dotProductsSolver = new DotProducts();

        int[] prices = {};
        int[] clicks = {39};
        try {
            dotProductsSolver.maxDotProduct(prices, clicks);
        } catch (InvalidParameterException e) {
            Assert.assertEquals("Input array parameters cannot be empty.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_clicks_input_parameter() {
        dotProductsSolver = new DotProducts();

        int[] prices = {23};
        int[] clicks = {};
        try {
            dotProductsSolver.maxDotProduct(prices, clicks);
        } catch (InvalidParameterException e) {
            Assert.assertEquals("Input array parameters cannot be empty.", e.getMessage());
        }
    }
}
