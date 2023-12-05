package week_4.lectures.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArraySortTest {
    private SelectionSort selectionSortSolver;
    private MergeSort mergeSortSolver;
    private QuickSort quickSortSolver;

    @BeforeEach
    public void setUp() {
        selectionSortSolver = new SelectionSort();
        mergeSortSolver = new MergeSort();
        quickSortSolver = new QuickSort();
    }

    @Test
    public void can_sort_array_with_selection_sort() {
        int[] array = {2, 5, 1, 3, 23, 41};
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, selectionSortSolver.selectionSort(array));
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
}
