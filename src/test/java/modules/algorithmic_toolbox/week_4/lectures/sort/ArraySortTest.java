package modules.algorithmic_toolbox.week_4.lectures.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraySortTest {
    private SelectionSort selectionSortSolver;
    private InsertionSort insertionSortSolver;
    private MergeSort mergeSortSolver;
    private QuickSort quickSortSolver;

    @BeforeEach
    public void setUp() {
        selectionSortSolver = new SelectionSort();
        insertionSortSolver = new InsertionSort();
        mergeSortSolver = new MergeSort();
        quickSortSolver = new QuickSort();
    }

    @Test
    public void can_sort_array_with_iterative_selection_sort() {
        int[] array = {2, 5, 1, 3, 23, 41};
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, selectionSortSolver.selectionSort(array));
    }

    @Test
    public void can_sort_array_with_recursive_selection_sort() {
        int[] array = {2, 5, 1, 3, 23, 41};

        selectionSortSolver.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, array);
    }

    @Test
    public void can_sort_array_with_insertion_sort() {
        int[] array = {2, 5, 1, 3, 23, 41};

        insertionSortSolver.insertionSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, array);
    }

    @Test
    public void can_sort_array_with_recursive_insertion_sort() {
        int[] array = {2, 5, 1, 3, 23, 41};

        insertionSortSolver.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, array);
    }

    @Test
    public void can_sort_array_with_merge_sort() {
        int[] array = {2, 5, 1, 3, 23, 41};

        mergeSortSolver.mergeSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, array);
    }

    @Test
    public void can_sort_array_with_quick_sort() {
        int[] array = {2, 5, 1, 3, 23, 41};

        quickSortSolver.quickSort(array, 0, array.length);
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, array);
    }

    @Test
    public void can_sort_array_with_quick_sort_with_random_pivot() {
        int[] array = {2, 5, 1, 3, 23, 41};

        quickSortSolver.quickSortRandomPivot(array, 0, array.length);
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, array);
    }
}
