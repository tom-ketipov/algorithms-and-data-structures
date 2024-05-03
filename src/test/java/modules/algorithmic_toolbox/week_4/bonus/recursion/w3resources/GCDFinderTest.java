package modules.algorithmic_toolbox.week_4.bonus.recursion.w3resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GCDFinderTest {

    private GCDFinder gcdFinder;

    @BeforeEach
    void setUp() {
        gcdFinder = new GCDFinder();
    }

    @Test
    public void should_accurately_calculate_gcd_of_two_positive_even_numbers() {
        int a = 20;
        int b = 30;

        Assertions.assertEquals(10, gcdFinder.findGCD(a, b));
    }

    @Test
    public void should_accurately_calculate_gcd_of_two_equal_numbers() {
        int a = 20;
        int b = 20;

        Assertions.assertEquals(a, gcdFinder.findGCD(a, b));
    }

    @Test
    public void should_accurately_calculate_gcd_of_two_prime_numbers() {
        int a = 13;
        int b = 7;

        Assertions.assertEquals(1, gcdFinder.findGCD(a, b));
    }

    @Test
    public void should_return_the_second_number_as_gcd_when_the_first_input_is_zero() {
        int a = 0;
        int b = 10;

        Assertions.assertEquals(b, gcdFinder.findGCD(a, b));
    }

    @Test
    public void should_return_the_first_number_as_gcd_when_the_second_input_is_zero() {
        int a = 20;
        int b = 0;

        Assertions.assertEquals(a, gcdFinder.findGCD(a, b));
    }

    @Test
    public void should_return_zero_as_gcd_when_both_input_numbers_are_zero() {
        int a = 0;
        int b = 0;

        Assertions.assertEquals(a, gcdFinder.findGCD(a, b));
    }

    @Test
    public void should_accurately_calculate_gcd_when_one_of_the_inputs_is_negative_number() {
        int a = -20;
        int b = 25;

        Assertions.assertEquals(5, gcdFinder.findGCD(a, b));
    }
}