package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GCDTest {
    private GCD gcdSolver;

    @BeforeEach
    public void setUp() {
        gcdSolver = new GCD();
    }

    @Test
    public void can_find_gcd_with_linear_function() {
        int a = 270, b = 192;
        assertEquals(6, gcdSolver.linearGCDWithEuclidAlgorithm(a, b));
    }

    @Test
    public void can_find_gcd_with_of_one_with_linear_function() {
        int a = 333, b = 223;
        assertEquals(1, gcdSolver.linearGCDWithEuclidAlgorithm(a, b));
    }

    @Test
    public void can_find_gcd_with_recursive_function() {
        int a = 270, b = 192;
        assertEquals(6, gcdSolver.recursiveGCDWithEuclidAlgorithm(a, b));
    }

    @Test
    public void can_find_gcd_with_of_one_with_recursive_function() {
        int a = 333, b = 223;
        assertEquals(1, gcdSolver.recursiveGCDWithEuclidAlgorithm(a, b));
    }
}