package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNumberTest {
    private ReverseNumber reverseNumberSolver;

    @BeforeEach
    public void setUp() {
        reverseNumberSolver = new ReverseNumber();
    }

    @Test
    public void can_reverse_number_with_linear_function() {
        int number = 254;
        assertEquals(452, reverseNumberSolver.linearReverse(number));
    }

    @Test
    public void can_reverse_number_with_recursive_function() {
        int number = 254;
        assertEquals(452, reverseNumberSolver.recursiveReverse(number));
    }
}