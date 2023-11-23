package week_3.maximum_advertisement_revenue;

import org.junit.Assert;
import org.junit.Test;

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
}
