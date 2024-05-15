package modules.algorithmic_toolbox.week_4.assignments.sorting;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortSolverTest {

    private SelectionSortSolver selectionSortSolver;
    private InsertionSortSolver insertionSortSolver;
    private BubbleSortSolver bubbleSortSolver;

    @BeforeEach
    void setUp() {
        selectionSortSolver = new SelectionSortSolver();
        insertionSortSolver = new InsertionSortSolver();
        bubbleSortSolver = new BubbleSortSolver();
    }

    // Selection sort
    @Test
    public void should_be_able_to_sort_an_array_with_integers_with_selection_sort() {
        int[] array = {8, 4, 2, 5, 2};

        selectionSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{2, 2, 4, 5, 8}, array);
    }

    @Test
    public void should_return_input_array_for_sorted_array_inputs_with_selection_sort() {
        int[] array = {2, 2, 3, 4, 5};

        selectionSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{2, 2, 3, 4, 5}, array);
    }

    @Test
    public void should_throw_null_pointer_exception_for_null_input_in_selection_sort_method() {
        try {
            selectionSortSolver.sort(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    // Insertion sort
    @Test
    public void should_be_able_to_sort_an_array_with_integers_with_insertion_sort() {
        int[] array = {8, 4, 2, 5, 2};

        insertionSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{2, 2, 4, 5, 8}, array);
    }

    @Test
    public void should_return_input_array_for_sorted_array_inputs_with_insertion_sort() {
        int[] array = {2, 2, 3, 4, 5};

        insertionSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{2, 2, 3, 4, 5}, array);
    }

    @Test
    public void should_throw_null_pointer_exception_for_null_input_in_insertion_sort_method() {
        try {
            insertionSortSolver.sort(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }

    // Bubble sort
    @Test
    public void should_be_able_to_sort_an_array_with_integers_with_bubble_sort() {
        int[] array = {8, 4, 2, 5, 2};

        bubbleSortSolver.sort(array);
        System.out.println(Arrays.toString(array));
        Assertions.assertArrayEquals(new int[]{2, 2, 4, 5, 8}, array);
    }

    @Test
    public void should_return_input_array_for_sorted_array_inputs_with_bubble_sort() {
        int[] array = {2, 2, 3, 4, 5};

        bubbleSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{2, 2, 3, 4, 5}, array);
    }

    @Test
    public void should_throw_null_pointer_exception_for_null_input_in_bubble_sort_method() {
        try {
            bubbleSortSolver.sort(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}