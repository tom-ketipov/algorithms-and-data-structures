package modules.algorithmic_toolbox.week_2.prime;

import enums.ValidationMessageType;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenesPrimeNumbersGenerator {

    /**
     * Generates a list of all prime numbers up to a specified boundary using the Sieve of Eratosthenes algorithm.
     * This method first marks all non-prime numbers up to the boundary using an internal boolean array
     * (where false indicates non-prime, and true indicates prime), and then collects all prime numbers
     * into a list to return.
     *
     * @param boundary the upper limit (exclusive) for prime numbers generation. Must be greater than 1.
     * @return a List<Integer> containing all prime numbers up to the specified boundary.
     * @throws IllegalArgumentException if boundary is less than or equal to 1, with a specific error message.
     */
    public List<Integer> generatePrimeNumbersArray(int boundary) {
        Validate.isTrue(boundary > 1, ValidationMessageType.BELOW_MINIMUM_ERROR.getMessage(2));

        boolean[] primeNumbersCache = markPrimesUntil(boundary);
        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 0; i < primeNumbersCache.length; i++) {
            if (primeNumbersCache[i]) primeNumbers.add(i);
        }

        return primeNumbers;
    }

    /**
     * Utilizes the Sieve of Eratosthenes algorithm to mark prime numbers up to a specified boundary.
     * The method creates and returns an array of booleans representing numbers up to the boundary where
     * true indicates that the index is a prime number, and false indicates it is not.
     *
     * @param boundary the upper limit (inclusive) up to which prime numbers will be marked.
     * @return a boolean array representing marked primes up to the boundary.
     */
    private boolean[] markPrimesUntil(int boundary) {
        boolean[] primes = new boolean[boundary + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= boundary; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= boundary; j += i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}
