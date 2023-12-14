package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeanOfArrayTest {
    private MeanOfArray meanOfArraySolver;

    @BeforeEach
    public void setUp() {
        meanOfArraySolver = new MeanOfArray();
    }

    @Test
    public void can_calculate_mean_of_array_linearly() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(3, meanOfArraySolver.linearMeanOfArray(array));
    }

    @Test
    public void can_calculate_mean_of_array_recursively() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(3, meanOfArraySolver.recursiveMeanOfArray(array, 0));
    }
}