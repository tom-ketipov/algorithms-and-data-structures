package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursivePowerTest {
    private RecursivePower recursivePowerSolver;

    @BeforeEach
    public void setUp() {
        recursivePowerSolver = new RecursivePower();
    }

    @Test
    public void can_calculate_number_power_recursively() {
        int number = 5;
        int power = 2;

        assertEquals(25, recursivePowerSolver.recursivePower(number, power));
    }

    @Test
    public void can_calculate_number_for_zero_power_recursively() {
        int number = 5;
        int power = 0;

        assertEquals(1, recursivePowerSolver.recursivePower(number, power));
    }

    @Test
    public void can_calculate_zero_power_recursively() {
        int number = 0;
        int power = 250;

        assertEquals(0, recursivePowerSolver.recursivePower(number, power));
    }
}