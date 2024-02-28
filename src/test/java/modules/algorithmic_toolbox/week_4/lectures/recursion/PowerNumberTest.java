package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerNumberTest {
    private PowerNumber powerNumberSolver;

    @BeforeEach
    public void setUp() {
        powerNumberSolver = new PowerNumber();
    }

    @Test
    public void can_calculate_number_power_with_linear_function() {
        int number = 2, power = 5;
        assertEquals(32, powerNumberSolver.linearPower(number, power));
    }

    @Test
    public void can_calculate_negative_number_power_with_linear_function() {
        int number = -2, power = 4;
        assertEquals(16, powerNumberSolver.linearPower(number, power));
    }

    @Test
    public void linear_function_throws_exception_for_negative_power_input() {
        int number = 52, power = -3;
        try {
            powerNumberSolver.linearPower(number, power);
        } catch (IllegalArgumentException e) {
            assertEquals("The value must be between 0 and 2,147,483,647.", e.getMessage());
        }
    }

    @Test
    public void can_calculate_number_power_with_recursive_function() {
        int number = 2, power = 5;
        assertEquals(32, powerNumberSolver.recursivePower(number, power));
    }

    @Test
    public void can_calculate_negative_number_power_with_recursive_function() {
        int number = -2, power = 4;
        assertEquals(16, powerNumberSolver.recursivePower(number, power));
    }

    @Test
    public void recursive_function_throws_exception_for_negative_power_input() {
        int number = 52, power = -3;
        try {
            powerNumberSolver.recursivePower(number, power);
        } catch (IllegalArgumentException e) {
            assertEquals("The value must be between 0 and 2,147,483,647.", e.getMessage());
        }
    }
}