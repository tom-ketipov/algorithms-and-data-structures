package modules.algorithmic_toolbox.week_4.assignment;

import java.util.Random;

public class Sorting {
    private static final Random RANDOM = new Random();

    public void randomizedQuickSort(int[] numbers) {
        randomizedQuickSort(numbers, 0, numbers.length - 1);
    }

    /**
     * Recursive helper method for randomized quicksort.
     * Partitions the array and recursively applies quicksort to the sub-arrays.
     *
     * @param numbers The array of integers to be sorted.
     * @param low     The starting index of the range to be sorted.
     * @param high    The ending index of the range to be sorted.
     */
    private void randomizedQuickSort(int[] numbers, int low, int high) {
        if (low >= high) return;

        int randomIndex = RANDOM.nextInt(high - low) + low;
        swap(numbers, low, randomIndex);

        int[] pivotIndex = partition(numbers, low, high);
        randomizedQuickSort(numbers, low, pivotIndex[0]);
        randomizedQuickSort(numbers, pivotIndex[1], high);
    }

    /**
     * Partitions the array into three segments: elements less than the pivot,
     * elements equal to the pivot, and elements greater than the pivot.
     *
     * @param array The array of integers to be partitioned.
     * @param low   The starting index of the range to be partitioned.
     * @param high  The ending index of the range to be partitioned.
     * @return An array of two integers representing the boundaries of the partitioned range.
     * The first element is the index of the last element less than the pivot,
     * and the second element is the index of the first element greater than the pivot.
     */
    private int[] partition(int[] array, int low, int high) {
        int pivot = array[low];
        int currentIndex = low;
        int lessThanIndex = low;
        int greaterThanIndex = high;

        while (currentIndex <= greaterThanIndex) {
            if (array[currentIndex] < pivot) {
                swap(array, currentIndex++, lessThanIndex++);
            } else if (array[currentIndex] > pivot) {
                swap(array, currentIndex, greaterThanIndex--);
            } else {
                currentIndex++;
            }
        }
        return new int[]{lessThanIndex - 1, greaterThanIndex + 1};
    }

    /**
     * Swaps elements at the specified indices in the given array.
     *
     * @param array  the array in which elements are to be swapped
     * @param index1 the index of the first element to be swapped
     * @param index2 the index of the second element to be swapped
     */
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
