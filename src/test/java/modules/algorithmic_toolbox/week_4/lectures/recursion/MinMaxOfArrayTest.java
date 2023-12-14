package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxOfArrayTest {
    private MinMaxOfArray minMaxOfArraySolver;

    @BeforeEach
    public void setUp() {
        minMaxOfArraySolver = new MinMaxOfArray();
    }

    @Test
    public void can_get_array_min_with_recursive_function() {
        int[] array = {5, 4, 23, 1, 66, -4};
        assertEquals(-4, minMaxOfArraySolver.recursiveMin(array));
    }

    @Test
    public void can_get_array_max_with_recursive_function() {
        int[] array = {5, 4, 23, 1, 66, -4};
        assertEquals(66, minMaxOfArraySolver.recursiveMax(array));
    }
}