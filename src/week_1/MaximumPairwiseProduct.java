package week_1;

import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumPairwiseProduct {
    public static long maxPairwiseProduct(long[] numbersArray) {
        // sort the array of numbers
        Arrays.sort(numbersArray);
        return numbersArray.length >= 2 ? numbersArray[numbersArray.length - 1] * numbersArray[numbersArray.length - 2] : numbersArray[0];
    }

    private static long maxPairwiseProductBruteForce(long[] numbersArray) {
//        grab the first max index from the array
        int firstMaxIndex = 0;
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] > numbersArray[firstMaxIndex]) {
                firstMaxIndex = i;
            }
        }

        // grab the second max index from the array
        int secondMaxIndex = 0;
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] > numbersArray[secondMaxIndex] && firstMaxIndex != i) {
                secondMaxIndex = i;
            }
        }

        // return the result of their multiplication
        return numbersArray[firstMaxIndex] * numbersArray[secondMaxIndex];
    }

    private static void validatePairwiseProduct(long[] arr) {
        long resultOne = maxPairwiseProduct(arr);
        long resultTwo = maxPairwiseProductBruteForce(arr);

        if (resultOne == resultTwo) {
            System.out.println("\u001B[32m" + "Test Passed ✅" + "\u001B[0m" + "\n");
        } else {
            System.err.println("Result of maxPairwiseProduct() was: " + resultOne);
            System.err.println("Result of maxPairwiseProductBruteForce() was: " + resultTwo);
            throw new RuntimeException("Test Failed ❌");
        }
    }

    /**
     * Generates an {@link Array} with random
     *
     * @param length - length of the array
     * @return - generated {@link Array}
     */
    private static long[] generateArray(int length) {
        if (length <= 1) {
            throw new InvalidParameterException("Length cannot be less or equal to 1.");
        }

        long[] array = new long[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = generateRandomNumberInRange(-500000, 500000);
        }

        return array;
    }

    /**
     * Generates a random long number in a range
     *
     * @param min - min number value allowed
     * @param max - max number value allowed
     * @return - generated number
     */
    private static long generateRandomNumberInRange(int min, int max) {
        return (long) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arrLength = scanner.nextInt();
        long[] arr = new long[arrLength];

        int i = 0;
        while (arrLength-- > 0) {
            arr[i++] = scanner.nextInt();
        }

        System.out.println(maxPairwiseProduct(arr));
    }
}
