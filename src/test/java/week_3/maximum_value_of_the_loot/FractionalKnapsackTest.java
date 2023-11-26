package week_3.maximum_value_of_the_loot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

public class FractionalKnapsackTest {
    private FractionalKnapsack fractionalKnapsackSolver;

    @Test
    public void can_calculate_max_heist_amount() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 10;
        int[] values = {48, 125, 14, 22};
        int[] weights = {6, 25, 2, 12};
        Assertions.assertEquals(72, fractionalKnapsackSolver.getOptimalValue(capacity, values, weights), 0);
    }

    @Test
    public void can_handle_capacity_of_one() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 1;
        int[] values = {48, 125, 14, 22};
        int[] weights = {6, 25, 2, 12};
        Assertions.assertEquals(8, fractionalKnapsackSolver.getOptimalValue(capacity, values, weights), 0);
    }

    @Test
    public void can_handle_capacity_bigger_than_the_amount_of_available_loot_weight() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 71;
        int[] values = {24, 15, 114, 3500, 5, 500};
        int[] weights = {6, 5, 28, 110, 1, 2};
        Assertions.assertEquals(2695.4545454545455, fractionalKnapsackSolver.getOptimalValue(capacity, values, weights), 0);
    }

    @Test
    public void can_handle_cases_where_there_are_more_weights_than_values() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 71;
        int[] values = {24, 15, 114, 3500, 5, 500};
        int[] weights = {6, 5, 28, 110, 1, 2, 18, 55, 123, 100, 234, 10};
        Assertions.assertEquals(2695.4545454545455, fractionalKnapsackSolver.getOptimalValue(capacity, values, weights), 0);
    }

    @Test
    public void throws_exception_for_invalid_capacity_input_parameter() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 0;
        int[] values = {24, 15, 114, 3500, 5, 500};
        int[] weights = {6, 5, 28, 110, 1, 2, 18, 55, 123, 100, 234, 10};

        try {
            fractionalKnapsackSolver.getOptimalValue(capacity, values, weights);
        } catch (InvalidParameterException e) {
            Assertions.assertEquals("Capacity cannot be equal to 0.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_null_values_input_parameter() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 71;
        int[] weights = {6, 5, 28, 110, 1, 2, 18, 55, 123, 100, 234, 10};

        try {
            fractionalKnapsackSolver.getOptimalValue(capacity, null, weights);
        } catch (InvalidParameterException e) {
            Assertions.assertEquals("Values/weights cannot be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_null_weights_input_parameter() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 71;
        int[] values = {24, 15, 114, 3500, 5, 500};

        try {
            fractionalKnapsackSolver.getOptimalValue(capacity, values, null);
        } catch (InvalidParameterException e) {
            Assertions.assertEquals("Values/weights cannot be null.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_values_input_parameter() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 71;
        int[] values = {};
        int[] weights = {6, 5, 28, 110, 1, 2, 18, 55, 123, 100, 234, 10};

        try {
            fractionalKnapsackSolver.getOptimalValue(capacity, values, weights);
        } catch (InvalidParameterException e) {
            Assertions.assertEquals("Values/weights cannot be empty.", e.getMessage());
        }
    }

    @Test
    public void throws_exception_for_empty_weights_input_parameter() {
        fractionalKnapsackSolver = new FractionalKnapsack();

        int capacity = 71;
        int[] values = {24, 15, 114, 3500, 5, 500};
        int[] weights = {};

        try {
            fractionalKnapsackSolver.getOptimalValue(capacity, values, weights);
        } catch (InvalidParameterException e) {
            Assertions.assertEquals("Values/weights cannot be empty.", e.getMessage());
        }
    }
}
