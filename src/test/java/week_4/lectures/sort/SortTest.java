package week_4.lectures.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {
    private SelectionSort selectionSortSolver;

    @BeforeEach
    public void setUp() {
        selectionSortSolver = new SelectionSort();
    }

    @Test
    public void can_sort_array_with_selection_sort() {
        int[] array = {2, 5, 1, 3, 23, 41};
        assertArrayEquals(new int[]{1, 2, 3, 5, 23, 41}, selectionSortSolver.selectionSort(array));
    }
}
