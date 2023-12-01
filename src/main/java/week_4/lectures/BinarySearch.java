package week_4.lectures;

public class BinarySearch {
    public int binarySearch(int[] numbers, int number) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int midIndex = (low + high) / 2;
            int midIndexValue = numbers[midIndex];

            if (midIndexValue == number) return midIndex;
            if (midIndexValue > number) {
                high = midIndex - 1;
            } else {
                low = midIndex + 1;
            }
        }
        return -1;
    }
}
