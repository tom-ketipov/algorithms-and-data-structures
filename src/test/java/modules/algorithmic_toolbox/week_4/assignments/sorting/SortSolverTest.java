package modules.algorithmic_toolbox.week_4.assignments.sorting;

import enums.ValidationMessageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

class SortSolverTest {

    private SelectionSortSolver selectionSortSolver;
    private InsertionSortSolver insertionSortSolver;
    private BubbleSortSolver bubbleSortSolver;
    private MergeSortSolver mergeSortSolver;

    @BeforeEach
    void setUp() {
        selectionSortSolver = new SelectionSortSolver();
        insertionSortSolver = new InsertionSortSolver();
        bubbleSortSolver = new BubbleSortSolver();
        mergeSortSolver = new MergeSortSolver();
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
    public void should_throw_null_pointer_exception_for_null_input_in_selection_sort() {
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
    public void should_throw_null_pointer_exception_for_null_input_in_insertion_sort() {
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
        Assertions.assertArrayEquals(new int[]{2, 2, 4, 5, 8}, array);
    }

    @Test
    public void should_return_input_array_for_sorted_array_inputs_with_bubble_sort() {
        int[] array = {2, 2, 3, 4, 5};

        bubbleSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{2, 2, 3, 4, 5}, array);
    }

    @Test
    public void should_throw_null_pointer_exception_for_null_input_in_bubble_sort() {
        try {
            bubbleSortSolver.sort(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }


    // Merge sort
    @Test
    public void should_be_able_to_sort_an_array_with_integers_with_merge_sort() {
        int[] array = {8, 16, 2, 5, 2};

        mergeSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{2, 2, 5, 8, 16}, array);
    }

    @Test
    public void should_return_input_array_for_sorted_array_inputs_with_merge_sort() {
        int[] array = {2, 2, 3, 4, 5};

        mergeSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{2, 2, 3, 4, 5}, array);
    }

    @Test
    public void should_return_input_for_single_element_array_inputs_with_merge_sort() {
        int[] array = {672};

        mergeSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{672}, array);
    }

    @Test
    public void should_throw_null_pointer_exception_for_null_input_in_merge_sort() {
        try {
            mergeSortSolver.sort(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}