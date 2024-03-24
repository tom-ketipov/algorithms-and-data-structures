package modules.algorithmic_toolbox.week_4.assignments.search.binary;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IterativeBinarySearchSolverTest {
    private IterativeBinarySearchSolver iterativeBinarySearchSolver;

    @BeforeEach
    public void setUp() {
        iterativeBinarySearchSolver = new IterativeBinarySearchSolver();
    }

    @Test
    public void should_return_correct_index_for_existing_target_element_located_in_the_first_position_in_array_of_multiple_elements_using_iterative_binary_search() {
        int[] array = {1, 3, 5, 7, 9, 12, 16, 19, 25};
        int target = 1;

        Assertions.assertEquals(0, iterativeBinarySearchSolver.search(target, array));
    }

    @Test
    public void should_return_correct_index_for_existing_target_element_located_in_the_last_position_in_array_of_multiple_elements_using_iterative_binary_search() {
        int[] array = {1, 3, 5, 7, 9, 12, 16, 19, 25};
        int target = 25;

        Assertions.assertEquals(array.length - 1, iterativeBinarySearchSolver.search(target, array));
    }

    @Test
    public void should_return_minus_one_for_non_existing_target_element_when_using_iterative_binary_search() {
        int[] array = {2, 200, 240, 266, 332, 1000, 1200};
        int target = 999;

        Assertions.assertEquals(-1, iterativeBinarySearchSolver.search(target, array));
    }

    @Test
    public void throws_null_pointer_exception_for_null_input_when_using_the_iterative_binary_search_method_implementation() {
        try {
            iterativeBinarySearchSolver.search(5, null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}
