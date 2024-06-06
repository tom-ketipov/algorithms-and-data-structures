package modules.algorithmic_toolbox.week_4.assignments.sorting;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_4.assignments.sorting.quick_sort.LeftMostPivotQuickSortSolver;
import modules.algorithmic_toolbox.week_4.assignments.sorting.quick_sort.RandomPivotQuickSortSolver;
import modules.algorithmic_toolbox.week_4.assignments.sorting.quick_sort.RightMostPivotQuickSortSolver;
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
    private LeftMostPivotQuickSortSolver leftMostPivotQuickSortSolver;
    private RightMostPivotQuickSortSolver rightMostPivotQuickSortSolver;
    private RandomPivotQuickSortSolver randomPivotQuickSortSolver;


    @BeforeEach
    void setUp() {
        selectionSortSolver = new SelectionSortSolver();
        insertionSortSolver = new InsertionSortSolver();
        bubbleSortSolver = new BubbleSortSolver();
        mergeSortSolver = new MergeSortSolver();
        leftMostPivotQuickSortSolver = new LeftMostPivotQuickSortSolver();
        rightMostPivotQuickSortSolver = new RightMostPivotQuickSortSolver();
        randomPivotQuickSortSolver = new RandomPivotQuickSortSolver();
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


    // Quick sort - Leftmost pivot
    @Test
    public void multiple_elements_array_is_sorted_correctly_using_leftmost_pivot_quick_sort_solver() {
        int[] array = {6, 7, 8, 2, 13, -22, 2, 1, 6, -1, 0, 0, 6, 0};

        leftMostPivotQuickSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{-22, -1, 0, 0, 0, 1, 2, 2, 6, 6, 6, 7, 8, 13}, array);
    }

    @Test
    public void single_element_array_is_sorted_correctly_using_leftmost_pivot_quick_sort_solver() {
        int[] array = {6};

        leftMostPivotQuickSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{6}, array);
    }

    @Test
    public void empty_array_is_handled_correctly_using_leftmost_pivot_quick_sort_solver() {
        int[] array = {};

        leftMostPivotQuickSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void leftmost_pivot_quick_sort_method_throws_null_pointer_exception_for_null_input() {
        try {
            leftMostPivotQuickSortSolver.sort(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }


    // Quick sort - Rightmost pivot
    @Test
    public void multiple_elements_array_is_sorted_correctly_using_rightmost_pivot_quick_sort_solver() {
        int[] array = {6, 7, 8, 2, 13, -22, 2, 1, 6, -1, 0, 0, 6, 0};

        rightMostPivotQuickSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{-22, -1, 0, 0, 0, 1, 2, 2, 6, 6, 6, 7, 8, 13}, array);
    }

    @Test
    public void single_element_array_is_sorted_correctly_using_rightmost_pivot_quick_sort_solver() {
        int[] array = {6};

        rightMostPivotQuickSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{6}, array);
    }

    @Test
    public void empty_array_is_handled_correctly_using_rightmost_pivot_quick_sort_solver() {
        int[] array = {};

        rightMostPivotQuickSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void rightmost_pivot_quick_sort_method_throws_null_pointer_exception_for_null_input() {
        try {
            rightMostPivotQuickSortSolver.sort(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }


    // Quick sort - Random pivot
    @Test
    public void multiple_elements_array_is_sorted_correctly_using_random_pivot_quick_sort_solver() {
        int[] array = {6, 7, 8, 2, 13, -22, 2, 1, 6, -1, 0, 0, 6, 0};

        randomPivotQuickSortSolver.sort(array);
        System.out.println(Arrays.toString(array));
        Assertions.assertArrayEquals(new int[]{-22, -1, 0, 0, 0, 1, 2, 2, 6, 6, 6, 7, 8, 13}, array);
    }

    @Test
    public void single_element_array_is_sorted_correctly_using_random_pivot_quick_sort_solver() {
        int[] array = {6};

        randomPivotQuickSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{6}, array);
    }

    @Test
    public void empty_array_is_handled_correctly_using_random_pivot_quick_sort_solver() {
        int[] array = {};

        randomPivotQuickSortSolver.sort(array);
        Assertions.assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void random_pivot_quick_sort_method_throws_null_pointer_exception_for_null_input() {
        try {
            randomPivotQuickSortSolver.sort(null);
        } catch (NullPointerException e) {
            Assertions.assertEquals(ValidationMessageType.NULL_VALUE_ERROR.getMessage(), e.getMessage());
        }
    }
}