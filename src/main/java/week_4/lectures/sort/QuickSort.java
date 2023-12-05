package week_4.lectures.sort;

public class QuickSort {
    /**
     * Sorts the given array using the QuickSort algorithm.
     *
     * @param array the array to be sorted
     * @param low   the starting index of the array or subarray to be sorted
     * @param high  the ending index of the array or subarray to be sorted
     */
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, array.length);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * This method implements the QuickSort algorithm with a randomly chosen pivot element for sorting an integer array.
     * The random pivot selection helps mitigate the worst-case scenario of QuickSort.
     *
     * @param array the array to be sorted
     * @param low   the starting index of the array or subarray to be sorted
     * @param high  the ending index of the array or subarray to be sorted
     */
    public void quickSortRandomPivot(int[] array, int low, int high) {
        if (low < high) {
            int random = generateRandomIntInRange(low, high);
            swap(array, low, random);

            int pivotIndex = partition(array, low, array.length);
            quickSortRandomPivot(array, low, pivotIndex - 1);
            quickSortRandomPivot(array, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array and returns the index of the pivot element.
     *
     * @param array the array to be partitioned
     * @param left  the starting index of the array or subarray to be partitioned
     * @param right the ending index of the array or subarray to be partitioned
     * @return the index of the pivot element after partitioning
     */
    private int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left + 1;

        for (int j = i; j < right; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, left, i - 1);
        return i - 1;
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

    /**
     * Generates a random integer within the specified range [min, max].
     *
     * @param min the inclusive lower bound of the random number
     * @param max the inclusive upper bound of the random number
     * @return a pseudo-random integer between min and max (inclusive)
     * @throws IllegalArgumentException if min is greater than max
     */
    public int generateRandomIntInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range. The minimum value must be less than or equal to the maximum value.");
        }

        return (int) ((Math.random() * (max - min)) + min);
    }
}
