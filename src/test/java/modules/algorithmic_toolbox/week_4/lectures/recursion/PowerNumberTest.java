package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ValidationMessages;

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
            assertEquals(ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
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
            assertEquals(ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}