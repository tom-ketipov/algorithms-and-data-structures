package week_4.assignment;

public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int halfPointIndex = left + (right - left) / 2;
            int midIndexValue = array[halfPointIndex];

            if (midIndexValue == target) {
                if (right <= 1 || array[halfPointIndex - 1] != target) {
                    return halfPointIndex;
                } else {
                    right = halfPointIndex - 1;
                }
            } else if (target < midIndexValue) {
                right = halfPointIndex - 1;
            } else {
                left = halfPointIndex + 1;
            }
        }
        return -1;
    }
}
