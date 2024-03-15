package modules.algorithmic_toolbox.week_2.bonus;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeSumTest {
    private RangeSum rangeSumSolver;

    @BeforeEach
    void setUp() {
        rangeSumSolver = new RangeSum();
    }

    @Test
    public void can_find_range_sum_for_valid_nums_and_range_queries_input_parameters() {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] rangeQueries = {{1, 3}, {0, 2}, {2, 4}};

        Assertions.assertArrayEquals(new int[]{9, 6, 12}, rangeSumSolver.rangeSum(nums, rangeQueries));
    }

    @Test
    public void can_handle_empty_nums_array_when_there_are_valid_range_queries() {
        int[][] rangeQueries = {{0, 0}, {1, 2}};

        Assertions.assertArrayEquals(new int[]{0, 0}, rangeSumSolver.rangeSum(new int[]{}, rangeQueries));
    }

    @Test
    public void can_handle_valid_nums_with_empty_range_queries() {
        int[] nums = {14, 562, 32, 632, 12334};

        Assertions.assertArrayEquals(new int[]{}, rangeSumSolver.rangeSum(nums, new int[][]{}));
    }

    @Test
    public void can_find_range_sum_for_valid_nums_when_range_queries_have_same_start_end_indexes() {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] rangeQueries = {{2, 2}, {4, 4}};

        Assertions.assertArrayEquals(new int[]{3, 5}, rangeSumSolver.rangeSum(nums, rangeQueries));
    }

    @Test
    public void can_find_range_sum_for_valid_nums_when_for_single_full_range_query() {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] rangeQueries = {{0, 4}};

        Assertions.assertArrayEquals(new int[]{15}, rangeSumSolver.rangeSum(nums, rangeQueries));
    }

    @Test
    public void can_handle_null_input_for_nums_parameter() {
        int[][] rangeQueries = {{0, 4}};

        try {
            rangeSumSolver.rangeSum(null, rangeQueries);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void can_handle_null_input_for_query_range_parameter() {
        int[] nums = {1, 2, 3, 4, 5};

        try {
            rangeSumSolver.rangeSum(nums, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    @Test
    public void can_handle_null_input_for_single_query_range() {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] rangeQueries = {{0, 4}, null};

        try {
            rangeSumSolver.rangeSum(nums, rangeQueries);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}