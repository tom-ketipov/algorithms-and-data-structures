package modules.core;

public class BaseSolver {

    /**
     * Swaps the elements at the specified indices in the given array.
     *
     * @param array  the array in which to swap elements
     * @param indexA the index of the first element to be swapped
     * @param indexB the index of the second element to be swapped
     */
    protected void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    protected int generateNumberInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
