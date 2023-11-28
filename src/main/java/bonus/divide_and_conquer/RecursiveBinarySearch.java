package bonus.divide_and_conquer;

public class RecursiveBinarySearch {
    public int recursiveBinarySearch(int[] numbers, int number, int low, int high) {
        if (low <= high && low < numbers.length) {
            int midIndex = low + ((high - low) / 2);
            int midValue = numbers[midIndex];

            if (number > midValue) {
                return recursiveBinarySearch(numbers, number, midIndex + 1, high);
            } else if (number < midValue) {
                return recursiveBinarySearch(numbers, number, low, midIndex - 1);
            }
            return midIndex;
        }
        return -1;
    }
}
