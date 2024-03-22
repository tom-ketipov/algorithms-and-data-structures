package modules.algorithmic_toolbox.week_3.bonus;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumUnchangeableAmountSolverTest {

    private MinimumUnchangeableAmountSolver minimumUnchangeableAmountSolver;

    @BeforeEach
    void setUp() {
        minimumUnchangeableAmountSolver = new MinimumUnchangeableAmountSolver();
    }

    @Test
    public void should_return_first_unchangeable_amount_for_the_case_where_it_is_smaller_than_max_available_denomination() {
        int[] denominations = {1, 2, 4, 10};

        Assertions.assertEquals(8, minimumUnchangeableAmountSolver.findSmallestNonConstructableValue(denominations));
    }

    @Test
    public void should_return_first_unchangeable_amount_for_the_case_where_it_is_bigger_than_max_available_denomination() {
        int[] denominations = {1, 2, 4};

        Assertions.assertEquals(8, minimumUnchangeableAmountSolver.findSmallestNonConstructableValue(denominations));
    }

    @Test
    public void should_return_first_unchangeable_amount_for_the_case_where_it_is_smaller_than_min_available_denomination() {
        int[] denominations = {5, 2, 4};

        Assertions.assertEquals(1, minimumUnchangeableAmountSolver.findSmallestNonConstructableValue(denominations));
    }

    @Test
    public void throws_null_pointer_exception_for_null_input() {
        try {
            minimumUnchangeableAmountSolver.findSmallestNonConstructableValue(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}