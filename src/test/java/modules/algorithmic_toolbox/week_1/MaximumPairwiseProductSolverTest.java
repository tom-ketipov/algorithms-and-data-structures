package modules.algorithmic_toolbox.week_1;

import enums.ValidationMessageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MaximumPairwiseProductSolverTest {
    private MaximumPairwiseProductSolver maximumPairwiseProductSolver;

    @BeforeEach
    public void setUp() {
        maximumPairwiseProductSolver = new MaximumPairwiseProductSolver();
    }

    @Test
    public void can_get_max_pairwise_product_of_multiple_distinct_values() {
        long[] values = {2002777366291094L, -23, 44212, 332, -4555, -21512, 7143, 2, 332, -1};
        assertEquals(new BigInteger("88546792918461847928"), maximumPairwiseProductSolver.findMaxPairwiseProduct(values));
    }

    @Test
    public void can_get_max_pairwise_product_of_single_value_array() {
        long[] values = {2004};
        assertEquals(new BigInteger("2004"), maximumPairwiseProductSolver.findMaxPairwiseProduct(values));
    }

    @Test
    public void throws_illegal_argument_exception_for_empty_array_input() {
        try {
            maximumPairwiseProductSolver.findMaxPairwiseProduct(new long[0]);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessageType.EMPTY_ARRAY_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void throws_null_pointer_exception_for_null_inputs() {
        try {
            maximumPairwiseProductSolver.findMaxPairwiseProduct(null);
        } catch (NullPointerException e) {
            assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}