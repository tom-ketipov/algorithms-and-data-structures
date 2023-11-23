package week_3.maximum_advertisement_revenue;

import java.util.Arrays;
import java.util.Scanner;

public class DotProducts {
    /*
            Problem: The Maximum Product of Two Sequences Problem (e.g Maximum Advertisement Revenue)
            We have n advertising slots that we want to sell to advertisers.
            Each slot gets a different number of clicks and each advertiser is willing to pay a different amount.
            How do you pair the advertiser with the slot to maximize you click-revenue?

            Problem: Find the maximum dot product of two sequences of numbers.
            Inputs:	Two sequences of n positive integers.
            Output:	The maximum sum of pair-wise multiplications of the values.
            ================================================================================================
            Time complexity: O(n log n)
     */
    public static long maxDotProduct(int[] a, int[] b) {
        //write your code here
        Arrays.sort(a);
        Arrays.sort(b);

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += (long) a[i] * (long) b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}
