package modules.algorithmic_toolbox.week_4.assignments.search.linear;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecursiveLinearSearchSolverTest {
    private RecursiveLinearSearchSolver recursiveLinearSearchSolver;

    @BeforeEach
    public void setUp() {
        recursiveLinearSearchSolver = new RecursiveLinearSearchSolver();
    }

    @Test
    public void should_return_correct_index_for_existing_target_in_array_with_multiple_elements_using_a_recursive_approach() {
        int[] arr = {1, 3, 8, 5, 34};
        int target = 34;

        Assertions.assertEquals(4, recursiveLinearSearchSolver.search(target, arr));
    }

    @Test
    public void should_return_the_first_occurrence_index_for_existing_target_in_array_that_contains_multiple_target_elements_using_a_recursive_approach() {
        int[] arr = {1, 3, 3, 3, 3};
        int target = 3;

        Assertions.assertEquals(1, recursiveLinearSearchSolver.search(target, arr));
    }

    @Test
    public void should_return_zero_for_existing_target_in_array_with_single_element_using_a_recursive_approach() {
        int[] arr = {1};
        int target = 1;

        Assertions.assertEquals(0, recursiveLinearSearchSolver.search(target, arr));
    }

    @Test
    public void should_return_minus_one_if_the_target_is_not_found_using_a_recursive_approach() {
        int[] arr = {1, 3, 8, 5, 34};
        int target = 4;

        Assertions.assertEquals(-1, recursiveLinearSearchSolver.search(target, arr));
    }

    @Test
    public void should_return_minus_one_for_empty_array_input_using_a_recursive_approach() {
        int[] arr = {};
        int target = 4;

        Assertions.assertEquals(-1, recursiveLinearSearchSolver.search(target, arr));
    }

    @Test
    public void throws_null_pointer_exception_for_null_input_array_in_the_recursive_linear_search_method_implementation() {
        try {
            recursiveLinearSearchSolver.search(4, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}
