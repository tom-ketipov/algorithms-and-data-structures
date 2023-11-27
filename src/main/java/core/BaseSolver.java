package core;

public class BaseSolver {

    /**
     * Validates an array input to ensure it is not null or empty.
     *
     * @param arr the array to be validated
     * @throws IllegalArgumentException if the array is null or empty
     */
    protected void validate(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array input parameter cannot be null or empty.");
        }
    }

    /**
     * Validates an array input to ensure it is not null or empty.
     *
     * @param arr the array to be validated
     * @throws IllegalArgumentException if the array is null or empty
     */
    protected void validate(String[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array input parameter cannot be null or empty.");
        }
    }


    /**
     * Validates an array input to ensure it is not null or empty.
     *
     * @param arr the array to be validated
     * @throws IllegalArgumentException if the array is null or empty
     */
    protected void validate(char[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array input parameter cannot be null or empty.");
        }
    }
}
