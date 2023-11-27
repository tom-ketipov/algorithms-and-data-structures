package week_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class APlusBTest {
    private APlusB aPlusBSolver;

    @Test
    public void can_add_two_positive_numbers() {
        aPlusBSolver = new APlusB();
        assertEquals(5, aPlusBSolver.add(2, 3));
    }

    @Test
    public void can_add_two_negative_numbers() {
        aPlusBSolver = new APlusB();
        assertEquals(-45, aPlusBSolver.add(-12, -33));
    }

    @Test
    public void can_add_two_numbers_if_one_is_zero() {
        aPlusBSolver = new APlusB();
        assertEquals(-33, aPlusBSolver.add(0, -33));
    }
}