package modules.algorithmic_toolbox.week_1;

import org.junit.jupiter.api.Test;
import services.ValidationMessages;

import static org.junit.jupiter.api.Assertions.*;

class MaximumPairwiseProductTest {
    private MaximumPairwiseProduct maximumPairwiseProductSolver;

    @Test
    public void can_get_max_pairwise_product_of_multiple_distinct_values() {
        maximumPairwiseProductSolver = new MaximumPairwiseProduct();

        long[] values = {2004, -23, 122, 332, -4555, -21512, 7143, 2, 332, -1};
        assertEquals(14314572, maximumPairwiseProductSolver.maxPairwiseProduct(values));
    }

    @Test
    public void can_get_max_pairwise_product_of_multiple_identical_values() {
        maximumPairwiseProductSolver = new MaximumPairwiseProduct();

        long[] values = {2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004, 2004};
        assertEquals(4016016, maximumPairwiseProductSolver.maxPairwiseProduct(values));
    }

    @Test
    public void can_get_max_pairwise_product_of_single_value_array() {
        maximumPairwiseProductSolver = new MaximumPairwiseProduct();

        long[] values = {2004};
        assertEquals(2004, maximumPairwiseProductSolver.maxPairwiseProduct(values));
    }

    @Test
    public void throws_exception_for_empty_arrays() {
        maximumPairwiseProductSolver = new MaximumPairwiseProduct();

        try {
            maximumPairwiseProductSolver.maxPairwiseProduct(new long[0]);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_EMPTY_ARRAY_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_null_arrays() {
        maximumPairwiseProductSolver = new MaximumPairwiseProduct();

        try {
            maximumPairwiseProductSolver.maxPairwiseProduct(null);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}