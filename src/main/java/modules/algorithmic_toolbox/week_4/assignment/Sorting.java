package modules.algorithmic_toolbox.week_4.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {
    private static final Random RANDOM = new Random();

    private static int[] partition3(int[] numbers, int low, int high) {
        int pivot = numbers[low];

        int lesserValuesMaxIndex = low + 1;
        int greaterValuesMinIndex = high - 1;

        // Iterate through the array elements from lesserValuesMaxIndex to greaterValuesMinIndex
        for (int j = lesserValuesMaxIndex; j <= greaterValuesMinIndex; ) {
            if (numbers[j] < pivot) {
                swap(numbers, lesserValuesMaxIndex++, j++);
            } else if (numbers[j] > pivot) {
                swap(numbers, j, greaterValuesMinIndex--);
            } else {
                j++;
            }
        }
        swap(numbers, low, lesserValuesMaxIndex - 1);
        return new int[]{lesserValuesMaxIndex - 1, greaterValuesMinIndex + 1};
    }

    public static void randomizedQuickSort(int[] numbers, int low, int high) {
        if (low >= high) {
            return;
        }
        int randomIndex = RANDOM.nextInt(high - low) + low;
        swap(numbers, low, randomIndex);

        //use partition3
        int[] pivotIndex = partition3(numbers, low, high);
        randomizedQuickSort(numbers, low, pivotIndex[0]);
        randomizedQuickSort(numbers, pivotIndex[1] + 1, high);
    }

    /**
     * Swaps elements at the specified indices in the given array.
     *
     * @param array  the array in which elements are to be swapped
     * @param index1 the index of the first element to be swapped
     * @param index2 the index of the second element to be swapped
     */
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
