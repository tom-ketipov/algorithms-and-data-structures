package modules.week_3.assignments;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_3.assignments.DistinctPrizeDistributor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistinctPrizeDistributorTest {
    private DistinctPrizeDistributor distinctPrizeDistributorSolver;

    @BeforeEach
    public void setUp() {
        distinctPrizeDistributorSolver = new DistinctPrizeDistributor();
    }

    @Test
    public void can_calculate_maximum_number_of_prizes_for_total_sum_of_one() {
        Assertions.assertEquals(1, distinctPrizeDistributorSolver.calculateMaximumDistinctPrizes(1));
    }

    @Test
    public void can_calculate_maximum_number_of_prizes_for_max_allowed_total_sum() {
        Assertions.assertEquals(44720, distinctPrizeDistributorSolver.calculateMaximumDistinctPrizes(1000000000));
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_zero_total_sum_input() {
        try {
            distinctPrizeDistributorSolver.calculateMaximumDistinctPrizes(0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000000000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_negative_total_sum_input() {
        try {
            distinctPrizeDistributorSolver.calculateMaximumDistinctPrizes(-10);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000000000), e.getMessage());
        }
    }

    @Test
    public void illegal_argument_exception_is_thrown_for_more_than_max_allowed_total_sum_input() {
        try {
            distinctPrizeDistributorSolver.calculateMaximumDistinctPrizes(1000000001);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.OUT_OF_RANGE_ERROR.getMessage(1, 1000000000), e.getMessage());
        }
    }
}
