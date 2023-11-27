package core;

import java.util.Arrays;

public class BaseSolver {
    private static final String INVALID_ARRAY_INPUT_ERROR = "Array input parameter cannot be null or empty.";
    private static final String NON_NEGATIVE_ARRAY_INDEX_ERROR = "Array index must be a non-negative value.";

    public String getInvalidArrayInputError() {
        return INVALID_ARRAY_INPUT_ERROR;
    }

    public String getNonNegativeArrayIndexError() {
        return NON_NEGATIVE_ARRAY_INDEX_ERROR;
    }

    /**
     * Validates int[] array input to ensure it is not null or empty.
     *
     * @param arr the array to be validated
     * @throws IllegalArgumentException if the array is null or empty
     */
    protected void validate(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(getInvalidArrayInputError());
        }
    }

    /**
     * Validates long[] array input to ensure it is not null or empty.
     *
     * @param arr the array to be validated
     * @throws IllegalArgumentException if the array is null or empty
     */
    protected void validate(long[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(getInvalidArrayInputError());
        }
    }

    /**
     * Validates String[] array input to ensure it is not null or empty.
     *
     * @param arr the array to be validated
     * @throws IllegalArgumentException if the array is null or empty
     */
    protected void validate(String[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(getInvalidArrayInputError());
        }
    }


    /**
     * Validates char[] array input to ensure it is not null or empty.
     *
     * @param arr the array to be validated
     * @throws IllegalArgumentException if the array is null or empty
     */
    protected void validate(char[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException(getInvalidArrayInputError());
        }
    }

    /**
     * Validates int[] array to ensure that all elements are non-negative.
     *
     * @param arr the array to be validated for non-negativity
     * @throws IllegalArgumentException if the array is null or empty, or if any element in the array is negative
     */
    protected void validateNonNegative(int[] arr) {
        validate(arr);

        if (Arrays.stream(arr).anyMatch(value -> value < 0)) {
            throw new IllegalArgumentException(getNonNegativeArrayIndexError());
        }
    }
}
