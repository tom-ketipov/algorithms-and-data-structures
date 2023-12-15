package modules.algorithmic_toolbox.week_4.lectures.sort;


import services.ValidationMessages;

import static services.ValidationService.validateInRange;
import static services.ValidationService.validateNotNull;

public class SelectionSort {

    /**
     * Sorts an array of integers using the Selection Sort algorithm.
     *
     * <p>
     * Selection Sort is an in-place sorting algorithm that works by repeatedly finding the minimum
     * element from the unsorted part of the array and putting it at the beginning.
     * </p>
     *
     * @param array the array of integers to be sorted
     * @return the sorted array in ascending order
     * @throws IllegalArgumentException if the input array is null
     * @implNote Time Complexity: 0(n^2)
     */
    public int[] selectionSort(int[] array) {
        validateNotNull(array, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) minIndex = j;
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public void sort(int[] array) {
        sort(array, 0);
    }

    /**
     * Sorts an array in ascending order using the selection sort algorithm.
     *
     * @param array      The array to be sorted. Must not be null.
     * @param startIndex The index indicating the leftmost element of the current unsorted portion.
     * @throws IllegalArgumentException  If the input array is null.
     * @throws IndexOutOfBoundsException If startIndex is outside the bounds of the array.
     * @implNote Time Complexity: 0(n^2)
     */
    private void sort(int[] array, int startIndex) {
        validateNotNull(array, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateInRange(startIndex, 0, array.length, ValidationMessages.NOT_IN_BOUNDS_OF_ARRAY_EXCEPTION_MESSAGE);

        if (startIndex >= array.length) return;

        swap(array, startIndex, findIndexOfMinimumValue(array, startIndex));
        sort(array, startIndex + 1);
    }

    /**
     * Swaps two elements in an array given their indices.
     *
     * @param array  The array in which elements are to be swapped. Must not be null.
     * @param indexA The index of the first element to be swapped. Must be within the bounds of the array.
     * @param indexB The index of the second element to be swapped. Must be within the bounds of the array.
     * @throws IllegalArgumentException  If the input array is null.
     * @throws IndexOutOfBoundsException If either indexA or indexB is outside the bounds of the array.
     */
    private void swap(int[] array, int indexA, int indexB) {
        validateNotNull(array, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);
        validateInRange(indexA, 0, array.length - 1, ValidationMessages.NOT_IN_BOUNDS_OF_ARRAY_EXCEPTION_MESSAGE);
        validateInRange(indexB, 0, array.length - 1, ValidationMessages.NOT_IN_BOUNDS_OF_ARRAY_EXCEPTION_MESSAGE);

        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    /**
     * Finds the index of the minimum value in an array, starting from a given index.
     *
     * @param array The array in which to find the minimum value. Must not be null.
     * @param left  The index indicating the starting point for finding the minimum value.
     * @return The index of the minimum value in the specified portion of the array.
     * @throws IllegalArgumentException If the input array is null.
     */
    private int findIndexOfMinimumValue(int[] array, int left) {
        validateNotNull(array, ValidationMessages.NOT_NULL_ARRAY_EXCEPTION_MESSAGE);

        int min = left;
        for (int i = min + 1; i < array.length; i++) {
            if (array[min] > array[i]) min = i;
        }
        return min;
    }
}
