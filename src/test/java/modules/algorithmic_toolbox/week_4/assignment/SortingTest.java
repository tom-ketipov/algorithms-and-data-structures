package modules.algorithmic_toolbox.week_4.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingTest {
    private Sorting sortingSolver;

    @BeforeEach
    public void setUp() {
        sortingSolver = new Sorting();
    }

    @Test
    public void can_sort_array_with_duplicate_elements() {
        int[] array = {2, 3, 9, 2, 9};
        sortingSolver.randomizedQuickSort(array);

        assertArrayEquals(new int[]{2, 2, 3, 9, 9}, array);
    }

    @Test
    public void can_sort_array_with_distinct_elements() {
        int[] array = {2, 3, 8, 1, 9};
        sortingSolver.randomizedQuickSort(array);

        assertArrayEquals(new int[]{1, 2, 3, 8, 9}, array);
    }
}
