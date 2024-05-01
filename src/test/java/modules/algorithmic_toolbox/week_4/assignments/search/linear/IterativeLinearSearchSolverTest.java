package modules.algorithmic_toolbox.week_4.assignments.search.linear;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IterativeLinearSearchSolverTest {
    private IterativeLinearSearchSolver iterativeLinearSearchSolver;

    @BeforeEach
    public void setUp() {
        iterativeLinearSearchSolver = new IterativeLinearSearchSolver();
    }

    @Test
    public void should_return_correct_index_for_existing_target_in_array_with_multiple_elements_using_an_iterative_approach() {
        int[] arr = {19, 433, 2, 125, 3, 3, 1, 1, 44, 32};
        int target = 2;

        Assertions.assertEquals(2, iterativeLinearSearchSolver.search(target, arr));
    }

    @Test
    public void should_return_the_first_occurrence_index_for_existing_target_in_array_that_contains_multiple_target_elements_using_an_iterative_approach() {
        int[] arr = {0, 0, 0, 3, 3};
        int target = 0;

        Assertions.assertEquals(0, iterativeLinearSearchSolver.search(target, arr));
    }

    @Test
    public void should_return_zero_for_existing_target_in_array_with_single_element_using_an_iterative_approach() {
        int[] arr = {5};
        int target = 5;

        Assertions.assertEquals(0, iterativeLinearSearchSolver.search(target, arr));
    }

    @Test
    public void should_return_minus_one_if_the_target_is_not_found_using_an_iterative_approach() {
        int[] arr = {1, 3, 45, 5, 2, 9, 12};
        int target = 4;

        Assertions.assertEquals(-1, iterativeLinearSearchSolver.search(target, arr));
    }

    @Test
    public void should_return_minus_one_for_empty_array_input_using_an_iterative_approach() {
        int[] arr = {};
        int target = 1;

        Assertions.assertEquals(-1, iterativeLinearSearchSolver.search(target, arr));
    }

    @Test
    public void throws_null_pointer_exception_for_null_input_array_for_the_iterative_linear_search_method_implementation() {
        try {
            iterativeLinearSearchSolver.search(90, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());

        }
    }
}
