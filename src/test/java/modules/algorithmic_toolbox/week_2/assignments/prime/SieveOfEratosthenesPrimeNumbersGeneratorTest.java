package modules.algorithmic_toolbox.week_2.assignments.prime;

import enums.ValidationMessageType;
import modules.algorithmic_toolbox.week_2.assignments.prime.SieveOfEratosthenesPrimeNumbersGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SieveOfEratosthenesPrimeNumbersGeneratorTest {
    private SieveOfEratosthenesPrimeNumbersGenerator sieveOfEratosthenesPrimeNumbersGenerator;

    @BeforeEach
    public void setUp() {
        sieveOfEratosthenesPrimeNumbersGenerator = new SieveOfEratosthenesPrimeNumbersGenerator();
    }

    @Test
    public void can_find_prime_numbers_until_two() {
        List<Integer> primeNumbers = sieveOfEratosthenesPrimeNumbersGenerator.generatePrimeNumbersArray(2);

        Assertions.assertEquals(1, primeNumbers.size());
        Assertions.assertEquals(2, primeNumbers.get(0));
    }

    @Test
    public void can_find_prime_numbers_until_one_hundred() {
        List<Integer> primeNumbers = sieveOfEratosthenesPrimeNumbersGenerator.generatePrimeNumbersArray(100);

        Assertions.assertEquals(25, primeNumbers.size());
    }

    @Test
    public void can_handle_negative_boundary_parameters() {
        try {
            sieveOfEratosthenesPrimeNumbersGenerator.generatePrimeNumbersArray(-1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }

    @Test
    public void can_handle_zero_boundary_parameters() {
        try {
            sieveOfEratosthenesPrimeNumbersGenerator.generatePrimeNumbersArray(0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }

    @Test
    public void can_handle_one_boundary_parameters() {
        try {
            sieveOfEratosthenesPrimeNumbersGenerator.generatePrimeNumbersArray(1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2), e.getMessage());
        }
    }
}
