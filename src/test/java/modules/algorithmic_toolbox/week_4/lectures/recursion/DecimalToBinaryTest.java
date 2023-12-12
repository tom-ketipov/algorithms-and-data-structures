package modules.algorithmic_toolbox.week_4.lectures.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ValidationMessages;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToBinaryTest {
    private DecimalToBinary decimalToBinarySolver;

    @BeforeEach
    public void setUp() {
        decimalToBinarySolver = new DecimalToBinary();
    }

    @Test
    public void can_convert_decimal_to_binary_with_linear_function() {
        int decimal = 123;
        assertEquals("1111011", decimalToBinarySolver.linearDecimalToBinary(decimal));
    }

    @Test
    public void linear_function_throws_exception_for_negative_input() {
        try {
            decimalToBinarySolver.linearDecimalToBinary(-1);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void can_convert_decimal_to_binary_with_recursive_function() {
        int decimal = 123;
        assertEquals("1111011", decimalToBinarySolver.recursiveDecimalToBinary(decimal));
    }

    @Test
    public void a() {
        int decimal = 13;
        assertEquals("1101", decimalToBinarySolver.recursiveDecimalToBinary(decimal));
    }

    @Test
    public void b() {
        int decimal = 100;
        assertEquals("1100100", decimalToBinarySolver.decimalToBinary(decimal));
    }

    @Test
    public void linear_function_throws_exception_for_recursive_input() {
        try {
            decimalToBinarySolver.recursiveDecimalToBinary(-1);
        } catch (IllegalArgumentException e) {
            assertEquals(ValidationMessages.NON_NEGATIVE_NUMBER_EXCEPTION_MESSAGE, e.getMessage());
        }
    }
}