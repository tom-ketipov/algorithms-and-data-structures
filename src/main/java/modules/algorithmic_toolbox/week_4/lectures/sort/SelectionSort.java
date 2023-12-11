package modules.algorithmic_toolbox.week_4.lectures.sort;


import static services.ValidationService.validateNotNull;

public class SelectionSort {
    public final static String NON_NULL_ARRAY_EXCEPTION_MESSAGE = "The input array must not be null.";

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
     * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection Sort (Wikipedia)</a>
     * <p>
     * Time complexity: O(n2)
     */
    public int[] selectionSort(int[] array) {
        validateNotNull(array, NON_NULL_ARRAY_EXCEPTION_MESSAGE);

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
}
